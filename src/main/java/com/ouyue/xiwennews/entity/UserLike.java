package com.ouyue.xiwennews.entity;

import java.util.Date;

public class UserLike {
    /**
     * 
     */
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

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 被点赞的用户id
     * @return liked_user_id 被点赞的用户id
     */
    public String getLikedUserId() {
        return likedUserId;
    }

    /**
     * 被点赞的用户id
     * @param likedUserId 被点赞的用户id
     */
    public void setLikedUserId(String likedUserId) {
        this.likedUserId = likedUserId;
    }

    /**
     * 点赞的用户id
     * @return liked_post_id 点赞的用户id
     */
    public String getLikedPostId() {
        return likedPostId;
    }

    /**
     * 点赞的用户id
     * @param likedPostId 点赞的用户id
     */
    public void setLikedPostId(String likedPostId) {
        this.likedPostId = likedPostId;
    }

    /**
     * 点赞状态，0取消，1点赞
     * @return status 点赞状态，0取消，1点赞
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 点赞状态，0取消，1点赞
     * @param status 点赞状态，0取消，1点赞
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}