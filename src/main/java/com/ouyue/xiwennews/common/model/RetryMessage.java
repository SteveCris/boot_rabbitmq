package com.ouyue.xiwennews.common.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;

/**
 * 重试发送消息体
 */
@JSONType
public class RetryMessage implements Serializable {
    private String id;

    private String virtualHost; //虚拟机
    private String exchange;  //交换机
    private String routingKey; //路由键
    private String msg; // 消息体

    private boolean confirm = false;

    public String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public RetryMessage() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "RetryMessage{" +
                "id='" + id + '\'' +
                ", virtualHost='" + virtualHost + '\'' +
                ", exchange='" + exchange + '\'' +
                ", routingKey='" + routingKey + '\'' +
                ", msg='" + msg + '\'' +
                ", confirm=" + confirm +
                '}';
    }
}
