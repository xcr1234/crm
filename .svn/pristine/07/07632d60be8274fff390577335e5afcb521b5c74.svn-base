package com.oraclewdp.crm.service.serviceimpl;

import com.oraclewdp.crm.dao.CustomerDao;
import com.oraclewdp.crm.dao.UserRoleDao;
import com.oraclewdp.crm.dao.impl.CustomerDaoImpl;
import com.oraclewdp.crm.dao.impl.UserRoleDaoImpl;
import com.oraclewdp.crm.entity.Customer;
import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.service.KhxxglService;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.Pages;

import java.sql.Connection;

public class KhxxglServiceImpl implements KhxxglService{

	 private Connection connection=JdbcUtil.getInstance().getConnection();
	 private CustomerDao customerDao=new CustomerDaoImpl(connection);
	 private UserRoleDao userRoleDao=new UserRoleDaoImpl(connection);
	 @Override
	public Pages<Customer> listCustomerBySql(String sql,Object[] params){
		 Pages<Customer> pages=null;
		 pages=customerDao.findAll(Customer.class, sql, params);
		 return pages;
	}

	@Override
	public Pages<Customer> listCustomerByUserRole() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public UserRole getUserRole(int userRoleId) {
		UserRole userRole=userRoleDao.find(userRoleId, UserRole.class);
		return userRole;
	}
	
	@Override
	public Pages<Customer> getAll() {
		Pages<Customer> page=customerDao.findAll(Customer.class);
		return page;
	}
}
