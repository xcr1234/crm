package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;

import com.oraclewdp.crm.dao.RoleAuthorityDao;
import com.oraclewdp.crm.entity.RoleAuthority;

public class RoleAuthorityDaoImpl extends DaoImpl<RoleAuthority> implements RoleAuthorityDao{

	public RoleAuthorityDaoImpl(Connection connection) {
		super(connection);
	}

}
