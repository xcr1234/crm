package com.oraclewdp.crm.action;

import com.oraclewdp.crm.entity.*;
import com.oraclewdp.crm.service.DicAllService;
import com.oraclewdp.crm.service.GgkhcService;
import com.oraclewdp.crm.service.UserService;
import com.oraclewdp.crm.service.serviceimpl.DicAllServiceImpl;
import com.oraclewdp.crm.service.serviceimpl.GgkucServiceImpl;
import com.oraclewdp.crm.service.serviceimpl.UserServiceImpl;
import com.oraclewdp.crm.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@WebServlet("/ggkhc.do")
public class GgkhcAction extends ActionSupport{
	private GgkhcService ggkhcService=new GgkucServiceImpl();
	private DicAllService dicAllService=new DicAllServiceImpl();
	private Customer customer=new Customer();
	private Pages<Customer> page=new PageUtil();
    private UserService userService=new UserServiceImpl();
   
    public void kh_add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		/*User user=new User();
		BaseArea baseArea=new BaseArea();
		Map<String, Object> map=getObject(req);
	    user=(User)map.get("User");  
		DicAll dicAll=(DicAll)map.get("DicAll");  
		Customer customer=(Customer)map.get("Customer");  //客户表本身字段信息
		
		customer.setCreator(user); //创建人
		customer.setType(dicAll);   //客户类型	
		//销售负责人
		user=null;
		user.setId(Integer.parseInt(req.getParameter("sales")));
	    customer.setSales(user);  */
		//客户编码
	    customer.setCode(CodeUtil.getKhCode());
		String customer_name=req.getParameter("customer_name");
		String customer_code=req.getParameter("customer_code");
		String user_creatorid=req.getParameter("user_creatorid");
		String customer_phone=req.getParameter("customer_phone");
		String customer_email=req.getParameter("customer_email");
		String customer_adress=req.getParameter("customer_adress");
		String customer_qq=req.getParameter("customer_qq");
		String customer_province=req.getParameter("customer_province");
		String customer_city=req.getParameter("customer_city");
		String customer_county=req.getParameter("customer_county");
		String salesid=req.getParameter("salesid");
		String dicAll_typeid=req.getParameter("dicAll_typeid");
		String customer_createdate=req.getParameter("customer_createdate");
	    if(dicAll_typeid!=null&&dicAll_typeid!=""){
	    	int typeId=Integer.parseInt(dicAll_typeid);
	    	DicAll dicAll=new DicAll();
	    	dicAll.setId(typeId);
	    	customer.setType(dicAll);
	    }
		if(user_creatorid!=null&&user_creatorid!=""){
	    	int creatorId=Integer.parseInt(user_creatorid);
	    	User user=new User();
	    	user.setId(creatorId);
	    	customer.setCreator(user);
	    }
	    if(salesid!=null&&salesid!=""){
	    	int salesId=Integer.parseInt(salesid);
	    	User user=new User();
	    	user.setId(salesId);
	    	customer.setSales(user);;
	    }
	    customer.setName(customer_name);
	    customer.setAdress(customer_adress);
	    customer.setCity(customer_city);
	    customer.setCounty(customer_county);
	    customer.setCreatedate(customer_createdate);
	    customer.setEmail(customer_email);
	    customer.setName(customer_name);
	    customer.setPhone(customer_phone);
	    customer.setProvince(customer_province);
	    customer.setQq(customer_qq);
		
		 
	    int id=ggkhcService.saveGgkuc(customer);
	    customer.setId(id);
	    
