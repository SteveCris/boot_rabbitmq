package com.ouyue.xiwennews.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserLikeExample {
    /**
     * user_like
     */
    protected String orderByClause;

    /**
     * user_like
     */
    protected boolean distinct;

    /**
     * user_like
     */
    protected List<Criteria> oredCriteria;

    /**
     * user_like
     */
    protected int limitStart = -1;

    /**
     * user_like
     */
    protected int limitEnd = -1;

    /**
     *
     * @mbggenerated 2019-10-16
     */
    public UserLikeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated 2019-10-16
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated 2019-10-16
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated 2019-10-16
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated 2019-10-16
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated 2019-10-16
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated 2019-10-16
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated 2019-10-16
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-10-16
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-10-16
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-10-16
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbggenerated 2019-10-16
     */
    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    /**
     *
     * @mbggenerated 2019-10-16
     */
    public int getLimitStart() {
        return limitStart;
    }

    /**
     *
     * @mbggenerated 2019-10-16
     */
    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     *
     * @mbggenerated 2019-10-16
     */
    public int getLimitEnd() {
        return limitEnd;
    }

    /**
     * user_like 2019-10-16
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                return ;
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                return ;
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                return ;
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLikedUserIdIsNull() {
            addCriterion("liked_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLikedUserIdIsNotNull() {
            addCriterion("liked_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLikedUserIdEqualTo(String value) {
            addCriterion("liked_user_id =", value, "likedUserId");
            return (Criteria) this;
        }

        public Criteria andLikedUserIdNotEqualTo(String value) {
            addCriterion("liked_user_id <>", value, "likedUserId");
            return (Criteria) this;
        }

        public Criteria andLikedUserIdGreaterThan(String value) {
            addCriterion("liked_user_id >", value, "likedUserId");
            return (Criteria) this;
        }

        public Criteria andLikedUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("liked_user_id >=", value, "likedUserId");
            return (Criteria) this;
        }

        public Criteria andLikedUserIdLessThan(String value) {
            addCriterion("liked_user_id <", value, "likedUserId");
            return (Criteria) this;
        }

        public Criteria andLikedUserIdLessThanOrEqualTo(String value) {
            addCriterion("liked_user_id <=", value, "likedUserId");
            return (Criteria) this;
        }

        public Criteria andLikedUserIdLike(String value) {
            addCriterion("liked_user_id like", value, "likedUserId");
            return (Criteria) this;
        }

        public Criteria andLikedUserIdNotLike(String value) {
            addCriterion("liked_user_id not like", value, "likedUserId");
            return (Criteria) this;
        }

        public Criteria andLikedUserIdIn(List<String> values) {
            addCriterion("liked_user_id in", values, "likedUserId");
            return (Criteria) this;
        }

        public Criteria andLikedUserIdNotIn(List<String> values) {
            addCriterion("liked_user_id not in", values, "likedUserId");
            return (Criteria) this;
        }

        public Criteria andLikedUserIdBetween(String value1, String value2) {
            addCriterion("liked_user_id between", value1, value2, "likedUserId");
            return (Criteria) this;
        }

        public Criteria andLikedUserIdNotBetween(String value1, String value2) {
            addCriterion("liked_user_id not between", value1, value2, "likedUserId");
            return (Criteria) this;
        }

        public Criteria andLikedPostIdIsNull() {
            addCriterion("liked_post_id is null");
            return (Criteria) this;
        }

        public Criteria andLikedPostIdIsNotNull() {
            addCriterion("liked_post_id is not null");
            return (Criteria) this;
        }

        public Criteria andLikedPostIdEqualTo(String value) {
            addCriterion("liked_post_id =", value, "likedPostId");
            return (Criteria) this;
        }

        public Criteria andLikedPostIdNotEqualTo(String value) {
            addCriterion("liked_post_id <>", value, "likedPostId");
            return (Criteria) this;
        }

        public Criteria andLikedPostIdGreaterThan(String value) {
            addCriterion("liked_post_id >", value, "likedPostId");
            return (Criteria) this;
        }

        public Criteria andLikedPostIdGreaterThanOrEqualTo(String value) {
            addCriterion("liked_post_id >=", value, "likedPostId");
            return (Criteria) this;
        }

        public Criteria andLikedPostIdLessThan(String value) {
            addCriterion("liked_post_id <", value, "likedPostId");
            return (Criteria) this;
        }

        public Criteria andLikedPostIdLessThanOrEqualTo(String value) {
            addCriterion("liked_post_id <=", value, "likedPostId");
            return (Criteria) this;
        }

        public Criteria andLikedPostIdLike(String value) {
            addCriterion("liked_post_id like", value, "likedPostId");
            return (Criteria) this;
        }

        public Criteria andLikedPostIdNotLike(String value) {
            addCriterion("liked_post_id not like", value, "likedPostId");
            return (Criteria) this;
        }

        public Criteria andLikedPostIdIn(List<String> values) {
            addCriterion("liked_post_id in", values, "likedPostId");
            return (Criteria) this;
        }

        public Criteria andLikedPostIdNotIn(List<String> values) {
            addCriterion("liked_post_id not in", values, "likedPostId");
            return (Criteria) this;
        }

        public Criteria andLikedPostIdBetween(String value1, String value2) {
            addCriterion("liked_post_id between", value1, value2, "likedPostId");
            return (Criteria) this;
        }

        public Criteria andLikedPostIdNotBetween(String value1, String value2) {
            addCriterion("liked_post_id not between", value1, value2, "likedPostId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * user_like
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * user_like 2019-10-16
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}