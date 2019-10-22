package com.ouyue.xiwennews.common.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-22 14-15
 */

@Data
public class FundraisingUserLike {
    /**
     * id
     */
    private int id;

    /**
     * 用户id
     */
    private  long userId;

    /**
     * 被点赞的id
     */
    private  String likedId;
    /**
     * 点赞状态
     */

    private int likeStatus;
    /**
     * 滇藏类型
     */

    private int  likeType;

    /**
     * 点赞时间
     */
    private Timestamp  likedTime;

}
