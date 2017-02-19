package com.oraclewdp.crm.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BjdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BjdExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BjdExample(BjdExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<String> criteriaWithoutValue;

        protected List<Map<String, Object>> criteriaWithSingleValue;

        protected List<Map<String, Object>> criteriaWithListValue;

        protected List<Map<String, Object>> criteriaWithBetweenValue;

        protected GeneratedCriteria() {
            super();
            criteriaWithoutValue = new ArrayList<String>();
            criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
            criteriaWithListValue = new ArrayList<Map<String, Object>>();
            criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List<String> getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List<Map<String, Object>> getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List<Map<String, Object>> getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List<Map<String, Object>> getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List<? extends Object> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List<Object> list = new ArrayList<Object>();
            list.add(value1);
            list.add(value2);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
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

        public Criteria andSskhIsNull() {
            addCriterion("sskh is null");
            return (Criteria) this;
        }

        public Criteria andSskhIsNotNull() {
            addCriterion("sskh is not null");
            return (Criteria) this;
        }

        public Criteria andSskhEqualTo(Integer value) {
            addCriterion("sskh =", value, "sskh");
            return (Criteria) this;
        }

        public Criteria andSskhNotEqualTo(Integer value) {
            addCriterion("sskh <>", value, "sskh");
            return (Criteria) this;
        }

        public Criteria andSskhGreaterThan(Integer value) {
            addCriterion("sskh >", value, "sskh");
            return (Criteria) this;
        }

        public Criteria andSskhGreaterThanOrEqualTo(Integer value) {
            addCriterion("sskh >=", value, "sskh");
            return (Criteria) this;
        }

        public Criteria andSskhLessThan(Integer value) {
            addCriterion("sskh <", value, "sskh");
            return (Criteria) this;
        }

        public Criteria andSskhLessThanOrEqualTo(Integer value) {
            addCriterion("sskh <=", value, "sskh");
            return (Criteria) this;
        }

        public Criteria andSskhIn(List<Integer> values) {
            addCriterion("sskh in", values, "sskh");
            return (Criteria) this;
        }

        public Criteria andSskhNotIn(List<Integer> values) {
            addCriterion("sskh not in", values, "sskh");
            return (Criteria) this;
        }

        public Criteria andSskhBetween(Integer value1, Integer value2) {
            addCriterion("sskh between", value1, value2, "sskh");
            return (Criteria) this;
        }

        public Criteria andSskhNotBetween(Integer value1, Integer value2) {
            addCriterion("sskh not between", value1, value2, "sskh");
            return (Criteria) this;
        }

        public Criteria andBjrIsNull() {
            addCriterion("bjr is null");
            return (Criteria) this;
        }

        public Criteria andBjrIsNotNull() {
            addCriterion("bjr is not null");
            return (Criteria) this;
        }

        public Criteria andBjrEqualTo(Integer value) {
            addCriterion("bjr =", value, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrNotEqualTo(Integer value) {
            addCriterion("bjr <>", value, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrGreaterThan(Integer value) {
            addCriterion("bjr >", value, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrGreaterThanOrEqualTo(Integer value) {
            addCriterion("bjr >=", value, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrLessThan(Integer value) {
            addCriterion("bjr <", value, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrLessThanOrEqualTo(Integer value) {
            addCriterion("bjr <=", value, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrIn(List<Integer> values) {
            addCriterion("bjr in", values, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrNotIn(List<Integer> values) {
            addCriterion("bjr not in", values, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrBetween(Integer value1, Integer value2) {
            addCriterion("bjr between", value1, value2, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrNotBetween(Integer value1, Integer value2) {
            addCriterion("bjr not between", value1, value2, "bjr");
            return (Criteria) this;
        }

        public Criteria andYxrqIsNull() {
            addCriterion("yxrq is null");
            return (Criteria) this;
        }

        public Criteria andYxrqIsNotNull() {
            addCriterion("yxrq is not null");
            return (Criteria) this;
        }

        public Criteria andYxrqEqualTo(String value) {
            addCriterion("yxrq =", value, "yxrq");
            return (Criteria) this;
        }

        public Criteria andYxrqNotEqualTo(String value) {
            addCriterion("yxrq <>", value, "yxrq");
            return (Criteria) this;
        }

        public Criteria andYxrqGreaterThan(String value) {
            addCriterion("yxrq >", value, "yxrq");
            return (Criteria) this;
        }

        public Criteria andYxrqGreaterThanOrEqualTo(String value) {
            addCriterion("yxrq >=", value, "yxrq");
            return (Criteria) this;
        }

        public Criteria andYxrqLessThan(String value) {
            addCriterion("yxrq <", value, "yxrq");
            return (Criteria) this;
        }

        public Criteria andYxrqLessThanOrEqualTo(String value) {
            addCriterion("yxrq <=", value, "yxrq");
            return (Criteria) this;
        }

        public Criteria andYxrqLike(String value) {
            addCriterion("yxrq like", value, "yxrq");
            return (Criteria) this;
        }

        public Criteria andYxrqNotLike(String value) {
            addCriterion("yxrq not like", value, "yxrq");
            return (Criteria) this;
        }

        public Criteria andYxrqIn(List<String> values) {
            addCriterion("yxrq in", values, "yxrq");
            return (Criteria) this;
        }

        public Criteria andYxrqNotIn(List<String> values) {
            addCriterion("yxrq not in", values, "yxrq");
            return (Criteria) this;
        }

        public Criteria andYxrqBetween(String value1, String value2) {
            addCriterion("yxrq between", value1, value2, "yxrq");
            return (Criteria) this;
        }

        public Criteria andYxrqNotBetween(String value1, String value2) {
            addCriterion("yxrq not between", value1, value2, "yxrq");
            return (Criteria) this;
        }

        public Criteria andBjrqIsNull() {
            addCriterion("bjrq is null");
            return (Criteria) this;
        }

        public Criteria andBjrqIsNotNull() {
            addCriterion("bjrq is not null");
            return (Criteria) this;
        }

        public Criteria andBjrqEqualTo(String value) {
            addCriterion("bjrq =", value, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqNotEqualTo(String value) {
            addCriterion("bjrq <>", value, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqGreaterThan(String value) {
            addCriterion("bjrq >", value, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqGreaterThanOrEqualTo(String value) {
            addCriterion("bjrq >=", value, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqLessThan(String value) {
            addCriterion("bjrq <", value, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqLessThanOrEqualTo(String value) {
            addCriterion("bjrq <=", value, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqLike(String value) {
            addCriterion("bjrq like", value, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqNotLike(String value) {
            addCriterion("bjrq not like", value, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqIn(List<String> values) {
            addCriterion("bjrq in", values, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqNotIn(List<String> values) {
            addCriterion("bjrq not in", values, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqBetween(String value1, String value2) {
            addCriterion("bjrq between", value1, value2, "bjrq");
            return (Criteria) this;
        }

        public Criteria andBjrqNotBetween(String value1, String value2) {
            addCriterion("bjrq not between", value1, value2, "bjrq");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCustomChanceIdIsNull() {
            addCriterion("custom_chance_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomChanceIdIsNotNull() {
            addCriterion("custom_chance_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomChanceIdEqualTo(Integer value) {
            addCriterion("custom_chance_id =", value, "customChanceId");
            return (Criteria) this;
        }

        public Criteria andCustomChanceIdNotEqualTo(Integer value) {
            addCriterion("custom_chance_id <>", value, "customChanceId");
            return (Criteria) this;
        }

        public Criteria andCustomChanceIdGreaterThan(Integer value) {
            addCriterion("custom_chance_id >", value, "customChanceId");
            return (Criteria) this;
        }

        public Criteria andCustomChanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("custom_chance_id >=", value, "customChanceId");
            return (Criteria) this;
        }

        public Criteria andCustomChanceIdLessThan(Integer value) {
            addCriterion("custom_chance_id <", value, "customChanceId");
            return (Criteria) this;
        }

        public Criteria andCustomChanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("custom_chance_id <=", value, "customChanceId");
            return (Criteria) this;
        }

        public Criteria andCustomChanceIdIn(List<Integer> values) {
            addCriterion("custom_chance_id in", values, "customChanceId");
            return (Criteria) this;
        }

        public Criteria andCustomChanceIdNotIn(List<Integer> values) {
            addCriterion("custom_chance_id not in", values, "customChanceId");
            return (Criteria) this;
        }

        public Criteria andCustomChanceIdBetween(Integer value1, Integer value2) {
            addCriterion("custom_chance_id between", value1, value2, "customChanceId");
            return (Criteria) this;
        }

        public Criteria andCustomChanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("custom_chance_id not between", value1, value2, "customChanceId");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(String value) {
            addCriterion("createdate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(String value) {
            addCriterion("createdate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(String value) {
            addCriterion("createdate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("createdate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(String value) {
            addCriterion("createdate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(String value) {
            addCriterion("createdate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLike(String value) {
            addCriterion("createdate like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotLike(String value) {
            addCriterion("createdate not like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<String> values) {
            addCriterion("createdate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<String> values) {
            addCriterion("createdate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(String value1, String value2) {
            addCriterion("createdate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(String value1, String value2) {
            addCriterion("createdate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Integer value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Integer value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Integer value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Integer value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Integer> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Integer> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Integer value1, Integer value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andTotleCountIsNull() {
            addCriterion("totle_count is null");
            return (Criteria) this;
        }

        public Criteria andTotleCountIsNotNull() {
            addCriterion("totle_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotleCountEqualTo(Integer value) {
            addCriterion("totle_count =", value, "totleCount");
            return (Criteria) this;
        }

        public Criteria andTotleCountNotEqualTo(Integer value) {
            addCriterion("totle_count <>", value, "totleCount");
            return (Criteria) this;
        }

        public Criteria andTotleCountGreaterThan(Integer value) {
            addCriterion("totle_count >", value, "totleCount");
            return (Criteria) this;
        }

        public Criteria andTotleCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("totle_count >=", value, "totleCount");
            return (Criteria) this;
        }

        public Criteria andTotleCountLessThan(Integer value) {
            addCriterion("totle_count <", value, "totleCount");
            return (Criteria) this;
        }

        public Criteria andTotleCountLessThanOrEqualTo(Integer value) {
            addCriterion("totle_count <=", value, "totleCount");
            return (Criteria) this;
        }

        public Criteria andTotleCountIn(List<Integer> values) {
            addCriterion("totle_count in", values, "totleCount");
            return (Criteria) this;
        }

        public Criteria andTotleCountNotIn(List<Integer> values) {
            addCriterion("totle_count not in", values, "totleCount");
            return (Criteria) this;
        }

        public Criteria andTotleCountBetween(Integer value1, Integer value2) {
            addCriterion("totle_count between", value1, value2, "totleCount");
            return (Criteria) this;
        }

        public Criteria andTotleCountNotBetween(Integer value1, Integer value2) {
            addCriterion("totle_count not between", value1, value2, "totleCount");
            return (Criteria) this;
        }

        public Criteria andTotleRateIsNull() {
            addCriterion("totle_rate is null");
            return (Criteria) this;
        }

        public Criteria andTotleRateIsNotNull() {
            addCriterion("totle_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTotleRateEqualTo(Float value) {
            addCriterion("totle_rate =", value, "totleRate");
            return (Criteria) this;
        }

        public Criteria andTotleRateNotEqualTo(Float value) {
            addCriterion("totle_rate <>", value, "totleRate");
            return (Criteria) this;
        }

        public Criteria andTotleRateGreaterThan(Float value) {
            addCriterion("totle_rate >", value, "totleRate");
            return (Criteria) this;
        }

        public Criteria andTotleRateGreaterThanOrEqualTo(Float value) {
            addCriterion("totle_rate >=", value, "totleRate");
            return (Criteria) this;
        }

        public Criteria andTotleRateLessThan(Float value) {
            addCriterion("totle_rate <", value, "totleRate");
            return (Criteria) this;
        }

        public Criteria andTotleRateLessThanOrEqualTo(Float value) {
            addCriterion("totle_rate <=", value, "totleRate");
            return (Criteria) this;
        }

        public Criteria andTotleRateIn(List<Float> values) {
            addCriterion("totle_rate in", values, "totleRate");
            return (Criteria) this;
        }

        public Criteria andTotleRateNotIn(List<Float> values) {
            addCriterion("totle_rate not in", values, "totleRate");
            return (Criteria) this;
        }

        public Criteria andTotleRateBetween(Float value1, Float value2) {
            addCriterion("totle_rate between", value1, value2, "totleRate");
            return (Criteria) this;
        }

        public Criteria andTotleRateNotBetween(Float value1, Float value2) {
            addCriterion("totle_rate not between", value1, value2, "totleRate");
            return (Criteria) this;
        }

        public Criteria andTotlePrePriceRateIsNull() {
            addCriterion("totle_pre_price_rate is null");
            return (Criteria) this;
        }

        public Criteria andTotlePrePriceRateIsNotNull() {
            addCriterion("totle_pre_price_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTotlePrePriceRateEqualTo(Float value) {
            addCriterion("totle_pre_price_rate =", value, "totlePrePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePrePriceRateNotEqualTo(Float value) {
            addCriterion("totle_pre_price_rate <>", value, "totlePrePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePrePriceRateGreaterThan(Float value) {
            addCriterion("totle_pre_price_rate >", value, "totlePrePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePrePriceRateGreaterThanOrEqualTo(Float value) {
            addCriterion("totle_pre_price_rate >=", value, "totlePrePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePrePriceRateLessThan(Float value) {
            addCriterion("totle_pre_price_rate <", value, "totlePrePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePrePriceRateLessThanOrEqualTo(Float value) {
            addCriterion("totle_pre_price_rate <=", value, "totlePrePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePrePriceRateIn(List<Float> values) {
            addCriterion("totle_pre_price_rate in", values, "totlePrePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePrePriceRateNotIn(List<Float> values) {
            addCriterion("totle_pre_price_rate not in", values, "totlePrePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePrePriceRateBetween(Float value1, Float value2) {
            addCriterion("totle_pre_price_rate between", value1, value2, "totlePrePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePrePriceRateNotBetween(Float value1, Float value2) {
            addCriterion("totle_pre_price_rate not between", value1, value2, "totlePrePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePriceRateIsNull() {
            addCriterion("totle_price_rate is null");
            return (Criteria) this;
        }

        public Criteria andTotlePriceRateIsNotNull() {
            addCriterion("totle_price_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTotlePriceRateEqualTo(Float value) {
            addCriterion("totle_price_rate =", value, "totlePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePriceRateNotEqualTo(Float value) {
            addCriterion("totle_price_rate <>", value, "totlePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePriceRateGreaterThan(Float value) {
            addCriterion("totle_price_rate >", value, "totlePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePriceRateGreaterThanOrEqualTo(Float value) {
            addCriterion("totle_price_rate >=", value, "totlePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePriceRateLessThan(Float value) {
            addCriterion("totle_price_rate <", value, "totlePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePriceRateLessThanOrEqualTo(Float value) {
            addCriterion("totle_price_rate <=", value, "totlePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePriceRateIn(List<Float> values) {
            addCriterion("totle_price_rate in", values, "totlePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePriceRateNotIn(List<Float> values) {
            addCriterion("totle_price_rate not in", values, "totlePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePriceRateBetween(Float value1, Float value2) {
            addCriterion("totle_price_rate between", value1, value2, "totlePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePriceRateNotBetween(Float value1, Float value2) {
            addCriterion("totle_price_rate not between", value1, value2, "totlePriceRate");
            return (Criteria) this;
        }

        public Criteria andTotlePriceIsNull() {
            addCriterion("totle_price is null");
            return (Criteria) this;
        }

        public Criteria andTotlePriceIsNotNull() {
            addCriterion("totle_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotlePriceEqualTo(Float value) {
            addCriterion("totle_price =", value, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceNotEqualTo(Float value) {
            addCriterion("totle_price <>", value, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceGreaterThan(Float value) {
            addCriterion("totle_price >", value, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceGreaterThanOrEqualTo(Float value) {
            addCriterion("totle_price >=", value, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceLessThan(Float value) {
            addCriterion("totle_price <", value, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceLessThanOrEqualTo(Float value) {
            addCriterion("totle_price <=", value, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceIn(List<Float> values) {
            addCriterion("totle_price in", values, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceNotIn(List<Float> values) {
            addCriterion("totle_price not in", values, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceBetween(Float value1, Float value2) {
            addCriterion("totle_price between", value1, value2, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceNotBetween(Float value1, Float value2) {
            addCriterion("totle_price not between", value1, value2, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotleDiscountPriceIsNull() {
            addCriterion("totle_discount_price is null");
            return (Criteria) this;
        }

        public Criteria andTotleDiscountPriceIsNotNull() {
            addCriterion("totle_discount_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotleDiscountPriceEqualTo(Float value) {
            addCriterion("totle_discount_price =", value, "totleDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTotleDiscountPriceNotEqualTo(Float value) {
            addCriterion("totle_discount_price <>", value, "totleDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTotleDiscountPriceGreaterThan(Float value) {
            addCriterion("totle_discount_price >", value, "totleDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTotleDiscountPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("totle_discount_price >=", value, "totleDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTotleDiscountPriceLessThan(Float value) {
            addCriterion("totle_discount_price <", value, "totleDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTotleDiscountPriceLessThanOrEqualTo(Float value) {
            addCriterion("totle_discount_price <=", value, "totleDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTotleDiscountPriceIn(List<Float> values) {
            addCriterion("totle_discount_price in", values, "totleDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTotleDiscountPriceNotIn(List<Float> values) {
            addCriterion("totle_discount_price not in", values, "totleDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTotleDiscountPriceBetween(Float value1, Float value2) {
            addCriterion("totle_discount_price between", value1, value2, "totleDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTotleDiscountPriceNotBetween(Float value1, Float value2) {
            addCriterion("totle_discount_price not between", value1, value2, "totleDiscountPrice");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}