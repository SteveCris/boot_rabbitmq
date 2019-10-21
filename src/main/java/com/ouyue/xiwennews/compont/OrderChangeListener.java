package com.ouyue.xiwennews.compont;

import com.ouyue.xiwennews.service.UserLikeService;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.stereotype.Component;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-18 16-40
 */
/*

@Component
public class OrderChangeListener {
    private static Logger LOGGER = LoggerFactory.getLogger(OrderChangeListener.class);

    @Autowired
    UserLikeService userLikeService;
    @RabbitListener(queues = { "queue.event.jdq.audit.process" })
    public void processAuditEvent(AuditEvent auditEvent, Message message, Channel channel) {

        LOGGER.info("收到审核事件，开始处理：{}", auditEvent);
        try {
            rabbitMQProcess.execute(retryTime -> {
                return userLikeService.createOrderPushEvent(null, null, auditEvent.getEventHeader().getOrderId());
            }, message, channel, true);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException("", e);
        }
    }
}
*/
