package com.ouyue.xiwennews.service.impl;

import com.ouyue.xiwennews.chche.RabbitRetryCache;
import com.ouyue.xiwennews.common.constants.Constants;
import com.ouyue.xiwennews.config.RabbitMQSenderConfig;
import com.ouyue.xiwennews.service.RabbitMQSenderService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-18 14-31
 */

@Service
public class RabbitMQSenderServiceImpl implements RabbitMQSenderService {

    @Autowired
    private RabbitRetryCache rabbitRetryCache;
    @Override
    public void send(String virtualHost, String exchange, String routingKey, String msg) throws Exception {
        Message msgBody = MessageBuilder.withBody(msg.getBytes(Constants.UTF8_CHARSET))
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setContentEncoding(Constants.UTF8)
                .build();

        RabbitTemplate tempTemplate = RabbitMQSenderConfig.getRabbitTemplate(virtualHost, false);
        tempTemplate.setReplyTimeout(0);
        String id = RabbitRetryCache.generateId();

        try {
            tempTemplate.convertSendAndReceive(exchange, routingKey, msgBody, new CorrelationData(id));
        } catch (Exception e) {
            // 重试 发送消息
            rabbitRetryCache.add(id, virtualHost,exchange, routingKey, false, msg);
        }
    }

    @Override
    public void sendAndConfirm(String virtualHost, String exchange, String routingKey, String msg) throws Exception {

    }
}
