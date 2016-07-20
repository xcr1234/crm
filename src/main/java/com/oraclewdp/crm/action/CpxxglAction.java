package com.oraclewdp.crm.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.crm.entity.DicAll;
import com.oraclewdp.crm.entity.Goods;
import com.oraclewdp.crm.service.CpxxglService;
import com.oraclewdp.crm.service.DicAllService;
import com.oraclewdp.crm.service.KhxxglService;
import com.oraclewdp.crm.service.serviceimpl.CpxxglServiceImpl;
import com.oraclewdp.crm.service.serviceimpl.DicAllServiceImpl;
import com.oraclewdp.crm.util.ActionSupport;
import com.oraclewdp.crm.util.DateUtil;
import com.oraclewdp.crm.util.ExcelUtil;
import com.oraclewdp.crm.util.Pages;

@WebServlet("/cpxxgl.do")
public class CpxxglAction extends ActionSupport{
    private DicAllService dicAllService=new DicAllServiceImpl();
	private CpxxglService cpxxglService=new CpxxglServiceImpl();
	/**
	 * 列出产品信息
	 * @author gui
	 * @time 2016年7月19日 上午9:23:43
	 * @tags
	 */
	public void listGoods(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		Pages<Goods> page=null;
		page=cpxxglService.listGoods();
		String pages=req.getParameter("page");
		if(pages!=null&&!pages.equals("")){
			int pageIndex=Integer.parseInt(pages);
			page.toPage(pageIndex);
		}else{
			page.toPage(1);
		}
		
		//excel的导出
		/*File excel=new File("d://产品报表.xls");
		if(!excel.exists()){
			excel.mkdir();
		}
		 Map<String, String> fieldMap=new LinkedHashMap<String, String>();
		 fieldMap.put("id", "ID");
		 fieldMap.put("name", "产品名称");
		 fieldMap.put("code", "产品编码");
		 fieldMap.put("model", "规格型号");
		 fieldMap.put("unit.name", "单位");
		 fieldMap.put("kcsl", "库存数量");
		 fieldMap.put("kykc", "可用库存");
		 fieldMap.put("price", "建议售价");
		 fieldMap.put("creator.name", "创建人");
		 fieldMap.put("createTime", "创建时间");
		 OutputStream out=new FileOutputStream(excel);
		 ExcelUtil.listToExcel(page.getItems(), fieldMap, "报表", out);*/
		  req.setAttribute("page", page);
         returnView("cpxxgl", req, resp);
		
	}
	
	/**
	 * 添加产品信息
	 * @author gui
	 * @time 2016年7月19日 上午9:35:31
	 * @tags @param req
	 * @tags @param resp
	 * @tags @throws ServletException
	 * @tags @throws IOException
	 */
	public void cpxx_add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		Goods goods=new Goods();
		int creatorId=Integer.parseInt(req.getParameter("userId"));
		//接收信息
		String name=req.getParameter("goods_name");
		String code=req.getParameter("goods_code");
		String model=req.getParameter("goods_model");
		/*String time=req.getParameter("goods_createTime");
		System.out.println("time:"+time);*/
		//下面是要进行数据格式转换的，需要判空。
		String int_unit=req.getParameter("goods_unit");
        String int_kcsl=req.getParameter("goods_kcsl");
		String int_kykc=req.getParameter("goods_kykc");
		String float_price=req.getParameter("goods_price");
		if(int_kcsl!=null&&!int_kcsl.equals("")){
			int kcsl=Integer.parseInt(int_kcsl);
			goods.setKcsl(kcsl);
		}
		if(int_kykc!=null&&!int_kykc.equals("")){
			int kykc=Integer.parseInt(int_kykc);
			goods.setKykc(kykc);
		}
		if(float_price!=null&&!float_price.equals("")){
			float price=Float.parseFloat(float_price);
			goods.setPrice(price);
		}
		if(int_unit!=null&&!int_unit.equals("")){
			int unitId=Integer.parseInt(int_unit);
			goods.setUnit(cpxxglService.getUnitById(unitId));
		}
		
		goods.setCreator(cpxxglService.getCreatorById(creatorId));
		goods.setCode(code);
		goods.setModel(model);
		goods.setName(name);
		goods.setCreateTime(DateUtil.getDateTimeStrByFormat(new Date(), "yyyy-MM-dd"));
		goods.setStatus(true);

		int id=0;
		id=cpxxglService.saveGoods(goods);
		if(id!=0){
			req.setAttribute("info", "保存成功！");
			req.getRequestDispatcher("cpxxgl.do?method=listGoods").forward(req, resp);
		}
		
	}
	
	/**
	 * 编辑产品信息(限管理员)
	 * @author gui
	 * @time 2016年7月19日 上午9:36:12
	 * @tags @param req
	 * @tags @param resp
	 * @tags @throws ServletException
	 * @tags @throws IOException
	 */
	public void cpxx_edit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
	}
	
	/**
	 * 产品信息删除操作
	 * @author gui
	 * @time 2016年7月19日 上午9:37:28
	 * @tags @param req
	 * @tags @param resp
	 * @tags @throws ServletException
	 * @tags @throws IOException
	 */
	public void cpxx_delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
	}
	
	/**
	 * 进入新增产品的页面,获得计量单位和当前时间
	 * @author gui
	 * @time 2016年7月19日 下午2:08:02
	 * @tags @param req
	 * @tags @param resp
	 * @tags @throws ServletException
	 * @tags @throws IOException
	 */
	public void goto_add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		//获得当前服务器时间，返回给前台。
		Calendar cd=Calendar.getInstance();
		Date date=cd.getTime();
		String time=DateUtil.getDateTimeStrByFormat(date, "yyyy-MM-dd");
		req.setAttribute("time", time);
		//获取计量单位下拉列表
		List<DicAll> selects=dicAllService.getDicAll("jldw");
		req.setAttribute("jldw", selects);

		returnView("cpxx_add", req, resp);	
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		CpxxglService cpxxglService=new CpxxglServiceImpl();
	    Pages<Goods> pages=cpxxglService.listGoods();
	    List<Goods> list=pages.getItems();
	    Map<String, String> fieldMap=new LinkedHashMap<String, String>();
	    OutputStream out=new FileOutputStream(new File("d://产品报表.xls"));
	    ExcelUtil.listToExcel(list, fieldMap, "报表", out);
	}
	
}
