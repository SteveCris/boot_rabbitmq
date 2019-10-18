package com.ouyue.xiwennews.common.constants;


public class RabbitMQConstants {

    /**
     * consumer失败后等待时间(mils)
     */
    public static final int ONE_SECOND = 1 * 1000;

    /**
     * MQ消息retry时间 间隔 ms
     */
    public static final int RETRY_TIME_INTERVAL = 5000;

    /**
     * MQ消息重复发送次数
     */
    public static final int RETRY_TIMES = 5;

    /**
     * hashmap
     * 存储需要 重新发送的消息体数据
     */
    public static final String MQ_MSG_RETRY_DATA_HASH_KEY = "mq:msg:retry:data";
    public static final byte[] MQ_MSG_RETRY_DATA_HASH_BYTE_KEY = MQ_MSG_RETRY_DATA_HASH_KEY.getBytes(Constants.UTF8_CHARSET);

    /**
     * 存储需要重新发送的消息体 ID
     */
    public static final String MQ_MSG_TOTAL_KEY = "mq:msg:retry:total";
    public static final byte[] MQ_MSG_TOTAL_KEY_BYTE = MQ_MSG_TOTAL_KEY.getBytes(Constants.UTF8_CHARSET);

    /**
     * 尝试5次失败后的消息存放的key
     */
    public static final String MQ_MSG_TOTAL_FAIL_KEY = "mq:msg:retry:total:fail";
    public static final byte[] MQ_MSG_TOTAL_FAIL_BYTE_KEY = MQ_MSG_TOTAL_FAIL_KEY.getBytes(Constants.UTF8_CHARSET);

    /**
     * 当前tomcat启动后 StartInitServletListener 会根据 ip地址和端口号 赋值
     * 确定在redis 中的key 的唯一性
     */
    public static String MQ_MSG_TOTAL_KEY_THIS = "mq:msg:retry:";
}
