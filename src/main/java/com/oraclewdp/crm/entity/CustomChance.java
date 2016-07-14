package com.oraclewdp.crm.entity;

import com.oraclewdp.crm.persistence.Column;
import com.oraclewdp.crm.persistence.Table;

@Table("custom_chance")
public class CustomChance {
    private Integer id;

    private String code;

    private String name;

    private DicAll type;

    private User creator;

    private String createdate;

    private Attach attach;

    private DicAll chanceStage;

    private String possibility;
    @Column(value = "customer_id",foreign = "customer",target = "id")
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DicAll getType() {
        return type;
    }

    public void setType(DicAll type) {
        this.type = type;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public Attach getAttach() {
        return attach;
    }

    public void setAttach(Attach attach) {
        this.attach = attach;
    }

    public DicAll getChanceStage() {
        return chanceStage;
    }

    public void setChanceStage(DicAll chanceStage) {
        this.chanceStage = chanceStage;
    }

    public String getPossibility() {
        return possibility;
    }

    public void setPossibility(String possibility) {
        this.possibility = possibility;
    }
}