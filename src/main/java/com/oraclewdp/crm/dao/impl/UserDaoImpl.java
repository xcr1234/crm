package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;

import com.oraclewdp.crm.dao.UserDao;
import com.oraclewdp.crm.entity.User;

public class UserDaoImpl extends DaoImpl<User> implements  UserDao {

	public UserDaoImpl(Connection connection) {
		super(connection);
	}

}
