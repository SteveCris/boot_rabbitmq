package com.ouyue.xiwennews.service.impl;
import com.ouyue.xiwennews.annotation.RedisCacheAble;
import com.ouyue.xiwennews.annotation.RedisCachePut;
import com.ouyue.xiwennews.common.enums.LikeTypeEnum;
import com.ouyue.xiwennews.common.enums.LikedStatusEnum;
import com.ouyue.xiwennews.common.model.UserLikeF;
import com.ouyue.xiwennews.common.vo.UserLikeDetailV;
import com.ouyue.xiwennews.compont.FundraiisingLikeStrategyChoose;
import com.ouyue.xiwennews.dao.LikeStrategy;
import com.ouyue.xiwennews.entity.UserLike;
import com.ouyue.xiwennews.mapper.UserLikeMapper;
import com.ouyue.xiwennews.service.RedisService;
import com.ouyue.xiwennews.service.UserLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-18 13-34
 */

@Service
public class UserLikeServiceImpl implements UserLikeService {

    @Autowired
    UserLikeMapper userLikeMapper;

    @Autowired
    RedisService redisService;

    @Autowired
    LikeStrategy likeStrategy;

/*    @Autowired
    UserService userService;*/

    @Override
    @RedisCacheAble(value="userLike22332")
    public UserLikeDetailV getUserLikeDetail(Integer id) {

        UserLikeDetailV likeDetailV = new UserLikeDetailV();
        return likeDetailV;
    }

    @Override
    public UserLike save(UserLike userLike) {
        return null;
    }

    @Override
    @RedisCachePut(value="UserLikeFList",key="userLikeF",names={"likedUserId","likedPostId","status"})
    public int insertDto(UserLikeF request) {

        return 1;
    }

    @Override
    public int likeOrUnLike(String likedId, int likeStatus, int likeType, long userId) {
        LikeTypeEnum likeTypeEnum = LikeTypeEnum.getCode(likeType);
        if(null==likeTypeEnum){
            return 0;
        }
        switch (likeTypeEnum){
            case LIKE_CASE:
                FundraiisingLikeStrategyChoose fundraiisingLikeStrategychoose =new FundraiisingLikeStrategyChoose(likeStrategy);
                if(likeStatus==LikedStatusEnum.LIKE.getCode()){
                    fundraiisingLikeStrategychoose.like(userId,likedId,likeStatus,likeType);
                }else{
                    fundraiisingLikeStrategychoose.unLike(userId,likedId,likeStatus,likeType);
                }
                break;
            default:
                break;
        }
        return 1;
    }


}
