package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;

import com.oraclewdp.crm.dao.RoleDao;
import com.oraclewdp.crm.entity.Role;

public class RoleDaoImpl extends DaoImpl<Role> implements RoleDao{

	public RoleDaoImpl(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

}
