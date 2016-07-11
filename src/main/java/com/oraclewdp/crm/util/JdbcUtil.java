package com.oraclewdp.crm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 提供jdbc数据的连接类
 * 自动读取配置
 *
 *
 *
 * 使用方法是
 * JdbcUtil jdbc = JdbcUtil.getInstance()
 * JdbcUtil jdbc = JdbcUtil.getInstance("db.properties");  //db.properties放在resources下。
 *
 * Connection connection = jdbc.getConnection(); //throws SQLException
 *
 * jdbc.closeConnection();
 *
 *
 */
public class JdbcUtil {

    private String driver;
    private String url;
    private String user;
    private String pwd;

    private JdbcUtil(String driver, String url, String user, String pwd) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pwd = pwd;
    }


    private static JdbcUtil jdbcUtil = null;

    public  synchronized  static JdbcUtil getInstance(){
        return getInstance("db.properties");
    }

    public  synchronized  static JdbcUtil getInstance(String f){
        if(jdbcUtil==null){
            URL u = JdbcUtil.class.getClassLoader().getResource(f);
            File file = new File(u.getFile());

            Properties properties = new Properties();
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                properties.load(fileInputStream);
                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String user = properties.getProperty("user");
                String pwd = properties.getProperty("pwd");

               jdbcUtil =  new JdbcUtil(driver,url,user,pwd);
               Class.forName(driver);
            }catch (IOException|ClassNotFoundException e){
                throw new RuntimeException("无法加载配置"+f,e);
            }finally {
                if(fileInputStream!=null){
                    try {
                        fileInputStream.close();
                    }catch (IOException e){}
                }
            }
        }
        return jdbcUtil;
    }

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public Connection getConnection() throws SQLException{

        Connection connection = threadLocal.get();
        if(connection==null){
            connection = DriverManager.getConnection(url,user,pwd);
            threadLocal.set(connection);
        }

        return connection;

    }

    public void closeConnection() throws SQLException{
        Connection connection = threadLocal.get();
        if(connection!=null){
            connection.close();
            threadLocal.remove();
        }
    }





}
