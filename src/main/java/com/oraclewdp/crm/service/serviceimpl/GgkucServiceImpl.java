package com.oraclewdp.crm.service.serviceimpl;

import java.sql.Connection;
import java.util.List;

import com.oraclewdp.crm.dao.CustomerDao;
import com.oraclewdp.crm.dao.CustomerLinkDao;
import com.oraclewdp.crm.dao.UserRoleDao;
import com.oraclewdp.crm.dao.impl.CustomerDaoImpl;
import com.oraclewdp.crm.dao.impl.CustomerLinkDaoImpl;
import com.oraclewdp.crm.dao.impl.UserRoleDaoImpl;
import com.oraclewdp.crm.entity.Customer;
import com.oraclewdp.crm.entity.CustomerLink;
import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.service.GgkhcService;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.PageUtil;
import com.oraclewdp.crm.util.Pages;

public class GgkucServiceImpl implements GgkhcService {
	private Connection connection = JdbcUtil.getInstance().getConnection();
	private CustomerLinkDao customerLinkDao = new CustomerLinkDaoImpl(
			connection);
	private CustomerDao customerDao = new CustomerDaoImpl(connection);
	private UserRoleDao userRoleDao=new UserRoleDaoImpl(connection);
	Pages<Customer> page = null;

	@Override
	public Pages<Customer> listGgkhc(int pageIndex, int pageNum) {
		page = customerDao.findAll(Customer.class, pageNum, pageIndex);
		return page;
	}

	@Override
	public int saveGgkuc(Customer customer) {
		int id=customerDao.save(customer);
		return id;
	}

	@Override
	public int saveCustomerLink(CustomerLink customerLink) {
		int id=customerLinkDao.save(customerLink);
		return id;
	}

	@Override
	public Pages<UserRole> listUserRole() {
		Pages<UserRole> pages=new PageUtil();
		pages=userRoleDao.findAll(UserRole.class);
		return pages;
	}

	@Override
	public Pages<Customer> search(String sql,int pageIndex,int pageNum,Object[] params) {
		page=customerDao.findAll(Customer.class, sql, pageNum, pageIndex, params);
		return page;
	}

	@Override
	public Pages<Customer> searchBySql(String sql) {
		
		return null;
	}
	
	@Override
	public Customer detail(int id) {
		Customer customer=new Customer();
		customer=customerDao.find(id, Customer.class);
		return customer;
	}
	
	@Override
	public List<CustomerLink> detailLink(Customer customer) {
	   int id=customer.getId();
	   CustomerLink customerLink=new CustomerLink();
	   String sql="select * from customer_link where customer_id=?";
	   Object[] params={id};
	   Pages<CustomerLink> pages=new PageUtil();
	   pages=customerLinkDao.findAll(CustomerLink.class, sql, params);
	   return pages.getItems();
	}
}
