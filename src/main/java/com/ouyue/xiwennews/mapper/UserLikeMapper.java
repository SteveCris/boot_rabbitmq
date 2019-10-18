package com.ouyue.xiwennews.mapper;

import java.util.List;

import com.ouyue.xiwennews.entity.UserLike;
import com.ouyue.xiwennews.entity.UserLikeExample;
import org.apache.ibatis.annotations.Param;

public interface UserLikeMapper {
    /**
     *
     * @mbggenerated 2019-10-16
     */
    int countByExample(UserLikeExample example);

    /**
     *
     * @mbggenerated 2019-10-16
     */
    int deleteByExample(UserLikeExample example);

    /**
     *
     * @mbggenerated 2019-10-16
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2019-10-16
     */
    int insert(UserLike record);

    /**
     *
     * @mbggenerated 2019-10-16
     */
    int insertSelective(UserLike record);

    /**
     *
     * @mbggenerated 2019-10-16
     */
    List<UserLike> selectByExample(UserLikeExample example);

    /**
     *
     * @mbggenerated 2019-10-16
     */
    UserLike selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2019-10-16
     */
    int updateByExampleSelective(@Param("record") UserLike record, @Param("example") UserLikeExample example);

    /**
     *
     * @mbggenerated 2019-10-16
     */
    int updateByExample(@Param("record") UserLike record, @Param("example") UserLikeExample example);

    /**
     *
     * @mbggenerated 2019-10-16
     */
    int updateByPrimaryKeySelective(UserLike record);

    /**
     *
     * @mbggenerated 2019-10-16
     */
    int updateByPrimaryKey(UserLike record);
}