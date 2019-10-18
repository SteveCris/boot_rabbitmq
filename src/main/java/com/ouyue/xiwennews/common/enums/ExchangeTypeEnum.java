package com.ouyue.xiwennews.common.enums;

/**
 * 交换机类型
 */
public enum ExchangeTypeEnum {

    DIRECT("direct"),
    TOPIC("topic"),
    FANOUT("fanout"),
    HEADERS("headers");

    private String type;

    ExchangeTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
