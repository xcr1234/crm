package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;

import com.oraclewdp.crm.dao.GoodsDao;
import com.oraclewdp.crm.entity.Goods;

public class GoodsDaoImpl extends DaoImpl<Goods> implements GoodsDao{

	public GoodsDaoImpl(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

}
