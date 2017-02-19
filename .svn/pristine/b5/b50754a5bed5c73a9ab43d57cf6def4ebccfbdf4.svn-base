package com.oraclewdp.crm.action;

import com.oraclewdp.crm.entity.CustomChance;
import com.oraclewdp.crm.service.CustomChanceService;
import com.oraclewdp.crm.service.serviceimpl.CustomChanceServiceImpl;
import com.oraclewdp.crm.util.ActionSupport;
import com.oraclewdp.crm.util.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 项目机会
 */
@WebServlet("/xmjh.do")
public class XmjhAction extends ActionSupport{

    private CustomChanceService customChanceService = new CustomChanceServiceImpl();

    public void listXmjh(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{

        Pages<CustomChance> customChanceList = customChanceService.list();





    }




}
