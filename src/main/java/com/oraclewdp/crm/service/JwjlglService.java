package com.oraclewdp.crm.service;

import com.oraclewdp.crm.entity.Contact;
import com.oraclewdp.crm.entity.CustomerLink;
import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.util.Pages;

public interface JwjlglService {

	/**
	 * 查出所有交往记录
	 * @author gui
	 * @time 2016年7月20日 下午3:30:13
	 * @tags @param userRole
	 * @tags @return
	 */
	public Pages<Contact> listJwjl(UserRole userRole);
	
	/**
	 * 根据userRoleId查userRole
	 * @author gui
	 * @time 2016年7月20日 下午3:41:17
	 * @tags @param userRoleId
	 * @tags @return
	 */
	public UserRole getUserRole(int userRoleId);
	
	public Pages<CustomerLink> getAllCustomerLink();
	
	public CustomerLink getCustomerLink(int linkId);
	
	public int saveContact(Contact contact);
}
