package com.ouyue.xiwennews.service;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-18 14-30
 */
public interface RabbitMQSenderService {
    /**
     * 发送消息
     * @param virtualHost
     * @param exchange
     * @param routingKey
     * @param msg
     * @throws Exception
     */
    public void send(String virtualHost,
                     String exchange,
                     String routingKey,
                     String msg)throws Exception;



    /**
     * 发送消息 confirm
     * @param virtualHost
     * @param exchange
     * @param routingKey
     * @param msg
     */
    public void sendAndConfirm(String virtualHost,
                               String exchange,
                               String routingKey,
                               String msg)throws Exception;
}
