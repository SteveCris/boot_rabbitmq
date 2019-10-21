package com.ouyue.xiwennews.consumer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.support.DefaultMessagePropertiesConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-21 11-42
 */

@Component
public class RabbitMQProcess {

    private Logger logger = LoggerFactory.getLogger(RabbitMQProcess.class);

    private final RabbitConsumerProperties rabbitConsumerProperties;

    private final String delay;

    public final String dlx;

    public RabbitMQProcess(RabbitConsumerProperties rabbitConsumerProperties) {
        super();
        this.rabbitConsumerProperties = rabbitConsumerProperties;
        delay = rabbitConsumerProperties.getDelaySuffix();
        dlx = rabbitConsumerProperties.getDlxSuffix();
    }

    /**
     *
     * @param retryCallBack
     *            处理体
     * @param message
     *            消息
     * @param channel
     *            管道
     * @param isDelay
     *            是不是 需要 延迟消费
     */
    public void execute(RetryCallBack retryCallBack, Message message, Channel channel, boolean isDelay) {

        // 延迟被消费处理
        if (isDelay) {
            int priority = message.getMessageProperties().getPriority();
            if (priority == 0) {
                // 延迟消费 进行重试
                failureRepeatProcess(message, channel);
                return;
            }
        }
        // 如果需要失败重试
        boolean processMessage = retryCallBack.processMessage();
        if (!processMessage) {
            // 延迟消费 进行重试
            failureRepeatProcess(message, channel);
        }
    }

    /**
     * 重试处理消息(如果要进入死信，可以抛出异常AmqpRejectAndDontRequeueException，直接进入死信队列，不重试)
     *
     * @param message
     * @param channel
     * @throws IOException
     */
    public void failureRepeatProcess(Message message, Channel channel) {
        MessageProperties messageProperties = message.getMessageProperties();
        // 延迟队列中重试次数
        String[] intervals = rabbitConsumerProperties.getIntervals().split("/");
        int n = intervals.length;
        // 优先级来代替重试次数
        int priority = messageProperties.getPriority();
        try {
            if (priority < n) {

                // 设置消息的延迟消费时间
                messageProperties
                        .setExpiration(String.valueOf(TimeUnit.SECONDS.toMillis(Long.parseLong(intervals[priority]))));

                message.getMessageProperties().setPriority(++priority);

                AMQP.BasicProperties props = new DefaultMessagePropertiesConverter().fromMessageProperties(messageProperties,
                        "UTF-8");

                // 打开确认机制
                channel.confirmSelect();
                // 进行推送到延迟重试队列中
                channel.basicPublish(replaceDelay(messageProperties.getReceivedExchange()),
                        replaceDelay(messageProperties.getConsumerQueue()), props, message.getBody());
                // 阻塞同步确认
                if (!channel.waitForConfirms(3000)) {
                    logger.error("推送到重试延迟队列失败，进入死信队列,消息体{}", message);
                    // // 进入死信
                    channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                }
            } else {
                logger.error("重试{}后失败，进入死信队列,消息体{}", priority, message);
                // 进入死信
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            }
        } catch (Exception e) {
            logger.error("channel调用失败，消息体:" + message, e);
        }
    }

    /**
     * 声明相关队列交换机
     *
     * @param
     * @param cachingConnectionFactory
     */
    public void declare(String queueName, String exchange, String routingKey, String exchangeType,
                        CachingConnectionFactory cachingConnectionFactory) {
        Assert.notNull(queueName, "队列名称不能为空");
        Assert.notNull(exchange, "交换机不能为空");
        Assert.notNull(routingKey, "路由键不能为空，可以为空字符串");

        // 动态创建queue exchange并建立绑定关系
        Channel channel = null;

        String delayQueueName = queueName + delay;
        String dlxQueueName = queueName + dlx;
        String dlxExchange = exchange + dlx;
        String delayExchange = exchange + delay;
        String delayRoutingKey = queueName + delay;
        String dlxRoutingKey = queueName + dlx;
        try {
            channel = cachingConnectionFactory.createConnection().createChannel(false);
            // 1、声明队列
            // 1)声明一个消费者队列
            Map<String, Object> args = new HashMap<>();
            args.put("x-dead-letter-exchange", dlxExchange);
            args.put("x-dead-letter-routing-key", dlxRoutingKey);
            channel.queueDeclare(queueName, true, false, false, args);
            // 2)声明一个消费者延迟消费队列
            Map<String, Object> delayArgs = new HashMap<>();
            delayArgs.put("x-dead-letter-exchange", dlxExchange);
            delayArgs.put("x-dead-letter-routing-key", routingKey);
            // 毫秒为单位
            delayArgs.put("x-message-ttl", TimeUnit.SECONDS.toMillis(rabbitConsumerProperties.getMaxInterval()));
            channel.queueDeclare(delayQueueName, true, false, false, delayArgs);
            // 3)声明一个死信队列
            channel.queueDeclare(dlxQueueName, true, false, false, null);
            // 2、声明交换机
            // 声明一个业务交换机（可以是任意类型的交换机）

            // 可延迟的 3.5.5新增的
            // Map<String, Object> delayExchangeArgs=new HashMap<>();
            // delayExchangeArgs.put("x-delayed-type", exchangeType);
            // channel.exchangeDeclare(exchange, "x-delayed-message", true, false, false,
            // delayExchangeArgs);
            channel.exchangeDeclare(exchange, exchangeType, true);
            // 什么一个延迟交换机(直连)
            channel.exchangeDeclare(delayExchange, "direct", true);
            // 声明一个消费者死信交换机(直连)
            channel.exchangeDeclare(dlxExchange, "direct", true);
            // 3、建立绑定关系
            // 建立绑定（queue-exchange）
            // 业务交换机-业务队列
            channel.queueBind(queueName, exchange, routingKey);
            // 延迟交换机-延迟队列
            channel.queueBind(delayQueueName, delayExchange, delayRoutingKey);
            // 死信交换机-业务队列
            channel.queueBind(queueName, dlxExchange, routingKey);
            // 死信交换机-死信队列
            channel.queueBind(dlxQueueName, dlxExchange, dlxRoutingKey);

        } catch (IOException e) {
            logger.error("mq declare queue exchange fail ", e);
        } finally {
            try {
                if (channel != null) {
                    channel.close();
                }
            } catch (Exception e) {
                logger.error("mq channel close fail", e);
            }
        }

    }

    private String replaceDelay(String name) {
        int index = name.lastIndexOf('_');
        if (index == -1) {
            return name + delay;
        } else {
            return name.substring(0, index) + delay;
        }
    }
}
