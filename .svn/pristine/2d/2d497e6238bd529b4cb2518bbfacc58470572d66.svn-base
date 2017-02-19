package com.oraclewdp.crm.service.serviceimpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
	private List<DicAll> dicAllList=new ArrayList<DicAll>();
	
	@Override
	public List<DicAll> getDicAll(String type) {
		String sql="select * from dic_all where type=?";
		Object[] params={type};
		page=dicAllDao.findAll(DicAll.class, sql, params);
		dicAllList=page.getItems();
		return dicAllList;
	}
	
	@Override
	public boolean setKhCode(String khCode) {
		String sql="select * from dic_all where type=kh_code";
		DicAll dicAll=dicAllDao.find(sql, DicAll.class);
		dicAll.setName(khCode);
		boolean flag=dicAllDao.update(dicAll);
		return flag;
	}

}
