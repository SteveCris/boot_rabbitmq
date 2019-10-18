package com.ouyue.xiwennews.common.base;
import com.ouyue.xiwennews.common.exception.ExceptionCode;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseResponse<MODEL> implements Serializable {

	/**  */
	private static final long serialVersionUID = 7497239035875785219L;

	/** 成功返回码 */
	public static final int SUCCESS_CODE = 200;

	/** 错误码 */
	private int code;

	/** 错误消息 */
	private String message;

	protected Map<String, Object> result;

	public BaseResponse() {
		this(SUCCESS_CODE, null);
	}

	public BaseResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public boolean isSuccess() {
		return code == SUCCESS_CODE;
	}

	@SuppressWarnings("unchecked")
	public <T extends BaseResponse<V>, V> T successResponse(String msg) {
		try {
			setCode(SUCCESS_CODE);
			setMessage(msg);
		} catch (Exception e) {
			return null;
		}
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	public <T extends BaseResponse<V>, V> T failResponse(int code, String msg) {
		try {
			setCode(code);
			setMessage(msg);
		} catch (Exception e) {
			return null;
		}
		return (T) this;
	}

	public <T extends BaseResponse<V>, V> T failResponse(ExceptionCode exceptionCode, String msg) {
		return failResponse(exceptionCode.intValue(), msg);
	}

	public <T extends BaseResponse<V>, V> T failResponse(ExceptionCode exceptionCode) {
		return failResponse(exceptionCode.intValue(), exceptionCode.toString());
	}

	public static ConcurrentHashMap<String, Constructor<?>> constructorMap = new ConcurrentHashMap<String, Constructor<?>>();

	@SuppressWarnings("unchecked")
	public static <T extends BaseResponse<V>, V> T successResponse(Class<T> t) {
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
	public static <T extends BaseResponse<V>, V> T successResponse(Class<T> t, String msg) {
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
	public static <T extends BaseResponse<V>, V> T failResponse(Class<T> t, int code, String msg) {
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

	public void fail(int code, String msg) {
		this.code = code;
		this.message = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setCode(ExceptionCode code) {
		this.code = code.intValue();
		this.message = code.toString();
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTotal(int total) {
		if (result == null) {
			result = new HashMap<>();
		}
		/*Object object = result.get("pagination");
		if (object != null) {

		}
		*/
//		Map<String,Object> obj=new HashMap<>();
		result.put("total", total);
//		result.put("pagination", obj);
		
		// this.total = total;
	}

	public void setModel(MODEL model) {
		if (result == null) {
			result = new HashMap<>();
		}
		result.put("model", model);
		// this.model = model;
	}
	public void setDestinationTotal(Long total) {
		if (result == null) {
			result = new HashMap<>();
		}
		result.put("destinationTotal", total);
		// this.model = model;
	}
	public void setExpressTotal(Long total) {
		if (result == null) {
			result = new HashMap<>();
		}
		result.put("expressTotal", total);
		// this.model = model;
	}

	public void setDownloadUrl(String downloadUrl) {
		if (result == null) {
			result = new HashMap<>();
		}
		result.put("resultUrl", downloadUrl);
	}

	public void setList(List<MODEL> list) {
		if (result == null) {
			result = new HashMap<>();
		}
		result.put("list", list);
	}

	public void setListWithKey(String key, List<MODEL> list) {
		if (result == null) {
			result = new HashMap<>();
		}
		result.put(key, list);
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public void setModel(String key, Object model) {
		if (result == null) {
			result = new HashMap<>();
		}
		result.put(key, model);
	}

}
