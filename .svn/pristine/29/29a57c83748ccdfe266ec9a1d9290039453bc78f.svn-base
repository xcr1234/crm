package com.oraclewdp.crm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 提供jdbc数据的连接类， 自动读取配置
 * @author xcr
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
    private JdbcUtil(){
    	
    }


    private static JdbcUtil jdbcUtil = null;
    private static DataSource dataSource;
    private Connection connection=null;
    
    static{
    	InitialContext context;
		try {
			context = new InitialContext();
			dataSource=(DataSource) context.lookup("java:comp/env/jdbc/c3p0"); 
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
    }
    
    
/**
 * 获得一个JdbcUtil实例对象
 * @author xcr
 * @time 2016年7月12日 下午1:01:28
 * @tags @return JdbcUtil
 */
    public  synchronized  static JdbcUtil getInstance(){
       /* return getInstance("db.properties");*/
    	if (jdbcUtil==null){
    		jdbcUtil=new JdbcUtil();
    	}
    	return jdbcUtil;
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

    /**
     * 获得一个connection对象
     * @author gui
     * @time 2016年7月12日 下午1:03:47
     * @tags @return Connection
     * @tags @throws SQLException
     */
    public Connection getConnection(){

       /* Connection connection = threadLocal.get();*/
        if(connection==null){
            /*try {
				connection = DriverManager.getConnection(url,user,pwd);
				threadLocal.set(connection);
            } catch (SQLException e) {
			
				e.printStackTrace();
			}*/
            
            try {
				connection=dataSource.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return connection;

       

    }

    /**
     * 关闭connection对象
     * @author xcr
     * @time 2016年7月12日 下午1:05:21
     * @tags @throws SQLException
     */
    public void closeConnection() throws SQLException{
        Connection connection = threadLocal.get();
        if(connection!=null){
            connection.close();
            threadLocal.remove();
        }
    }

}
