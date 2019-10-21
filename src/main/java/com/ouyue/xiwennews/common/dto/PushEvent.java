package com.ouyue.xiwennews.common.dto;

import java.io.Serializable;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-21 11-51
 */
public class PushEvent implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PushEvent [getMsg=");
        builder.append(msg);
        builder.append("]");
        return builder.toString();
    }

}
