package com.ouyue.xiwennews.service;

import com.ouyue.xiwennews.common.dto.PushEvent;
import com.ouyue.xiwennews.common.vo.UserLikeDetailV;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-18 13-34
 */
public interface UserLikeService {
    UserLikeDetailV getUserLikeDetail(Integer id);

    void cancelLike(String id);

    boolean processPushTime(String pushEvent);
}
