package com.oraclewdp.crm.entity;

import com.oraclewdp.crm.persistence.Column;
import com.oraclewdp.crm.persistence.Id;
import com.oraclewdp.crm.persistence.Table;

@Table("custom_chance")
public class CustomChance {
    @Id
    private Integer id;

    private String code;

    private String name;
    @Column(value = "type",foreign = "dic_all",target = "id")
    private DicAll type;
    @Column(value = "creator",foreign = "user",target = "id")
    private User creator;

    private String createdate;
    @Column(value = "attach_id",foreign = "attach",target = "id")
    private Attach attach;
    @Column(value = "chance_stage",foreign = "dic_all",target = "id")
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