package com.oraclewdp.crm.service;

import java.sql.Connection;

import com.oraclewdp.crm.dao.CustomerDao;
import com.oraclewdp.crm.dao.impl.CustomerDaoImpl;
import com.oraclewdp.crm.entity.Customer;
import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.Pages;

public interface KhxxglService {
	
	/**
	 * 根据sql语句查询客户
	 * @author gui
	 * @time 2016年7月19日 上午12:37:00
	 * @tags @return
	 */
     public Pages<Customer> listCustomerBySql(String sql,Object[] params);

    /**
     * 根据不同的权限得到不同的内容
     */
     public Pages<Customer> listCustomerByUserRole();

     public UserRole getUserRole(int userRoleId);
     
     public Pages<Customer> getAll();
}
