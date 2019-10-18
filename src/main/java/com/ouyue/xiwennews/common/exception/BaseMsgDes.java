package com.ouyue.xiwennews.common.exception;

/**
 *
 * 类: BaseMsgDes <br>
 * 描述: 消息描述接口 <br>
 */
public interface BaseMsgDes {

	
	ExceptionLevel getLevel() ;

	ExceptionCode getCode() ;
	
	String getRemark();

	String getOutPusMsg();
}
