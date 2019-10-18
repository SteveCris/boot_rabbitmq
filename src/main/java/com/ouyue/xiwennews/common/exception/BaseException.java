package com.ouyue.xiwennews.common.exception;


/**
 *
 * 类: BaseException <br>
 * 描述: 运行时异常基类<br>
 */
public class BaseException extends RuntimeException implements BaseMsgDes{
    
    /**  */
	private static final long serialVersionUID = -5335258347966254381L;
	
	private final ExceptionLevel level;
	
	private final ExceptionCode code;
	
	private String remark;

	protected String outPusMsg;

	public String getOutPusMsg() {
		return outPusMsg;
	}

	public void setOutPusMsg(String outPusMsg) {
		this.outPusMsg = outPusMsg;
	}

	/**
	 * 标题: 构造器 <br>
	 * @param level
	 * @param code 
	 */
	public BaseException(ExceptionLevel level, ExceptionCode code) {
		super();
		this.level = level;
		this.code = code;
	}

	public BaseException(String remark, String message, ExceptionLevel level, ExceptionCode code) {
        super(message);
    	this.level = level;
		this.code = code;
		this.remark=remark;
    }

    public BaseException(Throwable cause, ExceptionLevel level, ExceptionCode code) {
        super(cause);
    	this.level = level;
		this.code = code;
    }

    public BaseException(String remark, String message, Throwable cause, ExceptionLevel level, ExceptionCode code) {
        super(message, cause);
    	this.level = level;
		this.code = code;
		this.remark=remark;
    }

	public ExceptionLevel getLevel() {
		return level;
	}

	public ExceptionCode getCode() {
		return code;
	}

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

  
    
    
}
