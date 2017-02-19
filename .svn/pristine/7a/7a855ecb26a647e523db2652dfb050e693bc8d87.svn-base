package com.oraclewdp.crm.entity;

import com.oraclewdp.crm.persistence.Column;
import com.oraclewdp.crm.persistence.Id;
import com.oraclewdp.crm.persistence.Table;

import static javafx.scene.input.KeyCode.V;

@Table("bjd_list")
public class BjdList {
    @Id
    private Integer id;
    @Column(value = "goods_id",target = "id",foreign = "goods")
    private Goods goods;
    @Column(value = "bjd_id",target = "bjd",foreign = "id")
    private Bjd bjd;

    private Integer count;

    private Integer rate;

    private Float perPriceRate;

    private String digest;

    private Float priceRate;

    private Float price;

    private Float totlePrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Bjd getBjd() {
        return bjd;
    }

    public void setBjd(Bjd bjd) {
        this.bjd = bjd;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Float getPerPriceRate() {
        return perPriceRate;
    }

    public void setPerPriceRate(Float perPriceRate) {
        this.perPriceRate = perPriceRate;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public Float getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(Float priceRate) {
        this.priceRate = priceRate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(Float totlePrice) {
        this.totlePrice = totlePrice;
    }
}