	   /* //下面保存客户联系人
	    int i=0; //记录前台传过来几个联系人
	    Map<String,String[]> map2=req.getParameterMap();
	    i=map2.get("listCustomerLink_name").length;
	    Map<String,String> map3=new HashMap<String, String>();//单个客户联系人的表单数组
	    List<CustomerLink> link_list=new ArrayList<CustomerLink>(); //存放联系人的集合
	    PropertyDescriptor pd=null;
	    Method setMethod=null;
	    //遍历出每一行数据,最后获得一个list集合
	    for(int j=0;j<i;j++){
	    	CustomerLink customerLink=new CustomerLink();
	    	 for(Entry<String, String[]> entry:map2.entrySet()){
	 	    	String key=entry.getKey();
	 	    	if(key.startsWith("link")){
	 	    		String columnName=key.split("_")[1];
	 	    		String value=entry.getValue()[j];
	 	    		if(value!=null&&value!=""){
	 	    			map3.put(columnName, value);
	 	    		}
	 	    		
	 	    	}
	 	    	for(Entry<String, String> entry2:map3.entrySet()){
	 	    		String columnName=entry.getKey();
	 	    		String value=entry2.getValue();
	 	    			pd=new PropertyDescriptor(columnName, CustomerLink.class);
	 	    		    setMethod=pd.getWriteMethod();
	 	    		    setMethod.invoke(customerLink, value);
	 	    	}
	 	    	customer=new Customer();
	 	    	customer.setId(id);
	 	    	customerLink.setCustomer(customer);
	 	    	link_list.add(customerLink);
	 	    }
	    }
	    //保存list里面的每一个对象
	   for(CustomerLink cl:link_list){
          
	   }
	    
	    ResultUtil result=new ResultUtil();
	    result.setInfo("保存成功！");
	    req.setAttribute("result", result);
	    returnView("", req, resp);
	}*/
	    String[] listCustomerLink_name=req.getParameterValues("listCustomerLink_name");
	    if(listCustomerLink_name!=null&&listCustomerLink_name.length>0){
	    	if(!listCustomerLink_name[0].equals("")){
	    	int count=listCustomerLink_name.length;
	    	for(int i=0;i<count;i++){
	    		CustomerLink customerLink=new CustomerLink();
	    	    String CustomerLink_name=listCustomerLink_name[i];
	    		String listCustomerLink_sexid=req.getParameterValues("listCustomerLink_sexid")[i];
	    		String listCustomerLink_position=req.getParameterValues("listCustomerLink_position")[i];
	    		String listCustomerLink_phone=req.getParameterValues("listCustomerLink_phone")[i];
	    		String listCustomerLink_phone2=req.getParameterValues("listCustomerLink_phone2")[i];
	    		String listCustomerLink_email=req.getParameterValues("listCustomerLink_email")[i];
	    		String listCustomerLink_birthdate=req.getParameterValues("listCustomerLink_birthdate")[i];
	    		String listCustomerLink_content=req.getParameterValues("listCustomerLink_content")[i];
	    	  if(listCustomerLink_sexid!=""&&listCustomerLink_sexid!=""){
	    		  int sexId=Integer.parseInt(listCustomerLink_sexid);
	    		  customerLink.setSex(sexId==1?true:false);
	    	  }
	    	  customerLink.setBirthdate(listCustomerLink_birthdate);
	    	  customerLink.setContent(listCustomerLink_content);
	    	  customerLink.setCustomer(customer);
	    	  customerLink.setEmail(listCustomerLink_email);
	    	  customerLink.setName(CustomerLink_name);
	    	  customerLink.setPhone(listCustomerLink_phone);
	    	  customerLink.setPhone2(listCustomerLink_phone2);
	    	  customerLink.setPosition(listCustomerLink_position);
	    	  System.out.println(customerLink);
	    	  ggkhcService.saveCustomerLink(customerLink);
	    	}
	    	}
	    }
	    
