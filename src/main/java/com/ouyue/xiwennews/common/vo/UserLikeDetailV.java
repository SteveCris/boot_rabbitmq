package com.ouyue.xiwennews.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-18 13-36
 */

@Data
public class UserLikeDetailV implements Serializable {
    private Integer id;

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
    private Boolean status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
