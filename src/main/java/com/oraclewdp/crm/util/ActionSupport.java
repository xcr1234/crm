package com.oraclewdp.crm.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

/**
 * servlet的父类，方便调用前台方法。前台调用方法用method=?
 * @author gui
 *
 */
public class ActionSupport extends HttpServlet {
    protected  HttpSession session;
	protected  ServletContext application;
	protected  Cookie[] cookies;
	protected HttpServletRequest request;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		request=req;
		//设置编码
		  req.setCharacterEncoding("utf-8");
		  resp.setCharacterEncoding("utf-8");
	      session=req.getSession(); 
	      application=this.getServletContext();
		  cookies=req.getCookies();
	      String methodParam=req.getParameter("method");
	      try {
		  Method method=this.getClass().
				getDeclaredMethod(methodParam,HttpServletRequest.class,
						HttpServletResponse.class);
	    method.invoke(this,req,resp);
	      } catch (SecurityException e) {
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		e.printStackTrace();
	}
	}

	/**
	 * json的后台调用方法
	 * @author gui
	 * @time 2016年7月12日 上午9:25:15
	 * @tags @param o
	 * @tags @param response
	 */
	protected void renderJSON(Object o,HttpServletResponse response){
		response.setHeader("Content-type", "text/json");
		String jsonStr=JSON.toJSONString(o);
		try {
			PrintWriter pw=response.getWriter();
			pw.write(jsonStr);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过反射实现对前台数据自动读取，注入对象，返回对象map。
	 * @author gui
	 * @time 2016年7月12日 上午22:34:02
	 * @tags @param clz
	 * @tags @param request
	 * @tags @return
	 */
	public Map<String, Object> getObject(HttpServletRequest request){	
			Map<String, Object>map=new HashMap<String, Object>();
			Map<String, String[]>mapStr=null;
			Map<String, String[]>mapParams=new HashMap<String, String[]>();//过滤掉非关键字之后的map
			Set<String> set=new HashSet<String>();
			Object o=null;
			String key=""; //类型名
			String packageName="com.oraclewdp.crm.entity.";  //包名
			String value=""; //表单项的名称Key.value
			String typeName="";
			String columnName="";
			mapStr=request.getParameterMap();
		try {
			//先遍历出有几种类型
			for(Map.Entry<String, String[]> entry:mapStr.entrySet()){
				//过滤掉命名不规范的表单值，只有命名规范的才能注入,method是个特殊值，应该被过滤掉。
				if(entry.getKey().contains("_")){
					mapParams.put(entry.getKey(), entry.getValue());
					typeName=StringUtil.firstToUpper(entry.getKey().split("_")[0]);
					//将所有类名装进set
						set.add(typeName); 
				}
					
			}
			//遍历所有类型，反射生成对象,放进map里。
			for(String s:set){
				Class clzz=Class.forName(packageName+s);
				o=clzz.newInstance();
				map.put(s, o);
			}
			//给map里的对象装入值
			for(Map.Entry<String, String[]> entry:mapParams.entrySet()){
				key=entry.getKey();
				if(entry.getValue().length==1){
					value=entry.getValue()[0];    
				}else{
					for(int i=0;i<entry.getValue().length;i++){
						value+=entry.getValue()[i]+",";
					}
				}
				
					typeName=StringUtil.firstToUpper(key.split("_")[0]);
					columnName=key.split("_")[1];
					o=map.get(typeName);		
					PropertyDescriptor pd=null;
					Method setMethod=null;
					String fieldName="";
					//字段是外键时，即包含"id",本系统字段均为自增长，所以有id肯定是外键关联，在实体中的field是个对象类型而不是基本类型。
					if(columnName.contains("id")){
						int id=Integer.parseInt(value);
						//通过字符串截取获得实体bean中的外键类型的属性名(field)；
						 fieldName="id";
						//获得set方法
						pd=new PropertyDescriptor(fieldName, o.getClass());
						setMethod=pd.getWriteMethod();
						setMethod.invoke(o, id);
					}else{
						//获取属性名
						fieldName=columnName;
						//获得set方法
						pd=new PropertyDescriptor(fieldName, o.getClass());
						setMethod=pd.getWriteMethod();
						setMethod.invoke(o, value);
						
					}

					
				
				
				
				
				
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		return map; 
	}

	/**
	 * 根据前台name获取value
	 * @author gui
	 * @time 2016年7月15日 下午4:22:07
	 * @tags @param name
	 * @tags @param req
	 * @tags @return
	 */
	public String getParameter(String name){
		String value="";
		Map<String, String[]> map=null;
		map=request.getParameterMap();
		value=map.get(name)[0];
		return value;
	}
	/**
	 * 如果是返回到page/crm内的jsp页面可以用这个方法
	 * @author gui
	 * @time 2016年7月14日 下午10:24:58
	 * @tags @param viewName
	 * @tags @param request
	 * @tags @param response
	 */
	public void returnView(String viewName,HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher("page/crm/"+viewName+".jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
