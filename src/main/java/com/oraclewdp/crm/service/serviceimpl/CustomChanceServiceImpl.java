package com.oraclewdp.crm.service.serviceimpl;


import com.oraclewdp.crm.dao.impl.DaoImpl;
import com.oraclewdp.crm.entity.CustomChance;
import com.oraclewdp.crm.service.CustomChanceService;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.Pages;

import java.sql.Connection;

public class CustomChanceServiceImpl implements CustomChanceService{


    private DaoImpl<CustomChance> customChanceDao;

    public CustomChanceServiceImpl(){
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        Connection  connection = jdbcUtil.getConnection();
        customChanceDao = new DaoImpl<>(connection);
    }

    @Override
    public Pages<CustomChance> list() {

        return customChanceDao.findAll(CustomChance.class);
    }

    @Override
    public Pages<CustomChance> query(String sql, Object... params) {
        return customChanceDao.findAll(CustomChance.class,sql,params);
    }
}
