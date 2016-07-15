package com.oraclewdp.crm.entity;

import com.oraclewdp.crm.persistence.Id;
import com.oraclewdp.crm.persistence.Table;

@Table("dic_all")
public class DicAll {
    @Id
    private Integer id;

    private String type;

    private String name;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "DicAll [id=" + id + ", type=" + type + ", name=" + name
				+ ", status=" + status + "]";
	}
    
    
}