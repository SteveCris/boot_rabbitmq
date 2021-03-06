package com.ouyue.xiwennews.entity;

import java.util.Date;

public class UserLike {
    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 被点赞的id
     */
    private String likedId;

    /**
     * 点赞状态，0未点赞，1已点赞
     */
    private Integer likedStatus;

    /**
     * 点赞的类型
     */
    private Integer likedType;

    /**
     * 点赞时间
     */
    private Date likedTime;

    /**
     * 是否逻辑删除
     */
    private Byte isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * id
     * @return id id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 被点赞的id
     * @return liked_id 被点赞的id
     */
    public String getLikedId() {
        return likedId;
    }

    /**
     * 被点赞的id
     * @param likedId 被点赞的id
     */
    public void setLikedId(String likedId) {
        this.likedId = likedId;
    }

    /**
     * 点赞状态，0未点赞，1已点赞
     * @return liked_status 点赞状态，0未点赞，1已点赞
     */
    public Integer getLikedStatus() {
        return likedStatus;
    }

    /**
     * 点赞状态，0未点赞，1已点赞
     * @param likedStatus 点赞状态，0未点赞，1已点赞
     */
    public void setLikedStatus(Integer likedStatus) {
        this.likedStatus = likedStatus;
    }

    /**
     * 点赞的类型
     * @return liked_type 点赞的类型
     */
    public Integer getLikedType() {
        return likedType;
    }

    /**
     * 点赞的类型
     * @param likedType 点赞的类型
     */
    public void setLikedType(Integer likedType) {
        this.likedType = likedType;
    }

    /**
     * 点赞时间
     * @return liked_time 点赞时间
     */
    public Date getLikedTime() {
        return likedTime;
    }

    /**
     * 点赞时间
     * @param likedTime 点赞时间
     */
    public void setLikedTime(Date likedTime) {
        this.likedTime = likedTime;
    }

    /**
     * 是否逻辑删除
     * @return is_delete 是否逻辑删除
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * 是否逻辑删除
     * @param isDelete 是否逻辑删除
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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
     * 更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}