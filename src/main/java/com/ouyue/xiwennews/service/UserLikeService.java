package com.ouyue.xiwennews.service;

import com.github.pagehelper.Page;
import com.ouyue.xiwennews.common.model.UserLikeF;
import com.ouyue.xiwennews.common.vo.UserLikeDetailV;
import com.ouyue.xiwennews.entity.UserLike;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-18 13-34
 */
public interface UserLikeService {


    UserLikeDetailV getUserLikeDetail(Integer id);

    /**
     * 保存点赞记录
     * @param userLike
     * @return
     */
    UserLike save(UserLike userLike);

    int insertDto(UserLikeF request);

    int likeOrUnLike(String likedId,int likeStatus,int likeType,long userId);
}
