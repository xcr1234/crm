package com.oraclewdp.crm.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

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
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
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
	 * 通过反射实现对前台数据自动读取并存入一个对象
	 * @author gui
	 * @time 2016年7月12日 上午9:24:02
	 * @tags @param clz
	 * @tags @param request
	 * @tags @param response
	 * @tags @return
	 */
	public Object getParams(Class clz,HttpServletRequest request,HttpServletResponse response){
		Object o=null;
		try {
			 o=clz.newInstance();
			Enumeration<String> params=request.getParameterNames();
			while (params.hasMoreElements()) {
				String name = (String) params.nextElement();
				String value=request.getParameter(name);
				PropertyDescriptor pd=new PropertyDescriptor(name, clz);
				//获得set方法
				Method setMethod=pd.getWriteMethod();
				setMethod.invoke(o, value);
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
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
