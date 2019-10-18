package com.ouyue.xiwennews.listener;

import com.ouyue.xiwennews.chche.RabbitRetryCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.util.StringUtils;

public class ConfirmCallBackListener implements RabbitTemplate.ConfirmCallback {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private RabbitRetryCache rabbitRetryCache;

    public ConfirmCallBackListener(RabbitRetryCache rabbitRetryCache) {
		super();
		this.rabbitRetryCache = rabbitRetryCache;
	}

	@Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if(ack){
            if(null != correlationData){
                logger.info("[Rabbit MQ] confirm 消息发送 :correlationData.id=" + correlationData.getId());
                rabbitRetryCache.delForConfirm(correlationData.getId());
            }else{
                logger.info("[Rabbit MQ] confirm 消息发送成功");
            }
        }else{
            if(null != correlationData && !StringUtils.isEmpty(correlationData.getId())){
                logger.info("[Rabbit MQ] confirm 消息发送失败:correlationData.id=" + correlationData.getId());
                rabbitRetryCache.reSendForConfirm(correlationData.getId());
            }else{
                logger.info("[Rabbit MQ] confirm 消息发送失败:" + correlationData);
            }
        }
    }
}