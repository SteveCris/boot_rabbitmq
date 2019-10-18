package com.ouyue.xiwennews.common.exception;

import org.springframework.util.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 类: ExceptionUtil <br>
 * 描述: TODO <br>
 * 时间: 2016年8月18日 上午10:45:31
 */
public final class ExceptionUtil {

    private static final int MAX_ERROR_STACK_LENGTH = 4096;

    /** 确保对象不为空，否则抛出<code>NULL_POINT</code>。 */
    public static <T> T assertNotNull(T object) {
        if (object == null) {
            throw ExceptionType.NULL_POINT.newInstance(ExceptionCode.DEFAULT_ERROR);
        }
        return object;
    }

    /** 确保对象不为空，否则抛出<code>NULL_POINT</code>。 */
    public static <T> T assertNotNull(T object, String msg) {
        if (object == null) {
            throw ExceptionType.SERVICE_FAILURE.newInstance(msg,ExceptionCode.DEFAULT_ERROR,ExceptionLevel.INFO);
        }
        if(object instanceof String){
            String obj = (String) object;
            if (StringUtils.isEmpty(obj)) {
                throw ExceptionType.SERVICE_FAILURE.newInstance(msg,ExceptionCode.DEFAULT_ERROR,ExceptionLevel.INFO);
            }
        }
        
        return object;
    }

    /** 数据库异常。 */
    public static <T> T dbException(ExceptionCode code, ExceptionLevel level) {
        throw ExceptionType.DB_FAILURE.newInstance(code, level);
    }


    /** 数据库异常。 */
    public static <T> T dbException(ExceptionCode code) {
        throw ExceptionType.DB_FAILURE.newInstance(code);
    }
    
    
    /** 数据库异常。 */
    public static <T> T dbException(Throwable e, ExceptionCode code) {
        throw ExceptionType.DB_FAILURE.newInstance(e, code);
    }
    
    /** 数据库异常。 */
    public static <T> T dbException(Throwable e,String msg) {
        throw ExceptionType.DB_FAILURE.newInstance(e, msg);
    }


    /** 数据库异常。 */
    public static <T> T dbException(String msg, ExceptionCode code, ExceptionLevel level) {
        throw ExceptionType.DB_FAILURE.newInstance(code, level, msg);
    }

    /** 业务层异常。 */
    public static <T> T serviceException(ExceptionCode code, ExceptionLevel level) {
        throw ExceptionType.SERVICE_FAILURE.newInstance(code, level);
    }
    
    /** 业务层异常。 */
    public static <T> T serviceException(ExceptionCode code) {
        throw ExceptionType.SERVICE_FAILURE.newInstance(code);
    }
    

    /** 业务层异常。 */
    public static <T> T serviceException(Throwable e, ExceptionCode code, ExceptionLevel level) {
        throw ExceptionType.SERVICE_FAILURE.newInstance(e, code, level);
    }

    /** 业务层异常。 */
    public static <T> T serviceException(String msg, ExceptionCode code, ExceptionLevel level) {
        throw ExceptionType.SERVICE_FAILURE.newInstance(msg, code, level);
    }
    
    public static <T> T serviceException(String msg,  ExceptionLevel level) {
        throw ExceptionType.SERVICE_FAILURE.newInstance(msg, level);
    }
    

    /** 业务层异常。 */
    public static <T> T serviceException(ExceptionCode code, ExceptionLevel level, String remark) {
        throw ExceptionType.SERVICE_FAILURE.newInstance(code, level, remark);
    }

    /** 业务层校验异常。 */
    public static <T> T serviceException(ExceptionCode code, String msg) {
        throw ExceptionType.SERVICE_FAILURE.newInstance(code, msg);
    }

    public static <T> T serviceException(String msg) {
        throw ExceptionType.SERVICE_FAILURE.newInstance(msg,ExceptionLevel.INFO);
    }
    
    /** 业务层异常。 */
    public static <T> T serviceExceptionInfo(String msg) {
        throw ExceptionType.SERVICE_FAILURE.newInstance(msg,ExceptionLevel.INFO);
    }
    
    /** 业务层异常。 */
    public static <T> T serviceExceptionError(String msg) {
        throw ExceptionType.SERVICE_FAILURE.newInstance(msg,ExceptionLevel.ERROR);
    }

    /** 远程调用异常。 */
    public static <T> T remoteException(ExceptionCode code, ExceptionLevel level) {
        throw ExceptionType.REMOTE_FAILURE.newInstance(code, level);
    }

    /** 远程调用异常。 */
    public static <T> T remoteException(Throwable e, ExceptionCode code, ExceptionLevel level) {
        throw ExceptionType.REMOTE_FAILURE.newInstance(e, code, level);
    }

    /** 远程调用异常。 */
    public static <T> T remoteException(String msg, ExceptionCode code, ExceptionLevel level) {
        throw ExceptionType.REMOTE_FAILURE.newInstance(code, level, msg);
    }

    /** 业务层异常。 */
    public static <T> T unknownException(String msg) {
        throw ExceptionType.SERVICE_FAILURE.newInstance(msg);
    }

