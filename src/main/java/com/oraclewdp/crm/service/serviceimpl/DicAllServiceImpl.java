package com.oraclewdp.crm.service.serviceimpl;

import java.sql.Connection;

import com.oraclewdp.crm.dao.DicAllDao;
import com.oraclewdp.crm.dao.impl.DicAllDaoImpl;
import com.oraclewdp.crm.entity.DicAll;
import com.oraclewdp.crm.service.DicAllService;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.Pages;

public class DicAllServiceImpl implements DicAllService{

	private Connection connection=JdbcUtil.getInstance().getConnection();
	private DicAllDao dicAllDao=new DicAllDaoImpl(connection);
	private Pages<DicAll> page=null;
	private DicAll dicAll=null;
	
	@Override
	public DicAll getDicAll(String type) {
		String sql="select * from dic_all where type=?";
		page=dicAllDao.findAll(DicAll.class, sql, type);
		dicAll=page.getItems().get(0);
		return dicAll;
	}

}
