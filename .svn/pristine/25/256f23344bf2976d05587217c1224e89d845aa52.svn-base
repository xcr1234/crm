package com.oraclewdp.crm.entity;

import com.oraclewdp.crm.persistence.Column;
import com.oraclewdp.crm.persistence.Id;
import com.oraclewdp.crm.persistence.Table;

@Table("customer_user")
public class CustomerUser {

	@Id
	private Integer id;
	@Column(value = "customerId",foreign = "customer",target = "id")
	private Customer customer;
	@Column(value = "userId",foreign = "user",target = "id")
	private User user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
