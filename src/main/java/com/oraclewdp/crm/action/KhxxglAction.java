package com.oraclewdp.crm.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.crm.entity.Customer;
import com.oraclewdp.crm.entity.DicAll;
import com.oraclewdp.crm.service.DicAllService;
import com.oraclewdp.crm.service.GgkhcService;
import com.oraclewdp.crm.service.KhxxglService;
import com.oraclewdp.crm.service.serviceimpl.DicAllServiceImpl;
import com.oraclewdp.crm.service.serviceimpl.GgkucServiceImpl;
import com.oraclewdp.crm.service.serviceimpl.KhxxglServiceImpl;
import com.oraclewdp.crm.util.ActionSupport;
import com.oraclewdp.crm.util.Pages;
import com.oraclewdp.crm.util.ResultUtil;

@WebServlet("/khxxgl.do")
public class KhxxglAction extends ActionSupport{
    private DicAllService dicAllService=new DicAllServiceImpl();
	private KhxxglService khxxglService=new KhxxglServiceImpl();
	/**
	 * 列出该用户创建的客户
	 * @author gui
	 * @time 2016年7月19日 上午12:29:28
	 * @tags
	 */
	public void listKhxx(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		//列出客户类型的下拉框
	    List<DicAll> dicAlls=null;
		dicAlls=dicAllService.getDicAll("khlx");
		req.setAttribute("khlx", dicAlls);
		
		//列出对应用户的客户
		int userId=Integer.parseInt(req.getParameter("userId"));
		String sql="select * from customer where delflag=0 and creator_id=?";
		Object[] params={userId};
		Pages<Customer> page=khxxglService.listCustomerBySql(sql, params);
	    req.setAttribute("page", page);
	    
	    returnView("khxxgl", req, resp);
	
	}
}
