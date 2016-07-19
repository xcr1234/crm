package com.oraclewdp.crm.entity;

import com.oraclewdp.crm.persistence.Column;
import com.oraclewdp.crm.persistence.Id;

public class Contact {
    @Id
    private Integer id;
    @Column(value = "contactor",foreign = "user",target = "id")
    private User contact;
    @Column(value = "creator",foreign = "user",target = "id")
    private User creator;

    private String createdate;

    private Integer customerId;

    private String phone;

    private String content;

    private String remark;
    
    private String startTime;
    
    private String endTime;

    private Integer attachId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getContact() {
		return contact;
	}

	public void setContact(User contact) {
		this.contact = contact;
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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public Integer getAttachId() {
		return attachId;
	}

	public void setAttachId(Integer attachId) {
		this.attachId = attachId;
	}

   
}