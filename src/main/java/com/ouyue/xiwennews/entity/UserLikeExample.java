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
     * @mbggenerated 2019-10-22
     */
    public UserLikeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated 2019-10-22
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated 2019-10-22
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated 2019-10-22
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated 2019-10-22
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated 2019-10-22
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated 2019-10-22
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated 2019-10-22
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-10-22
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
     * @mbggenerated 2019-10-22
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-10-22
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbggenerated 2019-10-22
     */
    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    /**
     *
     * @mbggenerated 2019-10-22
     */
    public int getLimitStart() {
        return limitStart;
    }

    /**
     *
     * @mbggenerated 2019-10-22
     */
    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     *
     * @mbggenerated 2019-10-22
     */
    public int getLimitEnd() {
        return limitEnd;
    }

    /**
     * user_like 2019-10-22
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andLikedIdIsNull() {
            addCriterion("liked_id is null");
            return (Criteria) this;
        }

        public Criteria andLikedIdIsNotNull() {
            addCriterion("liked_id is not null");
            return (Criteria) this;
        }

        public Criteria andLikedIdEqualTo(String value) {
            addCriterion("liked_id =", value, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdNotEqualTo(String value) {
            addCriterion("liked_id <>", value, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdGreaterThan(String value) {
            addCriterion("liked_id >", value, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdGreaterThanOrEqualTo(String value) {
            addCriterion("liked_id >=", value, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdLessThan(String value) {
            addCriterion("liked_id <", value, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdLessThanOrEqualTo(String value) {
            addCriterion("liked_id <=", value, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdLike(String value) {
            addCriterion("liked_id like", value, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdNotLike(String value) {
            addCriterion("liked_id not like", value, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdIn(List<String> values) {
            addCriterion("liked_id in", values, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdNotIn(List<String> values) {
            addCriterion("liked_id not in", values, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdBetween(String value1, String value2) {
            addCriterion("liked_id between", value1, value2, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdNotBetween(String value1, String value2) {
            addCriterion("liked_id not between", value1, value2, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedStatusIsNull() {
            addCriterion("liked_status is null");
            return (Criteria) this;
        }

        public Criteria andLikedStatusIsNotNull() {
            addCriterion("liked_status is not null");
            return (Criteria) this;
        }

        public Criteria andLikedStatusEqualTo(Integer value) {
            addCriterion("liked_status =", value, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusNotEqualTo(Integer value) {
            addCriterion("liked_status <>", value, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusGreaterThan(Integer value) {
            addCriterion("liked_status >", value, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("liked_status >=", value, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusLessThan(Integer value) {
            addCriterion("liked_status <", value, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusLessThanOrEqualTo(Integer value) {
            addCriterion("liked_status <=", value, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusIn(List<Integer> values) {
            addCriterion("liked_status in", values, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusNotIn(List<Integer> values) {
            addCriterion("liked_status not in", values, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusBetween(Integer value1, Integer value2) {
            addCriterion("liked_status between", value1, value2, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("liked_status not between", value1, value2, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedTypeIsNull() {
            addCriterion("liked_type is null");
            return (Criteria) this;
        }

        public Criteria andLikedTypeIsNotNull() {
            addCriterion("liked_type is not null");
            return (Criteria) this;
        }

        public Criteria andLikedTypeEqualTo(Integer value) {
            addCriterion("liked_type =", value, "likedType");
            return (Criteria) this;
        }

        public Criteria andLikedTypeNotEqualTo(Integer value) {
            addCriterion("liked_type <>", value, "likedType");
            return (Criteria) this;
        }

        public Criteria andLikedTypeGreaterThan(Integer value) {
            addCriterion("liked_type >", value, "likedType");
            return (Criteria) this;
        }

        public Criteria andLikedTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("liked_type >=", value, "likedType");
            return (Criteria) this;
        }

        public Criteria andLikedTypeLessThan(Integer value) {
            addCriterion("liked_type <", value, "likedType");
            return (Criteria) this;
        }

        public Criteria andLikedTypeLessThanOrEqualTo(Integer value) {
            addCriterion("liked_type <=", value, "likedType");
            return (Criteria) this;
        }

        public Criteria andLikedTypeIn(List<Integer> values) {
            addCriterion("liked_type in", values, "likedType");
            return (Criteria) this;
        }

        public Criteria andLikedTypeNotIn(List<Integer> values) {
            addCriterion("liked_type not in", values, "likedType");
            return (Criteria) this;
        }

        public Criteria andLikedTypeBetween(Integer value1, Integer value2) {
            addCriterion("liked_type between", value1, value2, "likedType");
            return (Criteria) this;
        }

        public Criteria andLikedTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("liked_type not between", value1, value2, "likedType");
            return (Criteria) this;
        }

        public Criteria andLikedTimeIsNull() {
            addCriterion("liked_time is null");
            return (Criteria) this;
        }

        public Criteria andLikedTimeIsNotNull() {
            addCriterion("liked_time is not null");
            return (Criteria) this;
        }

        public Criteria andLikedTimeEqualTo(Date value) {
            addCriterion("liked_time =", value, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeNotEqualTo(Date value) {
            addCriterion("liked_time <>", value, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeGreaterThan(Date value) {
            addCriterion("liked_time >", value, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("liked_time >=", value, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeLessThan(Date value) {
            addCriterion("liked_time <", value, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeLessThanOrEqualTo(Date value) {
            addCriterion("liked_time <=", value, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeIn(List<Date> values) {
            addCriterion("liked_time in", values, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeNotIn(List<Date> values) {
            addCriterion("liked_time not in", values, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeBetween(Date value1, Date value2) {
            addCriterion("liked_time between", value1, value2, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeNotBetween(Date value1, Date value2) {
            addCriterion("liked_time not between", value1, value2, "likedTime");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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
     * user_like 2019-10-22
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