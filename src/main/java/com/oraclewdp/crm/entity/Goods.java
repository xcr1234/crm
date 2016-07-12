package com.oraclewdp.crm.entity;

public class Goods {
    private Integer id;

    private String name;

    private String code;

    private String picture;

    private String model;

    private Integer unit;

    private Integer kcsl;

    private Integer kykc;

    private Float price;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getKcsl() {
        return kcsl;
    }

    public void setKcsl(Integer kcsl) {
        this.kcsl = kcsl;
    }

    public Integer getKykc() {
        return kykc;
    }

    public void setKykc(Integer kykc) {
        this.kykc = kykc;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}