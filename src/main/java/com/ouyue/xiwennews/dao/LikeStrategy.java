package com.ouyue.xiwennews.dao;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-22 14-28
 */
public interface LikeStrategy {
    void like(long userId,String  likedId,int likeStatus,int likeType);

    void unlike(long userId,String  likedId,int likeStatus,int likeType);
}
