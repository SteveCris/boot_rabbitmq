package com.ouyue.xiwennews.common.model;

import java.io.Serializable;

public class RabbitVirtualHostConfig implements Serializable {

    private String virtualName;

    private Integer connection;

    private Integer channel;

    public String getVirtualName() {
        return virtualName;
    }

    public void setVirtualName(String virtualName) {
        this.virtualName = virtualName;
    }

    public Integer getConnection() {
        return connection;
    }

    public void setConnection(Integer connection) {
        this.connection = connection;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "RabbitVirtualHostConfig{" +
                "virtualName='" + virtualName + '\'' +
                ", connection=" + connection +
                ", channel=" + channel +
                '}';
    }
}
