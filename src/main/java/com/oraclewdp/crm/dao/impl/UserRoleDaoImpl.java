package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;

import com.oraclewdp.crm.dao.UserRoleDao;
import com.oraclewdp.crm.entity.UserRole;

public class UserRoleDaoImpl extends DaoImpl<UserRole> implements UserRoleDao{

	public UserRoleDaoImpl(Connection connection) {
		super(connection);
	}
  
}
