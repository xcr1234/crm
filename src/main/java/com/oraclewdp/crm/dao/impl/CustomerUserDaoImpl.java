package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;

import com.oraclewdp.crm.dao.CustomerUserDao;
import com.oraclewdp.crm.entity.CustomerUser;

public class CustomerUserDaoImpl extends DaoImpl<CustomerUser> implements CustomerUserDao{

	public CustomerUserDaoImpl(Connection connection) {
		super(connection);
	}

}
