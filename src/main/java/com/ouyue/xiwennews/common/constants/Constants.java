package com.ouyue.xiwennews.common.constants;

import java.nio.charset.Charset;

/**
 * 系统全局常量类
 * @author gdl
 *
 */
public class Constants {

    public static final String CODE = "code";
    public static final String MESSAGE = "message";
    public static final String SUCCESSED = "successed";
    public static final String DATA = "data";

    /**
     * UTF-8编码
     */
    public static final String UTF8 = "UTF-8";

    public static final Charset UTF8_CHARSET = Charset.forName(UTF8);

    /**
     * 数据有效性状态 01-生效
     */
    public static final String STATE_NORMAL = "01";

    /**
     * 数据有效性状态 02-失效
     */
    public static final String STATE_FORBIDDEN = "02";

    /**
     * 风控规则字符串分隔符 (|||)
     */
    public static final String RISK_SPLIT = "\\|\\|\\|";

    /**
     * 默认基础模板业务编号key
     */
    public static final String DEFAULT_FRAUD_TEMPLATE_ID_REDIS_KEY_NAME = "DEFAULT_FRAUD_TEMPLATE";

    /**
     * 人工审批参数（阈值、开关） 对应系统参数key
     */
    public static final String RG_APPROVAL_SWITCH = "RG_APPROVAL_SWITCH";

    /**
     * 老用户标识
     */
    public static final String APP_LEVEL = "1";

    /**
     * 审批状态：待审核
     */
    public static final String DAI_SP_STAATE = "1";
    /**
     * 审批状态 ：审核通过
     */
    public static final String PASS_SP_STAATE = "2";
    /**
     * 审批状态 ：审核不通过
     */
    public static final String NOPASS_SP_STAATE = "3";
    /**
     * 审批状态 ：待人工确认
     */
    public static final String DAIRG_SP_STAATE = "4";
    /**
     * 审批状态 ：信息重新获取
     */
    public static final String AGAIN_SP_STAATE = "5";
    
    public static final  String HZ_QZF_SCORE_1 = "HZ_QZF_SCORE_1";
}
