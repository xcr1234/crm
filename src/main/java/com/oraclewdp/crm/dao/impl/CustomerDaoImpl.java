package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;

import com.oraclewdp.crm.dao.CustomerDao;
import com.oraclewdp.crm.entity.Customer;

public class CustomerDaoImpl extends DaoImpl<Customer> implements CustomerDao{

	public CustomerDaoImpl(Connection connection) {
		super(connection);
	}

}
