package com.oraclewdp.crm.entity;

import com.oraclewdp.crm.persistence.Column;
import com.oraclewdp.crm.persistence.Id;

public class Customer {
    @Id
    private Integer id;

    private String code;

    @Column(value = "customer_type",foreign = "dic_all",target = "id")
    private DicAll type;



    private String name;

    private String phone;

    private String email;

    private String adress;

    private String qq;

    private String createdate;

    @Column(value = "creator_id",foreign = "user",target = "id")
    private User creator;
   
    @Column(value = "sales_id",foreign = "user",target = "id")
    private User sales;

    @Column(value = "provence_id",foreign = "base_area",target = "id")
    private BaseArea provence;

    @Column(value = "city_id",foreign = "base_area",target = "id")
    private BaseArea city;

    @Column(value = "county_id",foreign = "base_area",target = "id")
    private BaseArea county;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DicAll getType() {
		return type;
	}

	public void setType(DicAll type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public User getCreatorId() {
		return creator;
	}

	public void setCreatorId(User creator) {
		this.creator = creator;
	}

	public User getSales() {
		return sales;
	}

	public void setSales(User sales) {
		this.sales = sales;
	}

	public BaseArea getProvence() {
		return provence;
	}

	public void setProvence(BaseArea provence) {
		this.provence = provence;
	}

	public BaseArea getCity() {
		return city;
	}

	public void setCity(BaseArea city) {
		this.city = city;
	}

	public BaseArea getCounty() {
		return county;
	}

	public void setCounty(BaseArea county) {
		this.county = county;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", code=" + code + ", type=" + type
				+ ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", adress=" + adress + ", qq=" + qq + ", createdate="
				+ createdate + ", creator=" + creator + ", sales=" + sales
				+ ", provence=" + provence + ", city=" + city + ", county="
				+ county + "]";
	}

	
    
}