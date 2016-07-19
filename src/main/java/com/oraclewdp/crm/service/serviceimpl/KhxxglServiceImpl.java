package com.oraclewdp.crm.service.serviceimpl;

import java.sql.Connection;

import com.oraclewdp.crm.dao.CustomerDao;
import com.oraclewdp.crm.dao.impl.CustomerDaoImpl;
import com.oraclewdp.crm.entity.Customer;
import com.oraclewdp.crm.service.KhxxglService;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.PageUtil;
import com.oraclewdp.crm.util.Pages;

public class KhxxglServiceImpl implements KhxxglService{

	 private Connection connection=JdbcUtil.getInstance().getConnection();
	 private CustomerDao customerDao=new CustomerDaoImpl(connection);
	
	 @Override
	public Pages<Customer> listCustomerBySql(String sql,Object[] params){
		 Pages<Customer> pages=null;
		 pages=customerDao.findAll(Customer.class, sql, params);
		 return pages;
	}
}
