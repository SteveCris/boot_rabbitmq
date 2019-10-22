package com.ouyue.xiwennews.entity;

import java.util.Date;

public class UserLikeStat {
    /**
     * id
     */
    private Long id;

    /**
     * 被点赞id
     */
    private String likedId;

    /**
     * 点赞总数量
     */
    private Integer likedCount;

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
     * 被点赞id
     * @return liked_id 被点赞id
     */
    public String getLikedId() {
        return likedId;
    }

    /**
     * 被点赞id
     * @param likedId 被点赞id
     */
    public void setLikedId(String likedId) {
        this.likedId = likedId;
    }

    /**
     * 点赞总数量
     * @return liked_count 点赞总数量
     */
    public Integer getLikedCount() {
        return likedCount;
    }

    /**
     * 点赞总数量
     * @param likedCount 点赞总数量
     */
    public void setLikedCount(Integer likedCount) {
        this.likedCount = likedCount;
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