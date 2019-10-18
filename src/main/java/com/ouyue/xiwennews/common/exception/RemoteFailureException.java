package com.ouyue.xiwennews.common.exception;

/**
 * 类: RemoteFailureException <br>
 * 描述: 远程调用引起的异常。 <br>
 */
public class RemoteFailureException extends BaseException {
	private static final long serialVersionUID = -8227335536836081391L;

	/** 
	 * 标题: 构造器 <br>
	 * 描述: TODO <br>
	 * @param level
	 * @param code 
	 */
	public RemoteFailureException(ExceptionLevel level, ExceptionCode code) {
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
	public RemoteFailureException(String message, ExceptionLevel level, ExceptionCode code) {
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
	public RemoteFailureException(String message, Throwable cause, ExceptionLevel level, ExceptionCode code) {
		this(null,message, cause, level, code);
	}

	
	
	 public RemoteFailureException(String remark,String message, ExceptionLevel level, ExceptionCode code) {
         super(remark,message, level, code);
     }
     
        /** 
      * 标题: 构造器 <br>
      * 描述: TODO <br>
      * @param message
      * @param cause
      * @param level
      * @param code 
      */
     public RemoteFailureException(String remark,String message, Throwable cause, ExceptionLevel level, ExceptionCode code) {
         super(remark,message, cause, level, code);
     }
	
	
	/** 
	 * 标题: 构造器 <br>
	 * 描述: TODO <br>
	 * @param cause
	 * @param level
	 * @param code 
	 */
	public RemoteFailureException(Throwable cause, ExceptionLevel level, ExceptionCode code) {
		super(cause, level, code);
	}

	
   
}
