package com.ouyue.xiwennews.common.exception;

/**
 * 类: DbFailureException <br>
 * 描述: 数据库调用引起的异常。 <br>
 * 作者: 李永刚 hzliyonggang@corp.netease.com <br>
 * 时间: 2016年8月18日 上午10:47:08
 */
public class DbFailureException extends BaseException {
	private static final long serialVersionUID = -8227335536836081391L;

	/** 
	 * 标题: 构造器 <br>
	 * 描述: TODO <br>
	 * 作者: 李永刚 hzliyonggang@corp.netease.com <br>
	 * 时间: 2016年8月24日 下午1:41:28
	 * @param level
	 * @param code 
	 */
	public DbFailureException(ExceptionLevel level, ExceptionCode code) {
		super(level, code);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * 标题: 构造器 <br>
	 * 描述: TODO <br>
	 * 作者: 李永刚 hzliyonggang@corp.netease.com <br>
	 * 时间: 2016年8月24日 下午1:41:28
	 * @param message
	 * @param level
	 * @param code 
	 */
	public DbFailureException(String message, ExceptionLevel level, ExceptionCode code) {
		this(null,message, level, code);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * 标题: 构造器 <br>
	 * 描述: TODO <br>
	 * 作者: 李永刚 hzliyonggang@corp.netease.com <br>
	 * 时间: 2016年8月24日 下午1:41:28
	 * @param message
	 * @param cause
	 * @param level
	 * @param code 
	 */
	public DbFailureException(String message, Throwable cause, ExceptionLevel level, ExceptionCode code) {
		this(null,message, cause, level, code);
	}

	
	
	   /** 
     * 标题: 构造器 <br>
     * 描述: TODO <br>
     * 作者: 李永刚 hzliyonggang@corp.netease.com <br>
     * 时间: 2016年8月24日 下午1:41:28
     * @param message
     * @param level
     * @param code 
     */
    public DbFailureException(String remark,String message, ExceptionLevel level, ExceptionCode code) {
        super(remark,message, level, code);
        // TODO Auto-generated constructor stub
    }
	
	   /** 
     * 标题: 构造器 <br>
     * 描述: TODO <br>
     * 作者: 李永刚 hzliyonggang@corp.netease.com <br>
     * 时间: 2016年8月24日 下午1:41:28
     * @param message
     * @param cause
     * @param level
     * @param code 
     */
    public DbFailureException(String remark,String message, Throwable cause, ExceptionLevel level, ExceptionCode code) {
        super(remark,message, cause, level, code);
    }
    
	
	/** 
	 * 标题: 构造器 <br>
	 * 描述: TODO <br>
	 * 作者: 李永刚 hzliyonggang@corp.netease.com <br>
	 * 时间: 2016年8月24日 下午1:41:28
	 * @param cause
	 * @param level
	 * @param code 
	 */
	public DbFailureException(Throwable cause, ExceptionLevel level, ExceptionCode code) {
		super(cause, level, code);
	}

	
   
}
