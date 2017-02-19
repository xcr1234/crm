package com.oraclewdp.crm.util;

import com.oraclewdp.crm.dao.impl.DaoImpl;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;


public class DaoImplListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        try {
            jdbcUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        Connection connection = jdbcUtil.getConnection();
        DaoImpl dao = new DaoImpl(connection);

        event.getServletRequest().setAttribute("dao",dao);



    }
}
