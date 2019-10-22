package com.ouyue.xiwennews.compont;

import com.ouyue.xiwennews.dao.LikeStrategy;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-22 14-28
 */
public class FundraiisingLikeStrategyChoose {

    private LikeStrategy likeStrategy;

    public FundraiisingLikeStrategyChoose(LikeStrategy likeStrategy){
        this.likeStrategy=likeStrategy;
    }

    public void like(long userId,String  likeId,int likeStatus,int likeType){
        likeStrategy.like(userId,likeId,likeStatus,likeType);
    }

    public void unLike(long userId,String  likeId,int likeStatus,int likeType){
        likeStrategy.unlike(userId,likeId,likeStatus,likeType);
    }

}
