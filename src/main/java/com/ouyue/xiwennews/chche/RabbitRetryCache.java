package com.ouyue.xiwennews.chche;

import com.alibaba.fastjson.JSON;
import com.ouyue.xiwennews.common.constants.Constants;
import com.ouyue.xiwennews.common.constants.RabbitMQConstants;
import com.ouyue.xiwennews.common.model.RetryMessage;
import com.ouyue.xiwennews.config.RabbitMQSenderConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 重试 发送消息缓存对象
 */
@Component
public class RabbitRetryCache {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    protected ListOperations<String, String> listOperations;

    @Resource
    protected HashOperations<String, String, Object> hashOperations;

    @Resource
    private HashOperations<String, String, RetryMessage> hashRetryMessageOperations;

    /**
     * 消息发送 消息计数器
     */
    private Map<String, Integer> CACHE_MSG_SEND_COUNT = new ConcurrentHashMap<>();

    /**
     * 暂时存放已经发送成功 但是需要 rabbit mq confirm 确认的消息体
     */
    private Map<String, Integer> CACHE_MSG_SEND_NEED_CONFIRM = new ConcurrentHashMap<>();

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    /**
     *
     * @param id
     * @param virtualHost
     * @param exchange
     * @param routingKey
     * @param isConfirm
     * @param message
     * @throws Exception
     */
    public void add(String id,  String virtualHost, String exchange, String routingKey, boolean isConfirm, String message) throws Exception{
        RetryMessage msgBody = new RetryMessage();
        msgBody.setId(id);
        msgBody.setVirtualHost(virtualHost);
        msgBody.setExchange(exchange);
        msgBody.setRoutingKey(routingKey);
        msgBody.setMsg(message);
        msgBody.setConfirm(isConfirm);

        String msgBodyJson = JSON.toJSONString(msgBody);
        byte[] msgBodyByte = msgBodyJson.getBytes(Constants.UTF8_CHARSET);
        byte[] idByte = id.getBytes(Constants.UTF8_CHARSET);


        //利用管道,一次性提交
        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                //将消息体数据存储至 hashmap key 中
                connection.hSet(RabbitMQConstants.MQ_MSG_RETRY_DATA_HASH_BYTE_KEY, idByte, msgBodyByte);

                //将消息体Id 存储在 公共的 list key 中
                connection.rPush(RabbitMQConstants.MQ_MSG_TOTAL_KEY_BYTE, id.getBytes(Constants.UTF8_CHARSET));

                logger.info("[Rabbit MQ 重试线程] 增加重复发送消息体,[msg=" + msgBodyJson + "]");
                return null;
            }
        });
    }

    /**
     * 根据消息体 生成唯一的Id
     * @return
     */
    public static String generateId(){
        return UUID.randomUUID().toString();
    }

    /**
     *  在 rabbit mq confirm 返回成功后 将 内存中的id 和 reids 中的数据 清除
     * @param id
     */
    public void delForConfirm(String id) {
        if(!CACHE_MSG_SEND_NEED_CONFIRM.containsKey(id)){
            return;
        }
        byte[] retryMessageIdByte = id.getBytes(Constants.UTF8_CHARSET);
        int retryCount = CACHE_MSG_SEND_NEED_CONFIRM.get(id);
        try{
            //清除 [MQ_MSG_TOTAL_KEY_THIS] [MQ_MSG_RETRY_DATA_HASH_BYTE_KEY]  数据 发往失败队列key中 利用管道,一次性提交
            redisTemplate.executePipelined(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    connection.hDel(RabbitMQConstants.MQ_MSG_RETRY_DATA_HASH_BYTE_KEY, retryMessageIdByte);
                    connection.lRem(RabbitMQConstants.MQ_MSG_TOTAL_KEY_THIS.getBytes(Constants.UTF8_CHARSET), 0, retryMessageIdByte);
                    logger.info("[Rabbit MQ 重试线程]-[RabbitConfirm] 尝试第[" + retryCount + "]消息发送成功,清除[redis]数据");
                    return null;
                }
            });
            logger.info("[Rabbit MQ 重试线程]-[RabbitConfirm] [msgId=" +id + "]尝试第[" + retryCount + "]消息发送成功");
        }catch (Exception e){
            logger.error("[Rabbit MQ 重试线程]-[RabbitConfirm] [msgId=" + id + "]尝试第[" + retryCount + "]消息发送成功.但是清除reids异常", e);
        }finally {
            //清除 [内存] 数据
            CACHE_MSG_SEND_COUNT.remove(id);
            CACHE_MSG_SEND_NEED_CONFIRM.remove(id);
        }
    }

    /**
     * 将 暂时存放在 CACHE_MSG_SEND_NEED_CONFIRM 中的数据 重新放回 CACHE_MSG_SEND_COUNT 中
     * @param id
     */
    public void reSendForConfirm(String id){
        if(!CACHE_MSG_SEND_NEED_CONFIRM.containsKey(id)){
            return;
        }
        int count = CACHE_MSG_SEND_NEED_CONFIRM.get(id);
        logger.info("[Rabbit MQ 重试线程]-[RabbitConfirm] [msgId=" +id + "]尝试第[" + count + "] confirm 返回失败, 重新尝试");
        CACHE_MSG_SEND_NEED_CONFIRM.remove(id);
        CACHE_MSG_SEND_COUNT.put(id, count);
    }

    /**
     * 重复发送消息
     */
    @PostConstruct
    private void init() {


        /**
         * 该线程 只负责 从 [MQ_MSG_TOTAL_KEY] 中 取需要重新发送的消息体 至
         *  [MQ_MSG_TOTAL_KEY_THIS] 中 在将取到的消息体 加载至 缓存中
         *  规则, [MQ_MSG_TOTAL_KEY_THIS].size <= 5
         */
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //1. 先判断归属与当前 [MQ_MSG_TOTAL_KEY_THIS] key 中有无需要重复发送的数据
                    Long lenSelf = listOperations.size(RabbitMQConstants.MQ_MSG_TOTAL_KEY_THIS);

                    if(null != lenSelf && lenSelf.longValue() > 0){
                        List<String> temp = listOperations.range(RabbitMQConstants.MQ_MSG_TOTAL_KEY_THIS, 0, -1);
                        for(Object elem : temp){
                            String retryMessageId = (String) elem;
                            //设置将 消息Id设置到缓存中 同时 尝试发送次数
                            if(!CACHE_MSG_SEND_COUNT.containsKey(retryMessageId) && !CACHE_MSG_SEND_NEED_CONFIRM.containsKey(retryMessageId)){
                                CACHE_MSG_SEND_COUNT.put(retryMessageId, 0);
                                logger.info("[Rabbit MQ 重试线程]-[RetryGetThread] [msgId=" + retryMessageId + "] 开始尝试重新发送");
                            }
                        }
                        try {
                            logger.info("[Rabbit MQ 重试线程]-[RetryGetThread] 线程sleep " + RabbitMQConstants.RETRY_TIME_INTERVAL + " ms");
                            Thread.sleep(RabbitMQConstants.RETRY_TIME_INTERVAL);
                        } catch (InterruptedException e) {
                            logger.info("[Rabbit MQ 重试线程]-[RetryGetThread] 线程 sleep 异常", e);
                        }
                    }else{
                        //2. 判断 [MQ_MSG_TOTAL_KEY] key 中是否需要重新发送的消息体
                        Long totalSize = listOperations.size(RabbitMQConstants.MQ_MSG_TOTAL_KEY);
                        if(null == totalSize || totalSize.longValue() == 0){
                            //2.1 MQ_MSG_TOTAL_KEY 数据没有消息，则线程等待
                            try {
                                logger.info("[Rabbit MQ 重试线程]-[RetryGetThread] 没有需要重新发送的消息,线程sleep " + RabbitMQConstants.RETRY_TIME_INTERVAL + " ms");
                                Thread.sleep(RabbitMQConstants.RETRY_TIME_INTERVAL);
                            } catch (InterruptedException e) {
                                logger.info("[Rabbit MQ 重试线程]-[RetryGetThread] 线程 sleep 异常", e);
                            }
                        }else{
                            int getSize = 5 - (null == lenSelf ? 0 : lenSelf.intValue());
                            for(int i = 0; i < getSize; i++){
                                //3. 尝试从 [MQ_MSG_TOTAL_KEY] key 中 获取消息
                                String  retryMsgId = (String)listOperations.rightPopAndLeftPush(RabbitMQConstants.MQ_MSG_TOTAL_KEY, RabbitMQConstants.MQ_MSG_TOTAL_KEY_THIS);
                                if(null == retryMsgId){
                                    break;
                                }else{
                                    CACHE_MSG_SEND_COUNT.put(retryMsgId, 0);
                                }
                            }
                        }
                    }
                }
            }
        });

        /**
         * 该线程至负责 尝试 发送 [retryGetThread] 将已经在在到 内存中的消息体
         */
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if(CollectionUtils.isEmpty(CACHE_MSG_SEND_COUNT)){
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            logger.info("[Rabbit MQ 重试线程]-[RetrySendThread]线程 sleep 异常", e);
                        }
                    }

                    for(Map.Entry<String, Integer> elem : CACHE_MSG_SEND_COUNT.entrySet()){
                        //1. 设置 count ++1
                        int retryCount = elem.getValue() + 1;
                        elem.setValue(retryCount);

                        //2. 尝试重发 限制 五次
                        if(elem.getValue() <= RabbitMQConstants.RETRY_TIMES){
                            try {
                                sendMsg(elem.getKey(), elem.getValue());
                            }catch (Exception e){
                                logger.error("[Rabbit MQ 重试线程]-[RetrySendThread] [msgId=" + elem.getKey() + "]尝试第[" + elem.getValue() + "]消息发送失败", e);
                            }
                        }else{
                            //发往失败队列key中 利用管道,一次性提交
                            try {
                                redisTemplate.executePipelined(new RedisCallback<Object>() {
                                    @Override
                                    public Object doInRedis(RedisConnection connection) throws DataAccessException {
                                        byte[] msgIdByte = elem.getKey().getBytes(); //id

                                        connection.lPush(RabbitMQConstants.MQ_MSG_TOTAL_FAIL_BYTE_KEY, msgIdByte);
                                        connection.lRem(RabbitMQConstants.MQ_MSG_TOTAL_KEY_THIS.getBytes(Constants.UTF8_CHARSET), 0, elem.getKey().getBytes(Constants.UTF8_CHARSET));
                                        logger.info("[Rabbit MQ 重试线程]-[RetrySendThread] 将消息体[id="+elem.getKey()+"]发送5次失败, 移至[" + RabbitMQConstants.MQ_MSG_TOTAL_FAIL_KEY + "]中");
                                        return null;
                                    }
                                });
                            }catch (Exception e){
                                logger.error("[Rabbit MQ 重试线程]-[RetrySendThread] 将消息体[id="+elem.getKey()+"] 发送5次失败, 移至[" + RabbitMQConstants.MQ_MSG_TOTAL_FAIL_KEY + "]中, 异常", e);
                            }finally {
                                CACHE_MSG_SEND_COUNT.remove(elem.getKey());
                            }
                        }
                    }
                }
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(this::stop));
    }

    /**
     * 重试尝试发送
     * @param retryMessageId
     */
    private void sendMsg(String retryMessageId, int retryCount)throws Exception {
        if (StringUtils.hasText(retryMessageId)) {
            //2. 从redis 中取到需要发送的消息体
            RetryMessage retryMessage = hashRetryMessageOperations.get(RabbitMQConstants.MQ_MSG_RETRY_DATA_HASH_KEY, retryMessageId);
            if(null == retryMessage){
                try{
                    //清除 [redis] 数据
                    listOperations.remove(RabbitMQConstants.MQ_MSG_TOTAL_KEY_THIS, 1, retryMessage);
                    //清除 [内存] 数据
                    CACHE_MSG_SEND_COUNT.remove(retryMessageId);
                    logger.info("[Rabbit MQ 重试线程]-[RetrySendThread] 没有查询到[id=" + retryMessageId +"]的数据");
                    return;
                }catch (Exception e){
                    logger.error("[Rabbit MQ 重试线程]-[RetrySendThread] 没有查询到[id=" + retryMessageId +"]的数据, 清除数据异常", e);
                }
            }

            //3. 尝试重新发送消息
            String exchange = retryMessage.getExchange();
            String routingKey = retryMessage.getRoutingKey();

            RabbitTemplate rabbitTemplate = RabbitMQSenderConfig.getRabbitTemplate(retryMessage.getVirtualHost(), retryMessage.isConfirm());
            rabbitTemplate.setReplyTimeout(0);

            CorrelationData correlationData = new CorrelationData();
            correlationData.setId(retryMessageId);

            rabbitTemplate.convertSendAndReceive(exchange, routingKey, retryMessage.getMsg(), correlationData);

            //4. 后续处理
            if(retryMessage.isConfirm()){
                CACHE_MSG_SEND_NEED_CONFIRM.put(retryMessageId, retryCount);
                CACHE_MSG_SEND_COUNT.remove(retryMessageId);
                logger.info("[Rabbit MQ 重试线程]-[RetrySendThread] [msgId=" + retryMessageId + "]尝试第[" + retryCount + "]消息发送成功,[等待confirm确认]");
            }else{
                byte[] retryMessageIdByte = retryMessageId.getBytes(Constants.UTF8_CHARSET);
                try{
                    //清除 [MQ_MSG_TOTAL_KEY_THIS] [MQ_MSG_RETRY_DATA_HASH_BYTE_KEY]  数据 发往失败队列key中 利用管道,一次性提交
                    redisTemplate.executePipelined(new RedisCallback<Object>() {
                        @Override
                        public Object doInRedis(RedisConnection connection) throws DataAccessException {
                            connection.hDel(RabbitMQConstants.MQ_MSG_RETRY_DATA_HASH_BYTE_KEY, retryMessageIdByte);
                            connection.lRem(RabbitMQConstants.MQ_MSG_TOTAL_KEY_THIS.getBytes(Constants.UTF8_CHARSET), 1, retryMessageIdByte);
                            logger.info("[Rabbit MQ 重试线程]-[RetrySendThread] [msgId=" + retryMessageId + "]尝试第[" + retryCount + "]消息发送成功,清除[redis]数据");
                            return null;
                        }
                    });
                }catch (Exception e){
                    logger.error("[Rabbit MQ 重试线程]-[RetrySendThread] [msgId=" + retryMessageId + "]尝试第[" + retryCount + "]消息发送失败.[msg="+ JSON.toJSONString(retryMessage)+"]", e);
                }

                //清除 [内存] 数据
                CACHE_MSG_SEND_COUNT.remove(retryMessageId);
                logger.info("[Rabbit MQ 重试线程]-[RetrySendThread] [msgId=" + retryMessageId + "]尝试第[" + retryCount + "]消息发送成功.[msg="+ JSON.toJSONString(retryMessage)+"]");
            }
        }
    }

    /**
     * 优雅的停止线程
     */
    public void stop() {
        //使重试发送消息线程跳出循环,使其线程正常停止
        try {
            executorService.shutdownNow();
            Thread.sleep(RabbitMQConstants.ONE_SECOND);
        } catch (InterruptedException e) {
            logger.info("[Rabbit MQ 重试线程] 线程停止异常", e);
        }
    }

    /**
     * 存储需要重新发送的消息体 的 消息体数据
     * @param id
     * @return
     */
    private byte[] buildMsgDetailByteKey(String id){
        return (":" + id).getBytes(Constants.UTF8_CHARSET);
    }

//    private String buildMsgDetailByteKey(String id){
//        return ("mq:msg:retry:data:" + id).getBytes(UTF8_CHARSET);
//    }

}
