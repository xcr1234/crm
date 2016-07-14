package com.oraclewdp.crm.entity;

import com.oraclewdp.crm.persistence.Id;

public class Menu {
    @Id
    private Integer id;

    private Integer level;

    private String context;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}