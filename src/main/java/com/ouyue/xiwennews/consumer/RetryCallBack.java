package com.ouyue.xiwennews.consumer;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-21 11-44
 */

@FunctionalInterface
public interface RetryCallBack {

    /**
     * 处理消息
     *
     * @return 如果返回false，需要重试，返回true，不需要重试
     */
    boolean processMessage();
}
