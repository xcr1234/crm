package com.oraclewdp.crm.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BjdListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BjdListExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected BjdListExample(BjdListExample example) {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andBjdIdIsNull() {
            addCriterion("bjd_id is null");
            return (Criteria) this;
        }

        public Criteria andBjdIdIsNotNull() {
            addCriterion("bjd_id is not null");
            return (Criteria) this;
        }

        public Criteria andBjdIdEqualTo(Integer value) {
            addCriterion("bjd_id =", value, "bjdId");
            return (Criteria) this;
        }

        public Criteria andBjdIdNotEqualTo(Integer value) {
            addCriterion("bjd_id <>", value, "bjdId");
            return (Criteria) this;
        }

        public Criteria andBjdIdGreaterThan(Integer value) {
            addCriterion("bjd_id >", value, "bjdId");
            return (Criteria) this;
        }

        public Criteria andBjdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bjd_id >=", value, "bjdId");
            return (Criteria) this;
        }

        public Criteria andBjdIdLessThan(Integer value) {
            addCriterion("bjd_id <", value, "bjdId");
            return (Criteria) this;
        }

        public Criteria andBjdIdLessThanOrEqualTo(Integer value) {
            addCriterion("bjd_id <=", value, "bjdId");
            return (Criteria) this;
        }

        public Criteria andBjdIdIn(List<Integer> values) {
            addCriterion("bjd_id in", values, "bjdId");
            return (Criteria) this;
        }

        public Criteria andBjdIdNotIn(List<Integer> values) {
            addCriterion("bjd_id not in", values, "bjdId");
            return (Criteria) this;
        }

        public Criteria andBjdIdBetween(Integer value1, Integer value2) {
            addCriterion("bjd_id between", value1, value2, "bjdId");
            return (Criteria) this;
        }

        public Criteria andBjdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bjd_id not between", value1, value2, "bjdId");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(Integer value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(Integer value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(Integer value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(Integer value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(Integer value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<Integer> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<Integer> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(Integer value1, Integer value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(Integer value1, Integer value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andPerPriceRateIsNull() {
            addCriterion("per_price_rate is null");
            return (Criteria) this;
        }

        public Criteria andPerPriceRateIsNotNull() {
            addCriterion("per_price_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPerPriceRateEqualTo(Float value) {
            addCriterion("per_price_rate =", value, "perPriceRate");
            return (Criteria) this;
        }

        public Criteria andPerPriceRateNotEqualTo(Float value) {
            addCriterion("per_price_rate <>", value, "perPriceRate");
            return (Criteria) this;
        }

        public Criteria andPerPriceRateGreaterThan(Float value) {
            addCriterion("per_price_rate >", value, "perPriceRate");
            return (Criteria) this;
        }

        public Criteria andPerPriceRateGreaterThanOrEqualTo(Float value) {
            addCriterion("per_price_rate >=", value, "perPriceRate");
            return (Criteria) this;
        }

        public Criteria andPerPriceRateLessThan(Float value) {
            addCriterion("per_price_rate <", value, "perPriceRate");
            return (Criteria) this;
        }

        public Criteria andPerPriceRateLessThanOrEqualTo(Float value) {
            addCriterion("per_price_rate <=", value, "perPriceRate");
            return (Criteria) this;
        }

        public Criteria andPerPriceRateIn(List<Float> values) {
            addCriterion("per_price_rate in", values, "perPriceRate");
            return (Criteria) this;
        }

        public Criteria andPerPriceRateNotIn(List<Float> values) {
            addCriterion("per_price_rate not in", values, "perPriceRate");
            return (Criteria) this;
        }

        public Criteria andPerPriceRateBetween(Float value1, Float value2) {
            addCriterion("per_price_rate between", value1, value2, "perPriceRate");
            return (Criteria) this;
        }

        public Criteria andPerPriceRateNotBetween(Float value1, Float value2) {
            addCriterion("per_price_rate not between", value1, value2, "perPriceRate");
            return (Criteria) this;
        }

        public Criteria andDigestIsNull() {
            addCriterion("digest is null");
            return (Criteria) this;
        }

        public Criteria andDigestIsNotNull() {
            addCriterion("digest is not null");
            return (Criteria) this;
        }

        public Criteria andDigestEqualTo(String value) {
            addCriterion("digest =", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotEqualTo(String value) {
            addCriterion("digest <>", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestGreaterThan(String value) {
            addCriterion("digest >", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestGreaterThanOrEqualTo(String value) {
            addCriterion("digest >=", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLessThan(String value) {
            addCriterion("digest <", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLessThanOrEqualTo(String value) {
            addCriterion("digest <=", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLike(String value) {
            addCriterion("digest like", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotLike(String value) {
            addCriterion("digest not like", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestIn(List<String> values) {
            addCriterion("digest in", values, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotIn(List<String> values) {
            addCriterion("digest not in", values, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestBetween(String value1, String value2) {
            addCriterion("digest between", value1, value2, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotBetween(String value1, String value2) {
            addCriterion("digest not between", value1, value2, "digest");
            return (Criteria) this;
        }

        public Criteria andPriceRateIsNull() {
            addCriterion("price_rate is null");
            return (Criteria) this;
        }

        public Criteria andPriceRateIsNotNull() {
            addCriterion("price_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPriceRateEqualTo(Float value) {
            addCriterion("price_rate =", value, "priceRate");
            return (Criteria) this;
        }

        public Criteria andPriceRateNotEqualTo(Float value) {
            addCriterion("price_rate <>", value, "priceRate");
            return (Criteria) this;
        }

        public Criteria andPriceRateGreaterThan(Float value) {
            addCriterion("price_rate >", value, "priceRate");
            return (Criteria) this;
        }

        public Criteria andPriceRateGreaterThanOrEqualTo(Float value) {
            addCriterion("price_rate >=", value, "priceRate");
            return (Criteria) this;
        }

        public Criteria andPriceRateLessThan(Float value) {
            addCriterion("price_rate <", value, "priceRate");
            return (Criteria) this;
        }

        public Criteria andPriceRateLessThanOrEqualTo(Float value) {
            addCriterion("price_rate <=", value, "priceRate");
            return (Criteria) this;
        }

        public Criteria andPriceRateIn(List<Float> values) {
            addCriterion("price_rate in", values, "priceRate");
            return (Criteria) this;
        }

        public Criteria andPriceRateNotIn(List<Float> values) {
            addCriterion("price_rate not in", values, "priceRate");
            return (Criteria) this;
        }

        public Criteria andPriceRateBetween(Float value1, Float value2) {
            addCriterion("price_rate between", value1, value2, "priceRate");
            return (Criteria) this;
        }

        public Criteria andPriceRateNotBetween(Float value1, Float value2) {
            addCriterion("price_rate not between", value1, value2, "priceRate");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Float value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Float value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Float value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Float value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Float value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Float> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Float> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Float value1, Float value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Float value1, Float value2) {
            addCriterion("price not between", value1, value2, "price");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}