package com.ouyue.xiwennews.common.exception;

/**
 * 类: NullPointFailureException <br>
 * 描述: 空值引起异常。 <br>
 */
public class NullPointerFailureException extends BaseException {
	private static final long serialVersionUID = -8227335536836081391L;

	/** 
	 * 标题: 构造器 <br>
	 * 描述: TODO <br>
	 * @param level
	 * @param code 
	 */
	public NullPointerFailureException(ExceptionLevel level, ExceptionCode code) {
		super(level, code);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * 标题: 构造器 <br>
	 * 描述: TODO <br>
	 * @param message
	 * @param level
	 * @param code 
	 */
	public NullPointerFailureException(String message, ExceptionLevel level, ExceptionCode code) {
		this(null,message, level, code);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * 标题: 构造器 <br>
	 * 描述: TODO <br>
	 * @param message
	 * @param cause
	 * @param level
	 * @param code 
	 */
	public NullPointerFailureException(String message, Throwable cause, ExceptionLevel level, ExceptionCode code) {
		super(null,message, cause, level, code);
	}

	
	
	 public NullPointerFailureException(String remark,String message, ExceptionLevel level, ExceptionCode code) {
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
     public NullPointerFailureException(String remark,String message, Throwable cause, ExceptionLevel level, ExceptionCode code) {
         super(remark,message, cause, level, code);
     }
 
	
	/** 
	 * 标题: 构造器 <br>
	 * 描述: TODO <br>
	 * 时间: 2016年8月24日 下午1:41:28
	 * @param cause
	 * @param level
	 * @param code 
	 */
	public NullPointerFailureException(Throwable cause, ExceptionLevel level, ExceptionCode code) {
		super(cause, level, code);
	}

	
   
}
