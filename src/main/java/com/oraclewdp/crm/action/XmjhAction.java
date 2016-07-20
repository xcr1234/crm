package com.oraclewdp.crm.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.oraclewdp.crm.dao.BjdDao;
import com.oraclewdp.crm.dao.impl.DaoImpl;
import com.oraclewdp.crm.entity.*;
import com.oraclewdp.crm.util.*;

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

    private DaoImpl<Goods> goodsDao;

    private DaoImpl<Customer> customerDao;

    private DaoImpl<User> userDao;


    private DaoImpl<Attach> attachDao;

    private DaoImpl<Bjd> bjdDao ;

    private DaoImpl<BjdList> bjdListDao;


    @Override
    public void init(){
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        Connection connection = jdbcUtil.getConnection();
        customChanceDao = new DaoImpl<>(connection);
        dicAllDao = new DaoImpl<>(connection);
        customerDao = new DaoImpl<>(connection);
        userDao = new DaoImpl<>(connection);
        attachDao = new DaoImpl<>(connection);
        bjdDao = new DaoImpl<>(connection);
        bjdListDao = new DaoImpl<>(connection);
        goodsDao = new DaoImpl<>(connection);

    }





    public void listXmjh(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String page = request.getParameter("page");
        Integer p;
        if(page==null||page.isEmpty()){
            p = 1;
        }else{
            p = Integer.valueOf(page);
        }


        Pages<CustomChance> pages = customChanceDao.findAll(CustomChance.class);
        pages.toPage(p);




        request.setAttribute("pages",pages);

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

        User user = new User();
        user.setId(creator);
        customChance.setCreator(user);



        if(attach>0){
            Attach att = new Attach();
            att.setId(attach);
            customChance.setAttach(att);
        }


        customChanceDao.save(customChance);

         response.sendRedirect("xmjh.do?method=listXmjh");

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        Integer id = Integer.valueOf(request.getParameter("id"));
        CustomChance customChance = new CustomChance();
        customChance.setId(id);
        customChanceDao.delete(customChance);
        response.sendRedirect("xmjh.do?method=listXmjh");


    }

    //模糊查询
    public void query(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String no = request.getParameter("no");
        String name = request.getParameter("name");

        String page = request.getParameter("page");
        int p = 1;
        if(page!=null&&!page.isEmpty()){
            p = Integer.valueOf(page);
        }

        Pages<CustomChance> pages = customChanceDao.findAll(CustomChance.class,"select * from custom_chance where code like ? and name like ?",'%'+no+'%','%'+name+'%');
        pages.toPage(p);

        request.setAttribute("pages",pages);
        returnView("xmjh",request,response);






    }

    public void chart(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{



        returnView("jh_chart",request,response);

    }

    public void byStage(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        Connection connection = jdbcUtil.getConnection();
        List<BeanObject> list = BeanObject.list("select * from jh_stage",connection);

        String json = JSON.toJSONString(list);
        response.getWriter().print(json);


    }

    public void byPoss(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        Connection connection = jdbcUtil.getConnection();
        List<BeanObject> list = BeanObject.list("select * from jh_poss",connection);

        String json = JSON.toJSONString(list);
        response.getWriter().print(json);



    }





    @Override
    public void destroy() {
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        try {
            jdbcUtil.closeConnection();
        } catch (SQLException e) {}
    }


    public void listXsbjd(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String page = request.getParameter("page");
        int p = 1;
        if(page!=null&&!page.isEmpty()){
            p = Integer.valueOf(page);
        }


        Pages<Bjd> pages = bjdDao.findAll(Bjd.class);
        pages.toPage(p);
        request.setAttribute("pages",pages);




        returnView("xsbjd",request,response);
    }

    public void addXsbjd(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        List<Customer> customerList = customerDao.listAll(Customer.class);
        List<Goods> goodsList = goodsDao.listAll(Goods.class);

        List<User> userList = userDao.listAll(User.class);

        request.setAttribute("customerList",customerList);
        request.setAttribute("goodsList",goodsList);
        request.setAttribute("userList",userList);

        returnView("xsbjd_add",request,response);



    }

    public void addXsbjd_submit(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        //首先处理bjd，把bjd存到数据库中
        Integer bjr = request.getParameter("bjr").isEmpty()?null:Integer.valueOf(request.getParameter("bjr"));
        String yxrq = request.getParameter("yxrq");
        String bjrq = request.getParameter("bjrq");
        String cjr = request.getParameter("cjr");
        String phone = request.getParameter("phone");
        Integer discount = request.getParameter("discount").isEmpty()?null:Integer.valueOf(request.getParameter("discount"));
        Integer cdzk = request.getParameter("cdzk").isEmpty()?null:Integer.valueOf(request.getParameter("cdzk"));
        Integer totle_count = request.getParameter("totle_count").isEmpty()?null:Integer.valueOf(request.getParameter("totle_count"));
        Float totle_rate = request.getParameter("totle_rate").isEmpty()?null:Float.valueOf(request.getParameter("totle_rate"));
        Float totle_pre_price_rate = request.getParameter("totle_pre_price_rate").isEmpty()?null:Float.valueOf(request.getParameter("totle_pre_price_rate"));
        Float totle_price_rate = request.getParameter("totle_price_rate").isEmpty()?null:Float.valueOf(request.getParameter("totle_price_rate"));
        Float totle_price = request.getParameter("totle_price").isEmpty()?null:Float.valueOf(request.getParameter("totle_price"));
        Float totle_discount_price = request.getParameter("totle_discount_price").isEmpty()?null:Float.valueOf(request.getParameter("totle_discount_price"));
        Integer sskh =  request.getParameter("sskh").isEmpty()?null:Integer.valueOf(request.getParameter("sskh"));
        String creator =request.getParameter("creator");
        String createdate = request.getParameter("createdate");


        Bjd bjd = new Bjd();
        bjd.setCode(JhCodeUtil.getJhCode());
        if(sskh!=null){
            Customer customer = new Customer();
            customer.setId(sskh);
            bjd.setSskh(customer);
        }
        if(bjr!=null){
            User user = new User();
            user.setId(bjr);
            bjd.setBjr(user);
        }
        bjd.setYxrq(yxrq);
        bjd.setBjrq(bjrq);
        bjd.setPhone(phone);
        bjd.setCreator(creator);
        bjd.setCreatedate(createdate);
        bjd.setTotleCount(totle_count);
        bjd.setTotleRate(totle_rate);
        bjd.setTotlePrePriceRate(totle_pre_price_rate);
        bjd.setTotlePriceRate(totle_price_rate);
        bjd.setTotlePrice(totle_price);
        bjd.setDiscount(discount);
        bjd.setTotleDiscountPrice(totle_discount_price);

        bjdDao.save(bjd);

        //将bjdlist插入.
        String [] goodsArr = request.getParameterValues("goods");
        String [] countArr =request.getParameterValues("count");
        String [] rateArr = request.getParameterValues("rate");
        String [] per_price_rateArr=  request.getParameterValues("per_price_rate");
        String [] digestArr = request.getParameterValues("digest");
        String price_rateArr [] =request.getParameterValues("price_rate");
        String[] priceArr = request.getParameterValues("price");
        String[] totle_priceArr = request.getParameterValues("totle_price");
        for(int i=0;i<goodsArr.length;i++){
            Integer goods = goodsArr[i].isEmpty()?null:Integer.valueOf(goodsArr[i]);
            Integer count = countArr[i].isEmpty()?null:Integer.valueOf(countArr[i]);
            Integer rate = rateArr[i].isEmpty()?null:Integer.valueOf(rateArr[i]);
            Float perPriceRate = per_price_rateArr[i].isEmpty()?null:Float.valueOf(per_price_rateArr[i]);
            Float priceRate = price_rateArr[i].isEmpty()?null:Float.valueOf(price_rateArr[i]);
            Float price = priceArr[i].isEmpty()?null:Float.valueOf(priceArr[i]);
            Float totlePrice = totle_priceArr[i].isEmpty()?null:Float.valueOf(totle_priceArr[i]);


            BjdList bjdList = new BjdList();
            bjdList.setBjd(bjd);

            Goods g = new Goods();
            g.setId(goods);
            bjdList.setGoods(g);


            bjdList.setCount(count);
            bjdList.setRate(rate);
            bjdList.setPerPriceRate(perPriceRate);
            bjdList.setDigest(digestArr[i]);
            bjdList.setPriceRate(priceRate);
            bjdList.setPrice(price);
            bjdList.setTotlePrice(totlePrice);

            bjdListDao.save(bjdList);



        }



        response.sendRedirect("xmjh.do?method=listXsbjd");




    }

    public void view(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        Integer id = Integer.valueOf(request.getParameter("id"));

        Bjd bjd = bjdDao.find(id,Bjd.class);
        List<BjdList> bjdLists = bjdListDao.listAll(BjdList.class,"select * from bjd_list where bjd_id = ?",id);

        request.setAttribute("bjd",bjd);
        request.setAttribute("bjdList",bjdLists);

        returnView("xsbjd_view",request,response);

    }



}
