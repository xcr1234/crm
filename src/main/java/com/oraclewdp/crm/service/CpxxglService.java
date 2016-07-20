package com.oraclewdp.crm.service;

import com.oraclewdp.crm.entity.DicAll;
import com.oraclewdp.crm.entity.Goods;
import com.oraclewdp.crm.entity.User;
import com.oraclewdp.crm.util.Pages;

public interface CpxxglService {
   
	/**
	 * 分页查询产品
	 * @author gui
	 * @time 2016年7月19日 上午9:26:33
	 * @tags @param pageSize
	 * @tags @param pageNum
	 * @tags @return
	 */
	public Pages<Goods> listGoodsByPage(int pageSize,int pageNum);
	
	public Integer saveGoods(Goods goods);
	public Pages<Goods> listGoods();
	public Goods getGoodsById(int id);
	
	public User getCreatorById(int id);
	
	public DicAll getUnitById(int id);
}
