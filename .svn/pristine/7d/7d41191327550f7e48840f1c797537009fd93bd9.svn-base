package com.oraclewdp.crm.action;

import com.oraclewdp.crm.dao.impl.DaoImpl;
import com.oraclewdp.crm.entity.*;
import com.oraclewdp.crm.util.ActionSupport;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.JhCodeUtil;
import com.oraclewdp.crm.util.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 项目机会
 */
@WebServlet("/xmjh.do")
public class XmjhAction extends ActionSupport{


    private DaoImpl<CustomChance> customChanceDao;

    private DaoImpl<DicAll> dicAllDao;

    private DaoImpl<Customer> customerDao;

    private DaoImpl<User> userDao;


    private DaoImpl<Attach> attachDao;


    @Override
    public void init(){
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        Connection connection = jdbcUtil.getConnection();
        customChanceDao = new DaoImpl<>(connection);
        dicAllDao = new DaoImpl<>(connection);
        customerDao = new DaoImpl<>(connection);
        userDao = new DaoImpl<>(connection);
        attachDao = new DaoImpl<>(connection);

    }





    public void listXmjh(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String page = request.getParameter("page");
        Integer p;
        if(page==null||page.isEmpty()){
            p = 1;
        }else{
            p = Integer.valueOf(page);
        }

        List<DicAll> dicAllList = dicAllDao.listAll(DicAll.class,"select * from dic_all where type like ?","%jhlx%");
        Pages<CustomChance> pages = customChanceDao.findAll(CustomChance.class);
        pages.toPage(p);

        List<DicAll> possi = dicAllDao.listAll(DicAll.class,"select * from dic_all where type like ?","%cjknx%");


        request.setAttribute("pages",pages);
        request.setAttribute("possi",possi);
        request.setAttribute("dicAllList",dicAllList);
        returnView("xmjh",request,response);

    }


    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{

        //把机会类型，机会阶段，机会可能性取出来
        List<DicAll> jhlxList = dicAllDao.listAll(DicAll.class,"select * from dic_all where type like ?","%jhjd%");
        List<DicAll> jhjdList = dicAllDao.listAll(DicAll.class,"select * from dic_all where type like ?","%jhjd%");
        List<DicAll> cjknxList = dicAllDao.listAll(DicAll.class,"select * from dic_all where type like ?","%cjknx%");
        List<User> userList = userDao.listAll(User.class);
        List<Attach> attachList = attachDao.listAll(Attach.class);

        List<Customer> customerList = customerDao.listAll(Customer.class);

        request.setAttribute("jhlx",jhlxList);
        request.setAttribute("jhjd",jhjdList);
        request.setAttribute("cjknx",cjknxList);
        request.setAttribute("customer",customerList);
        request.setAttribute("userList",userList);
        request.setAttribute("attach",attachList);

        returnView("xmjh_add",request,response);

    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{

        Integer id = Integer.valueOf(request.getParameter("id"));
        CustomChance customChance = customChanceDao.find(id,CustomChance.class);
        request.setAttribute("customChance",customChance);
        returnView("xmjh_view",request,response);
    }

    public void add_submit(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{

        String name = request.getParameter("name");
        Integer customer = Integer.valueOf(request.getParameter("customer"));
        Integer type = Integer.valueOf(request.getParameter("type"));
        Integer chanceStage = Integer.valueOf(request.getParameter("chanceStage"));
        String possibility = request.getParameter("possibility");
        Integer attach = Integer.valueOf(request.getParameter("attach"));
        Integer creator = Integer.valueOf(request.getParameter("creator"));
        String createdate = request.getParameter("createdate");

        CustomChance customChance = new CustomChance();
        customChance.setName(name);
        customChance.setPossibility(possibility);
        customChance.setCreatedate(createdate);
        customChance.setCode(JhCodeUtil.getJhCode());

        Customer cus = new Customer();
        cus.setId(customer);
        customChance.setCustomer(cus);

        DicAll typeDic = new DicAll();
        typeDic.setId(type);
        customChance.setType(typeDic);

        DicAll stateDic = new DicAll();
        stateDic.setId(chanceStage);
        customChance.setChanceStage(stateDic);

        if(attach>0){
            Attach att = new Attach();
            att.setId(attach);
            customChance.setAttach(att);
        }


        customChanceDao.save(customChance);

         response.sendRedirect("xmjh.do?method=listXmjh");

    }

    @Override
    public void destroy() {
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        try {
            jdbcUtil.closeConnection();
        } catch (SQLException e) {}
    }


}
