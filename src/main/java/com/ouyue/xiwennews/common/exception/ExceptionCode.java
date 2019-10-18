package com.ouyue.xiwennews.common.exception;

/**
 *
 * 类: ExceptionCode <br>
 * 描述: 异常定义 <br>
 */
public enum ExceptionCode {

    SUCCESS(200, "SUCCESS"),
    DEFAULT_ERROR(2000, "Service exception"),
    BEAN_CONVERT_ERROR(10000, "Data Conversion Differences"),
    PARAMETER_ILLEGAL(409, "Illegal parameters"),
    TEMPLEATE_ERROR(509, "Template exception"),
    PHONE_ERROR(510, "mobile number  incorrect, only support 91 start"),
    PHONE_NOTEXIST(511, "mobile number not exist"),
    PHONE_HAVE_UP(512, "batch send, mobile number limit 50"),
    PHONE_REQUEST_QUICK(513, "request too frequent; please send SMS verification code in 5 minutes."),
    ;


    public static ExceptionCode find(int code) {
        for (ExceptionCode ex : ExceptionCode.values()) {
            if (ex.intValue == code) {
                return ex;
            }
        }
        return DEFAULT_ERROR;
    }

    private int intValue;

    private String des;

    ExceptionCode(int intValue, String des) {
        this.intValue = intValue;
        this.des = des;
    }

    public int intValue() {
        return this.intValue;
    }

    @Override
    public String toString() {
        return this.des;
    }

}
