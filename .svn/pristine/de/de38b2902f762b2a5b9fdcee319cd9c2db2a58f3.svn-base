package com.oraclewdp.crm.action;

import com.oraclewdp.crm.dao.impl.DaoImpl;
import com.oraclewdp.crm.entity.CustomChance;
import com.oraclewdp.crm.entity.DicAll;
import com.oraclewdp.crm.util.ActionSupport;
import com.oraclewdp.crm.util.JdbcUtil;
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



    @Override
    public void init(){
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        Connection connection = jdbcUtil.getConnection();
        customChanceDao = new DaoImpl<>(connection);
        dicAllDao = new DaoImpl<>(connection);

    }





    public void listXmjh(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String page = request.getParameter("page");
        Integer p;
        if(page==null||page.isEmpty()){
            p = 1;
        }else{
            p = Integer.valueOf(page);
        }

        List<DicAll> dicAllList = dicAllDao.listAll(DicAll.class);
        Pages<CustomChance> pages = customChanceDao.findAll(CustomChance.class);
        pages.toPage(p);


        request.setAttribute("pages",pages);
        request.setAttribute("dicAllList",dicAllList);
        returnView("xmjh",request,response);

    }

    @Override
    public void destroy() {
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        try {
            jdbcUtil.closeConnection();
        } catch (SQLException e) {}
    }
}
