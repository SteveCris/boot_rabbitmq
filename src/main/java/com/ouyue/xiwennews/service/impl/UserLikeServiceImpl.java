package com.ouyue.xiwennews.service.impl;

import com.ouyue.xiwennews.common.exception.BaseException;
import com.ouyue.xiwennews.common.exception.ExceptionCode;
import com.ouyue.xiwennews.common.exception.ExceptionLevel;
import com.ouyue.xiwennews.common.exception.IllegalArgumentFailureException;
import com.ouyue.xiwennews.common.utils.BeanUtil;
import com.ouyue.xiwennews.common.vo.UserLikeDetailV;
import com.ouyue.xiwennews.entity.UserLike;
import com.ouyue.xiwennews.mapper.UserLikeMapper;
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
    @Override
    public UserLikeDetailV getUserLikeDetail(Integer id) {
        UserLike userLike = userLikeMapper.selectByPrimaryKey(id);
        BeanUtil.do2bo(userLike,UserLikeDetailV.class);
        return  BeanUtil.do2bo(userLike,UserLikeDetailV.class);
    }

    @Override
    public void cancelLike(Integer id) {
        //取消点赞的状态
      /* try {
            Integer num= id/0;
        }catch (Exception ex){
           throw new IllegalArgumentFailureException(ExceptionLevel.ERROR, ExceptionCode.DEFAULT_ERROR);
        }*/
        System.out.println(id);
    }
}
