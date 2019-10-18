package com.ouyue.xiwennews.common.enums;

/**
 * 业务码定义
 */
public enum ServiceCodeEnum {
    SUCCESS(1, "成功"),
    ERROR(-1, "业务错误"),
    PARAM_ILLEGAL(-2, "参数非法"),

    QUEUE_DUPLICATE(-3, "队列重复定义"),
    QUEUE_UNDEFINED(-4, "队列未定义")
    ;

    private int code;
    private String remark;
    ;

    ServiceCodeEnum(int code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public int getCode() {
        return code;
    }


    public String getRemark() {
        return remark;
    }
}
