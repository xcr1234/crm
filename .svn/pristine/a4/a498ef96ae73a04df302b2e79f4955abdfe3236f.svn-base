package com.oraclewdp.crm.entity;

import com.oraclewdp.crm.persistence.Column;
import com.oraclewdp.crm.persistence.Id;

public class Contact {
    @Id
    private Integer id;
    @Column(value = "contactor",foreign = "customer_link",target = "id")
    private CustomerLink contactor;
    @Column(value = "creator",foreign = "user",target = "id")
    private User creator;
    @Column(value="customer_id",foreign="customer",target="id")
    private Customer customer;
    
    private String createdate;

    private String phone;

    private String content;

    private String remark;
    
    private String startTime;
    
    private String endTime;
    
    private String context;
    
    @Column(value="attach_id",foreign="attach",target="id")
    private Attach attach;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public CustomerLink getContactor() {
		return contactor;
	}

	public void setContactor(CustomerLink contactor) {
		this.contactor = contactor;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	
	public Attach getAttach() {
		return attach;
	}

	public void setAttach(Attach attach) {
		this.attach = attach;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	
   
}