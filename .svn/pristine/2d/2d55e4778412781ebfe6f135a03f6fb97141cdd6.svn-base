package com.oraclewdp.crm.entity;


import com.oraclewdp.crm.persistence.Column;
import com.oraclewdp.crm.persistence.Id;
import com.oraclewdp.crm.persistence.Table;

@Table("customer_link")
public class CustomerLink {
    @Id
    private Integer id;

    private boolean sex;

    private String name;

    private String position;

    private String phone;

    private String phone2;

    private String content;
    @Column(value = "customer_id",target = "id",foreign = "customer")
    private Customer customer;

    private String birthdate;

    private String email;
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CustomerLink [id=" + id + ", sex=" + sex + ", name=" + name
				+ ", position=" + position + ", phone=" + phone + ", phone2="
				+ phone2 + ", content=" + content + ", customer=" + customer
				+ ", birthdate=" + birthdate + ", email=" + email + "]";
	}
    
	
    
}