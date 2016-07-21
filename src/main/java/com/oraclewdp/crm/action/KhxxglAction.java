package com.oraclewdp.crm.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.crm.entity.Customer;
import com.oraclewdp.crm.entity.DicAll;
import com.oraclewdp.crm.entity.UserRole;
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
	 * 列出该用户创建的客户，必须的参数为userRoleId
	 * @author gui
	 * @time 2016年7月19日 上午12:29:28
	 * @tags
	 */
	public void listKhxx(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		Pages<Customer> page=null;
		int userRoleId=Integer.parseInt(req.getParameter("userRoleId"));
		//列出客户类型的下拉框
	    List<DicAll> dicAlls=null;
		dicAlls=dicAllService.getDicAll("khlx");
		req.setAttribute("khlx", dicAlls);
		
		//根据权限来列出不同的信息
		//列出对应用户的客户
		UserRole userRole=khxxglService.getUserRole(userRoleId);
		int userId=userRole.getUser().getId();
		//如果是管理员则全部显示
		if(userRole.getRole().getName().equals("管理员")){
			page=khxxglService.getAll();
		}else{
			String sql="select * from customer where delflag=0 and creator_id=?";
			Object[] params={userId};
			page=khxxglService.listCustomerBySql(sql, params);
		}
		//是否分页
		String pages=req.getParameter("page");
		if(pages!=null&&!pages.equals("")){
			int pageIndex=Integer.parseInt(pages);
			page.toPage(pageIndex);
		}else{
			page.toPage(1);
		}
		
		req.setAttribute("page", page);
	    
	    returnView("khxxgl", req, resp);
	
	}
}
