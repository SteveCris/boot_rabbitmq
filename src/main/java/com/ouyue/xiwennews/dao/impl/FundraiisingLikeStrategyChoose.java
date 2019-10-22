package com.ouyue.xiwennews.dao.impl;

import com.ouyue.xiwennews.dao.LikeStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-22 14-33
 */

@Service
@Slf4j
public class FundraiisingLikeStrategyChoose implements LikeStrategy {

    @Override
    public void like(long userId, String likedId, int likeStatus, int likeType) {

    }

    @Override
    public void unlike(long userId, String likedId, int likeStatus, int likeType) {

    }
}
