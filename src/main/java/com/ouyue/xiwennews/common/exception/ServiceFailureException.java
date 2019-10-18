package com.ouyue.xiwennews.common.exception;


/**
 *
 * 类: ServiceFailureException <br>
 */
public class ServiceFailureException extends BaseException {
    private static final long serialVersionUID = -8227335536836081391L;

    /**
     * 标题: 构造器 <br>
     * @param level
     * @param code
     */
    public ServiceFailureException(ExceptionLevel level, ExceptionCode code) {
        super(level, code);
    }

    /**
     * 标题: 构造器 <br>
     * 描述: TODO <br>
     * @param message
     * @param level
     * @param code
     */
    public ServiceFailureException(String message, ExceptionLevel level, ExceptionCode code) {
        this(null, message, level, code);
    }

    /**
     * 标题: 构造器 <br>
     * 描述: TODO <br>
     * @param message
     * @param cause
     * @param level
     * @param code
     */
    public ServiceFailureException(String message, Throwable cause, ExceptionLevel level, ExceptionCode code) {
        this(null, message, cause, level, code);
    }

    public ServiceFailureException(String remark, String message, ExceptionLevel level, ExceptionCode code) {
        super(remark, message, level, code);
    }

    /**
     * 标题: 构造器 <br>
     * @param message
     * @param cause
     * @param level
     * @param code
     */
    public ServiceFailureException(String remark, String message, Throwable cause, ExceptionLevel level,
                                   ExceptionCode code) {
        super(remark, message, cause, level, code);
    }

    /**
     * 标题: 构造器 <br>
     *
     * @param cause
     * @param level
     * @param code
     */
    public ServiceFailureException(Throwable cause, ExceptionLevel level, ExceptionCode code) {
        super(cause, level, code);
    }

}
