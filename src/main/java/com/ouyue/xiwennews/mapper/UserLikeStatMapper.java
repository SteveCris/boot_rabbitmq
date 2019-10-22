package com.ouyue.xiwennews.mapper;

import com.ouyue.xiwennews.entity.UserLikeStat;
import com.ouyue.xiwennews.entity.UserLikeStatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLikeStatMapper {
    /**
     *
     * @mbggenerated 2019-10-22
     */
    int countByExample(UserLikeStatExample example);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int deleteByExample(UserLikeStatExample example);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int insert(UserLikeStat record);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int insertSelective(UserLikeStat record);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    List<UserLikeStat> selectByExample(UserLikeStatExample example);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    UserLikeStat selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int updateByExampleSelective(@Param("record") UserLikeStat record, @Param("example") UserLikeStatExample example);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int updateByExample(@Param("record") UserLikeStat record, @Param("example") UserLikeStatExample example);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int updateByPrimaryKeySelective(UserLikeStat record);

    /**
     *
     * @mbggenerated 2019-10-22
     */
    int updateByPrimaryKey(UserLikeStat record);
}