package com.ouyue.xiwennews.common.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-22 09-35
 */

@Data
@ToString
public class UserLikeF {
    /**
     * 被点赞的用户id
     */
    private String likedUserId;

    /**
     * 点赞的用户id
     */
    private String likedPostId;

    /**
     * 点赞状态，0取消，1点赞
     */
    private byte status;
}
