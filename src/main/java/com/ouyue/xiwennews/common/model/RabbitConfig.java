package com.ouyue.xiwennews.common.model;

import java.io.Serializable;
import java.util.List;

/**
 * Rabbit MQ 配置
 */
public class RabbitConfig implements Serializable {

    private String host;
    private int port;
    private String userName;
    private String password;

    private List<RabbitVirtualHostConfig> virtual;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RabbitVirtualHostConfig> getVirtual() {
        return virtual;
    }

    public void setVirtual(List<RabbitVirtualHostConfig> virtual) {
        this.virtual = virtual;
    }
}
