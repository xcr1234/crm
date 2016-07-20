package com.oraclewdp.crm.service.serviceimpl;

import java.sql.Connection;

import com.oraclewdp.crm.dao.DicAllDao;
import com.oraclewdp.crm.dao.GoodsDao;
import com.oraclewdp.crm.dao.UserDao;
import com.oraclewdp.crm.dao.impl.DicAllDaoImpl;
import com.oraclewdp.crm.dao.impl.GoodsDaoImpl;
import com.oraclewdp.crm.dao.impl.UserDaoImpl;
import com.oraclewdp.crm.entity.DicAll;
import com.oraclewdp.crm.entity.Goods;
import com.oraclewdp.crm.entity.User;
import com.oraclewdp.crm.service.CpxxglService;
import com.oraclewdp.crm.util.JdbcPage;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.Pages;

public class CpxxglServiceImpl implements CpxxglService {

	private Connection connection = JdbcUtil.getInstance().getConnection();
	private GoodsDao goodsDao = new GoodsDaoImpl(connection);
	private UserDao userDao = new UserDaoImpl(connection);
	private DicAllDao dicAllDao = new DicAllDaoImpl(connection);

	@Override
	public Pages<Goods> listGoodsByPage(int pageSize, int pageNum) {
		Pages<Goods> pages = null;
		pages = goodsDao.findAll(Goods.class, pageNum, pageSize);
		return pages;
	}

	@Override
	public Goods getGoodsById(int id) {
		Goods goods = null;
		goods = goodsDao.find(id, Goods.class);
		return goods;
	}

	@Override
	public User getCreatorById(int id) {
		User user = null;
		user = userDao.find(id, User.class);
		return user;
	}

	@Override
	public DicAll getUnitById(int id) {
		DicAll unit = null;
		unit = dicAllDao.find(id, DicAll.class);
		return unit;
	}

	@Override
	public Pages<Goods> listGoods() {
		String sql = "select * from goods where status=?";
		Object[] params = { 1 };
		Pages<Goods> pages = goodsDao.findAll(Goods.class, sql, params);
		return pages;
	}

	@Override
	public Integer saveGoods(Goods goods) {
		int id=0;
		id=goodsDao.save(goods);
		return id;
	}
}