    /** 业务层异常。 */
    public static <T> T encryptionException(Throwable e, ExceptionCode code) throws Exception {
        throw ExceptionType.ENCRYPTION_FAILURE.newInstance(e, code);
    }

    /**
     * 方法: getThrowableStackTrace <br>
     * 描述: 打印异常消息 <br>
     * 作者: 李永刚 hzliyonggang@corp.netease.com <br>
     * 时间: 2016年8月24日 下午3:01:30
     * 
     * @param t
     * @return
     */
    public static String getThrowableStackTrace(Throwable t) {
        StringWriter sw = new StringWriter(1024*10);
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    
    public static String getThrowableStackTraceWithSize(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        String s = sw.toString();
        if (s.length() > MAX_ERROR_STACK_LENGTH)
            s = s.substring(0, MAX_ERROR_STACK_LENGTH);
        return s;
    }
    
    public static BaseMsgDes operateException(Throwable t) {
        if (t instanceof BaseException) {
            return (BaseException) t;
        }
        return ExceptionType.UN_KNOWN_FAILURE.newInstance(ExceptionCode.DEFAULT_ERROR, t.getMessage());

    }

    /** Assertion错误类型。 */
    public static enum ExceptionType {

        ILLEGAL_ARGUMENT {
            @Override
            BaseException newInstance(Throwable cause, ExceptionLevel level, ExceptionCode code, String message,
                    String remark) {
                return new IllegalArgumentFailureException(remark, message, cause, level, code);
            }
        },
        NULL_POINT {
            @Override
            BaseException newInstance(Throwable cause, ExceptionLevel level, ExceptionCode code, String message,
                    String remark) {
                return new NullPointerFailureException(remark, message, cause, level, code);
            }
        },

        REMOTE_FAILURE {
            @Override
            BaseException newInstance(Throwable cause, ExceptionLevel level, ExceptionCode code, String message,
                    String remark) {
                return new RemoteFailureException(remark, message, cause, level, code);
            }
        },

        DB_FAILURE {
            @Override
            BaseException newInstance(Throwable cause, ExceptionLevel level, ExceptionCode code, String message,
                    String remark) {
                return new DbFailureException(remark, message, cause, level, code);
            }
        },

        SERVICE_FAILURE {
            @Override
            BaseException newInstance(Throwable cause, ExceptionLevel level, ExceptionCode code, String message,
                    String remark) {
                return new ServiceFailureException(remark, message, cause, level, code);
            }
        },

        UN_KNOWN_FAILURE {
            @Override
            BaseException newInstance(Throwable cause, ExceptionLevel level, ExceptionCode code, String message,
                    String remark) {
                return new ServiceFailureException(remark, message, cause, level, code);
            }
        },
        ENCRYPTION_FAILURE{
            @Override
            BaseException newInstance(Throwable cause, ExceptionLevel level, ExceptionCode code, String message,
                                      String remark) {
                return new ServiceFailureException(remark, message, cause, level, code);
            }
        };

        abstract BaseException newInstance(Throwable cause, ExceptionLevel level, ExceptionCode code, String message,
                String remark);

        public BaseException newInstance(Throwable cause) {
            return newInstance(cause, ExceptionLevel.ERROR, ExceptionCode.DEFAULT_ERROR, cause.getMessage(), null);
        }

        public BaseException newInstance(ExceptionCode exceptionCode) {
            return newInstance(null, ExceptionLevel.ERROR, exceptionCode, exceptionCode.toString(), null);
        }

        public BaseException newInstance(ExceptionCode exceptionCode, String msg) {
            return newInstance(null, ExceptionLevel.ERROR, exceptionCode, msg, null);
        }

        public BaseException newInstance(ExceptionCode exceptionCode, ExceptionLevel level) {
            return newInstance(null, level, exceptionCode, exceptionCode.toString(), null);
        }

        public BaseException newInstance(ExceptionCode exceptionCode, ExceptionLevel level, String remark) {
            return newInstance(null, level, exceptionCode, exceptionCode.toString(), remark);
        }

        public BaseException newInstance(String msg) {
            return newInstance(null, ExceptionLevel.ERROR, ExceptionCode.DEFAULT_ERROR, msg, null);
        }

        public BaseException newInstance(Throwable cause, String msg) {
            return newInstance(cause, ExceptionLevel.ERROR, ExceptionCode.DEFAULT_ERROR, msg, null);
        }

        public BaseException newInstance(Throwable cause, ExceptionCode exceptionCode, ExceptionLevel level) {
            return newInstance(cause, level, exceptionCode, exceptionCode.toString(), null);
        }

        public BaseException newInstance(Throwable cause, ExceptionCode exceptionCode) {
            return newInstance(cause, ExceptionLevel.ERROR, exceptionCode, exceptionCode.toString(), null);
        }
        
        public BaseException newInstance(String msg, ExceptionCode exceptionCode, ExceptionLevel level) {
            return newInstance(null, level, exceptionCode, msg, null);
        }
        
        public BaseException newInstance(String msg, ExceptionLevel level) {
            return newInstance(null, level, ExceptionCode.DEFAULT_ERROR, msg, null);
        }

    }
}
