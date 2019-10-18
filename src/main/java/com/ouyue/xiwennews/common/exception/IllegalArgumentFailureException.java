package com.ouyue.xiwennews.common.exception;

/**
 * 类: IllegalArgumentFailureException <br>
 * 描述: 参数不合法引起的异常。 <br>
 * 作者: 李永刚 hzliyonggang@corp.netease.com <br>
 * 时间: 2016年8月18日 上午10:47:08
 */
public class IllegalArgumentFailureException extends BaseException {
	private static final long serialVersionUID = -8227335536836081391L;

	/** 
	 * 标题: 构造器 <br>
	 * 描述: TODO <br>
	 * 时间: 2016年8月24日 下午1:41:28
	 * @param level
	 * @param code 
	 */
	public IllegalArgumentFailureException(ExceptionLevel level, ExceptionCode code) {
		super(level, code);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * 标题: 构造器 <br>
	 * 描述: TODO <br>
	 * 时间: 2016年8月24日 下午1:41:28
	 * @param message
	 * @param level
	 * @param code 
	 */
	public IllegalArgumentFailureException(String message, ExceptionLevel level, ExceptionCode code) {
		this(null,message, level, code);
		// TODO Auto-generated constructor stub
	}

	
	 public IllegalArgumentFailureException(String remark,String message, ExceptionLevel level, ExceptionCode code) {
	        super(remark,message, level, code);
	    }
	    
	       /** 
	     * 标题: 构造器 <br>
	     * 描述: TODO <br>
	     * 时间: 2016年8月24日 下午1:41:28
	     * @param message
	     * @param cause
	     * @param level
	     * @param code 
	     */
	    public IllegalArgumentFailureException(String remark,String message, Throwable cause, ExceptionLevel level, ExceptionCode code) {
	        super(remark,message, cause, level, code);
	    }
	
	
	
	/** 
	 * 标题: 构造器 <br>
	 * 描述: TODO <br>
	 * 时间: 2016年8月24日 下午1:41:28
	 * @param message
	 * @param cause
	 * @param level
	 * @param code 
	 */
	public IllegalArgumentFailureException(String message, Throwable cause, ExceptionLevel level, ExceptionCode code) {
		this(null,message, cause, level, code);
	}

	/** 
	 * 标题: 构造器 <br>
	 * 描述: TODO <br>
	 * @param cause
	 * @param level
	 * @param code 
	 */
	public IllegalArgumentFailureException(Throwable cause, ExceptionLevel level, ExceptionCode code) {
		super(cause, level, code);
	}

	
   
}
