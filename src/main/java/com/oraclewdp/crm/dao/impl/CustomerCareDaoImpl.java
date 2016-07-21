package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;



import com.oraclewdp.crm.dao.CustomerCareDao;
import com.oraclewdp.crm.entity.CustomerCare;

public class CustomerCareDaoImpl extends DaoImpl<CustomerCare> implements CustomerCareDao{

	public CustomerCareDaoImpl(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}



}
