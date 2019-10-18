package com.ouyue.xiwennews.common.exception;
import com.ouyue.xiwennews.common.enums.ServiceCodeEnum;

/**
 * 业务异常
 */
public class ServiceException extends RuntimeException {

    private int errorCode = ServiceCodeEnum.ERROR.getCode();

    public ServiceException() {
        super();
    }


    public ServiceException(ServiceCodeEnum serviceCodeEnum) {
        super(serviceCodeEnum.getRemark());
        this.errorCode = serviceCodeEnum.getCode();
    }

    public ServiceException(ServiceCodeEnum serviceCodeEnum, String message) {
        super(message);
        this.errorCode = serviceCodeEnum.getCode();
    }

    public ServiceException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }


    public ServiceException(String message, Throwable cause) {
        super("Loan Rabbit MQ exception:" + message, cause);
    }

    public int getErrorCode() {
        return errorCode;
    }
}
