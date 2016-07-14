package com.oraclewdp.crm.entity;

import com.oraclewdp.crm.persistence.Column;
import com.oraclewdp.crm.persistence.Id;

public class Bjd {
    @Id
    private Integer id;


    @Column(foreign = "customer" ,target = "id")
    private Customer sskh;
    @Column(foreign = "user",target = "id")
    private User bjr;

    private String yxrq;

    private String bjrq;

    private String phone;

    private String creator;
    @Column("bjd_code")
    private String code;

    @Column(value = "custom_chance_id",foreign = "custom_chance",target = "id")
    private CustomChance customChance;

    private String createdate;

    private Integer discount;

    private Integer totleCount;

    private Float totleRate;

    private Float totlePrePriceRate;

    private Float totlePriceRate;

    private Float totlePrice;

    private Float totleDiscountPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getSskh() {
        return sskh;
    }

    public void setSskh(Customer sskh) {
        this.sskh = sskh;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getBjr() {
        return bjr;
    }

    public void setBjr(User bjr) {
        this.bjr = bjr;
    }

    public String getYxrq() {
        return yxrq;
    }

    public void setYxrq(String yxrq) {
        this.yxrq = yxrq;
    }

    public String getBjrq() {
        return bjrq;
    }

    public void setBjrq(String bjrq) {
        this.bjrq = bjrq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public CustomChance getCustomChance() {
        return customChance;
    }

    public void setCustomChance(CustomChance customChance) {
        this.customChance = customChance;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getTotleCount() {
        return totleCount;
    }

    public void setTotleCount(Integer totleCount) {
        this.totleCount = totleCount;
    }

    public Float getTotleRate() {
        return totleRate;
    }

    public void setTotleRate(Float totleRate) {
        this.totleRate = totleRate;
    }

    public Float getTotlePrePriceRate() {
        return totlePrePriceRate;
    }

    public void setTotlePrePriceRate(Float totlePrePriceRate) {
        this.totlePrePriceRate = totlePrePriceRate;
    }

    public Float getTotlePriceRate() {
        return totlePriceRate;
    }

    public void setTotlePriceRate(Float totlePriceRate) {
        this.totlePriceRate = totlePriceRate;
    }

    public Float getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(Float totlePrice) {
        this.totlePrice = totlePrice;
    }

    public Float getTotleDiscountPrice() {
        return totleDiscountPrice;
    }

    public void setTotleDiscountPrice(Float totleDiscountPrice) {
        this.totleDiscountPrice = totleDiscountPrice;
    }
}