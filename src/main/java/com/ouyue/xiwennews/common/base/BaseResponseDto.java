package com.ouyue.xiwennews.common.base;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类: OpenApiBaseResponseDto <br>
 * 描述: 返回基类<br>
 *
 * @param <MODEL>
 */

public class BaseResponseDto<MODEL> implements Serializable {
	/**  */
	private static final long serialVersionUID = 7497239035875785219L;
	
	
	public static final int SUCCESS_CODE = 200;
	
	public static final String succMsg = "成功";

	/**
	 * 返回码
	 */
	private Integer errorCode;

	/**
	 * 异常描述
	 */
	private String errorMsg;

	/**
	 * 是否成功
	 */
	private Boolean success;



    private MODEL t;
    
    private List<MODEL> tList;

    private Map<String, MODEL> tMap;

    private Map<String, List<MODEL>> tMapList;
	
    public BaseResponseDto() {
        this(SUCCESS_CODE, null);
    }

    public static <T> BaseResponseDto<T> create() {
        return new BaseResponseDto<T>();
    }

    public BaseResponseDto(int errCode, String errMsg) {
        super();
    	setErrorCode(errCode);
		this.errorMsg = errMsg;
    }

    public static <T> BaseResponseDto<T>  success(T t){
        BaseResponseDto<T> res = create();
        res.setErrorCode(SUCCESS_CODE);
        res.setT(t);
        return res;
    }
    public static <T> BaseResponseDto<T>  fail(String message){
        BaseResponseDto<T> res = create();
        res.setErrorCode(-1);
        res.setErrorMsg(message);
        return res;
    }

    @SuppressWarnings("unchecked")
	public <T extends BaseResponseDto<V>, V> T successResponse() {
		try {
			setErrorCode(SUCCESS_CODE);
		} catch (Exception e) {
			return null;
		}
		return (T) this;
	}

    @SuppressWarnings("unchecked")
	public <T extends BaseResponseDto<V>, V> T successResponse(String msg) {
		try {
			setErrorCode(SUCCESS_CODE);
			setErrorMsg(msg);
		} catch (Exception e) {
			return null;
		}
		return (T) this;
	}

    @SuppressWarnings("unchecked")
    public <T extends BaseResponseDto<V>, V> T failResponse(int code, String msg) {
        try {
        	setErrorCode(code);
        	setErrorMsg(msg);
        } catch (Exception e) {
            return null;
        }
        return (T) this;
    }

    public static ConcurrentHashMap<String, Constructor<?>> constructorMap = new ConcurrentHashMap<String, Constructor<?>>();
    
    @SuppressWarnings("unchecked")
    public static <T extends BaseResponseDto<V>, V> T successResponse(Class<T> t) {
        try {
            Constructor<?> constructor = constructorMap.get(t.getName());
            if (constructor == null) {
                Constructor<T> con = t.getConstructor(int.class, String.class);
                constructorMap.putIfAbsent(t.getName(), con);
                return con.newInstance(SUCCESS_CODE, null);
            }
            return (T) constructor.newInstance(SUCCESS_CODE, null);
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T successResponseWithoutCheck(Class<T> t) {
        try {
            Constructor<?> constructor = constructorMap.get(t.getName());
            if (constructor == null) {
                Constructor<T> con = t.getConstructor(int.class, String.class);
                constructorMap.putIfAbsent(t.getName(), con);
                return con.newInstance(SUCCESS_CODE, null);
            }
            return (T) constructor.newInstance(SUCCESS_CODE, null);
        } catch (Exception e) {
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    public static <T> T getResponse(Class<T> t) {
        try {
            Constructor<?> constructor = constructorMap.get(t.getName());
            if (constructor == null) {
                Constructor<T> con = t.getConstructor();
                constructorMap.putIfAbsent(t.getName(), con);
                return con.newInstance();
            }
            return (T) constructor.newInstance();
        } catch (Exception e) {
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    public static <T extends BaseResponseDto<V>, V> T successResponse(Class<T> t, String msg) {
        try {
            Constructor<?> constructor = constructorMap.get(t.getName());
            if (constructor == null) {
                Constructor<T> con = t.getConstructor(int.class, String.class);
                constructorMap.putIfAbsent(t.getName(), con);
                return con.newInstance(SUCCESS_CODE, msg);
            }
            return (T) constructor.newInstance(SUCCESS_CODE, msg);
        } catch (Exception e) {
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    public static <T extends BaseResponseDto<V>, V> T failResponse(Class<T> t, int code, String msg) {
        try {
            Constructor<?> constructor = constructorMap.get(t.getName());
            if (constructor == null) {
                Constructor<T> con = t.getConstructor(int.class, String.class);
                constructorMap.putIfAbsent(t.getName(), con);
                return con.newInstance(code, msg);
            }
            return (T) constructor.newInstance(code, msg);
        } catch (Exception e) {
            return null;
        }
    }

	public void fail(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		setSuccess(false);
	}

    public List<MODEL> gettList() {
        return tList;
    }

    public void settList(List<MODEL> tList) {
        this.tList = tList;
    }

 

    public Map<String, MODEL> gettMap() {
        return tMap;
    }

    public void settMap(Map<String, MODEL> tMap) {
        this.tMap = tMap;
    }

    public MODEL getT() {
        return t;
    }

    public void setT(MODEL t) {
        this.t = t;
    }

    public Map<String, List<MODEL>> gettMapList() {
        return tMapList;
    }

    public void settMapList(Map<String, List<MODEL>> tMapList) {
        this.tMapList = tMapList;
    }

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		if (errorCode != null && errorCode == SUCCESS_CODE) {
			setSuccess(true);
		} else {
			setSuccess(false);
		}
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Boolean getSuccess() {
		return this.success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

    public boolean isSuccess() {
		return errorCode == SUCCESS_CODE;
	}


}