	    ResultUtil result=new ResultUtil();
	    result.setInfo("保存成功！");
	    req.setAttribute("result", result);
	    returnView("kh_add", req, resp);
	}
		
	
	   
	/**
	 * 列出第一页的公共客户池,同时取出所有业务员
	 * @author gui
	 * @time 2016年7月16日 上午11:24:20
	 * @tags @param req
	 * @tags @param resp
	 * @tags @throws ServletException
	 * @tags @throws IOException
	 */
	public void listGgkh(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		List<DicAll> list_khlx=dicAllService.getDicAll("khlx");
		List<DicAll> list_khly=dicAllService.getDicAll("khly");
		//列出业务员
		String sql="select * from userrole where roleId=?";
		Object[] params={3}; //业务员的ID
		Pages<UserRole> userRolePages=ggkhcService.listUserRoleBysql(sql, params);
		req.setAttribute("userRolePages", userRolePages);
		
		
		page=ggkhcService.listGgkhc(1, 8);
		req.setAttribute("khlx", list_khlx);
		req.setAttribute("khly",list_khly);
		req.setAttribute("page", page);
		returnView("ggkhc", req,resp);
	}
	
	/**
	 * 按条件搜索客户
	 * @author gui
	 * @time 2016年7月16日 上午11:24:40
	 * @tags
	 */
	public void searchGgku(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		   Map<String, Object[]> map=getSearchSql(Customer.class, req);
		   String sql="";
		   Object[] params=null;
		   Pages<Customer> pages=new PageUtil();
		   for(Entry<String, Object[]> entry:map.entrySet()){
			    sql=entry.getKey();
			    params=entry.getValue();
		   }
		   sql=sql+" and delflag=0";
		  //列出客户类型的下拉框
			List<DicAll> dicAlls=new ArrayList<DicAll>();
			dicAlls=dicAllService.getDicAll("khlx");
			ResultUtil result=new ResultUtil();
			result.setO(dicAlls);
			req.setAttribute("result", result);
		   //列出业务员
			String sql2="select * from userrole where roleId=?";
			Object[] params2={3};
			Pages<UserRole> userRolePages=ggkhcService.listUserRoleBysql(sql2, params2);
			req.setAttribute("userRolePages", userRolePages);
		   //搜索框没有值，即按分页查询
		   if(params==null){
			 pages=ggkhcService.listGgkhc(1, 8);
		   }
		   else{
			  pages=ggkhcService.search(sql, 1, 8, params);
		   }
		   
		   req.setAttribute("page", pages);
		   returnView("ggkhc", req, resp);
		   System.out.println(pages.getItems());
	}
	
	public  void turnToPage(HttpServletRequest request,HttpServletResponse response){
		
	
	}
	
	/**
	 * 读出下拉框的数据字典及用户列表
	 * @author gui
	 * @time 2016年7月17日 下午12:33:46
	 * @tags @param req
	 * @tags @param resp
	 * @tags @throws ServletException
	 * @tags @throws IOException
	 */
	public void listSelect(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		ResultUtil result=new ResultUtil();
		
		//列出客户类型的下拉框
		List<DicAll> dicAlls=new ArrayList<DicAll>();
		dicAlls=dicAllService.getDicAll("khlx");
		result.setO(dicAlls);
		req.setAttribute("result", result);
		
		//列出用户的下拉框
		Pages<UserRole> userPages=new PageUtil();
		userPages=ggkhcService.listUserRole();
		List<UserRole> list=userPages.getItems();
		req.setAttribute("userRoleList", list);
		
		for(UserRole userRole:list){
			System.out.println(userRole.getRole().getName()+userRole.getUser().getNickName());
		}
		System.out.println(userPages.getItems());
		
		
		returnView("ggkhc_add", req, resp);
	}
	
	 public void detail(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		  int id=Integer.parseInt(req.getParameter("id"));
		  customer=ggkhcService.detail(id);
		  List<CustomerLink> link_list=ggkhcService.detailLink(customer);
		  req.setAttribute("customer", customer);
		  req.setAttribute("list", link_list);
		  returnView("ggkhc_detail", req, resp);
	 }
	    
	 /**
	  * 公共客户池的编辑，也要查询下拉框和保存用户。同上方法。
	  * @author gui
	  * @time 2016年7月18日 上午5:55:02
	  * @tags @param req
	  * @tags @param resp
	  * @tags @throws ServletException
	  * @tags @throws IOException
	  */
	 public void edit(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		    //列出客户类型的下拉框
		    List<DicAll> dicAlls=null;
		    ResultUtil result=new ResultUtil();
			dicAlls=dicAllService.getDicAll("khlx");
			result.setO(dicAlls);
			req.setAttribute("result", result);
			//列出用户的下拉框
			Pages<UserRole> userPages=new PageUtil();
			userPages=ggkhcService.listUserRole();
			List<UserRole> list=userPages.getItems();
			req.setAttribute("userRoleList", list);
		   //根据ID查出客户和该客户对应的联系人
		  int id=Integer.parseInt(req.getParameter("id"));
		  customer=ggkhcService.detail(id);
		  List<CustomerLink> link_list=ggkhcService.detailLink(customer);
		  req.setAttribute("customer", customer);
		  req.setAttribute("list", link_list);
		  
		  returnView("ggkhc_edit", req, resp);
	 }
	 
	 public void update(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		 
		 //ID
		  int id=Integer.parseInt(req.getParameter("customerid"));
		  customer.setId(id);
		 //客户编码
		    customer.setCode(CodeUtil.getKhCode());
			String customer_name=req.getParameter("customer_name");
			String customer_code=req.getParameter("customer_code");
			String user_creatorid=req.getParameter("user_creatorid");
			String customer_phone=req.getParameter("customer_phone");
			String customer_email=req.getParameter("customer_email");
			String customer_adress=req.getParameter("customer_adress");
			String customer_qq=req.getParameter("customer_qq");
			String customer_province=req.getParameter("customer_province");
			String customer_city=req.getParameter("customer_city");
			String customer_county=req.getParameter("customer_county");
			String salesid=req.getParameter("salesid");
			String dicAll_typeid=req.getParameter("dicAll_typeid");
			String customer_createdate=req.getParameter("customer_createdate");
		    if(dicAll_typeid!=null&&dicAll_typeid!=""){
		    	int typeId=Integer.parseInt(dicAll_typeid);
		    	DicAll dicAll=new DicAll();
		    	dicAll.setId(typeId);
		    	customer.setType(dicAll);
		    }
			if(user_creatorid!=null&&user_creatorid!=""){
		    	int creatorId=Integer.parseInt(user_creatorid);
		    	User user=new User();
		    	user.setId(creatorId);
		    	customer.setCreator(user);
		    }
		    if(salesid!=null&&salesid!=""){
		    	int salesId=Integer.parseInt(salesid);
		    	User user=new User();
		    	user.setId(salesId);
		    	customer.setSales(user);;
		    }
		    customer.setName(customer_name);
		    customer.setAdress(customer_adress);
		    customer.setCity(customer_city);
		    customer.setCounty(customer_county);
		    customer.setCreatedate(customer_createdate);
		    customer.setEmail(customer_email);
		    customer.setName(customer_name);
		    customer.setPhone(customer_phone);
		    customer.setProvince(customer_province);
		    customer.setQq(customer_qq);
			
			 System.out.println("ID:"+req.getParameterValues("listCustomerLink_id")[0]);
		    boolean flag1=ggkhcService.updateGgkhc(customer);
		    boolean flag2=false;
		    String[] listCustomerLink_name=req.getParameterValues("listCustomerLink_name");
		    if(listCustomerLink_name!=null&&listCustomerLink_name.length>0){
		    	if(!listCustomerLink_name[0].equals("")){
		    	int count=listCustomerLink_name.length;
		    	for(int i=0;i<count;i++){
		    		CustomerLink customerLink=new CustomerLink();
		    		int linkId=Integer.parseInt(req.getParameterValues("listCustomerLink_id")[i]);
		    		System.out.println("id="+linkId);
		    	    String CustomerLink_name=listCustomerLink_name[i];
		    		String listCustomerLink_sexid=req.getParameterValues("listCustomerLink_sexid")[i];
		    		String listCustomerLink_position=req.getParameterValues("listCustomerLink_position")[i];
		    		String listCustomerLink_phone=req.getParameterValues("listCustomerLink_phone")[i];
		    		String listCustomerLink_phone2=req.getParameterValues("listCustomerLink_phone2")[i];
		    		String listCustomerLink_email=req.getParameterValues("listCustomerLink_email")[i];
		    		String listCustomerLink_birthdate=req.getParameterValues("listCustomerLink_birthdate")[i];
		    		String listCustomerLink_content=req.getParameterValues("listCustomerLink_content")[i];
		    	  if(listCustomerLink_sexid!=""&&listCustomerLink_sexid!=""){
		    		  int sexId=Integer.parseInt(listCustomerLink_sexid);
		    		  customerLink.setSex(sexId==1?true:false);
		    	  }
		    	  customerLink.setId(linkId);
		    	  customerLink.setBirthdate(listCustomerLink_birthdate);
		    	  customerLink.setContent(listCustomerLink_content);
		    	  customerLink.setCustomer(customer);
		    	  customerLink.setEmail(listCustomerLink_email);
		    	  customerLink.setName(CustomerLink_name);
		    	  customerLink.setPhone(listCustomerLink_phone);
		    	  customerLink.setPhone2(listCustomerLink_phone2);
		    	  customerLink.setPosition(listCustomerLink_position);
		    	  System.out.println(customerLink);
		    	   flag2=ggkhcService.updateLink(customerLink);
		    	}
		    	}
		    }
		    
		    ResultUtil result=new ResultUtil();
		    if(flag1==true&&flag2==true){
		    	result.setInfo("更新成功");
		    	System.out.println("更新成功");
		    }else{
		    	result.setInfo("保存成功！");
		    }
		    
		    req.setAttribute("result", result);
		    req.getRequestDispatcher("ggkhc.do?method=listGgkh").forward(req, resp);
	 }
	 
	 public void fpkh(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		  int userId=Integer.parseInt(req.getParameter("userId"));
		  int customerId=Integer.parseInt(req.getParameter("customerId"));
		  customer=ggkhcService.fpkh(userId, customerId);
		  ggkhcService.updateGgkhc(customer);
	 }
	 
	 public void delete(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		 int customerId=Integer.parseInt(req.getParameter("customerId"));
		 boolean flag=ggkhcService.delete(customerId);
		 if(flag==true){
			req.getRequestDispatcher("ggkhc.do?method=listGgkh").forward(req, resp);
		 }
	 }
}
