package com.ouyue.xiwennews.mapper;

import com.ouyue.xiwennews.entity.UserLike;
import com.ouyue.xiwennews.entity.UserLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLikeMapper {
    /**
     *
     * @mbggenerated 2019-10-22
     */
    int countByExample(UserLikeExample example);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int deleteByExample(UserLikeExample example);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int insert(UserLike record);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int insertSelective(UserLike record);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    List<UserLike> selectByExample(UserLikeExample example);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    UserLike selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int updateByExampleSelective(@Param("record") UserLike record, @Param("example") UserLikeExample example);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int updateByExample(@Param("record") UserLike record, @Param("example") UserLikeExample example);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int updateByPrimaryKeySelective(UserLike record);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int updateByPrimaryKey(UserLike record);
}