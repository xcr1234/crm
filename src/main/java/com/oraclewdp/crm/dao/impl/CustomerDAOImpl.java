package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.oraclewdp.crm.dao.*;


import com.oraclewdp.crm.entity.*;

public class CustomerDAOImpl implements ICustomerDAO {
    private Connection conn;

    public CustomerDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean create(Customer customer) {
        String sql = "INSERT INTO CUSTOMER(code,customer_type,sex,name,phone,email,adress,qq,createdate,creator,sales,provence,city,county) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, customer.getCode());
            pstmt.setInt(2, customer.getCustomerType());
            pstmt.setBoolean(3, customer.getSex());
            pstmt.setString(4, customer.getName());
            pstmt.setString(5, customer.getPhone());
            pstmt.setString(6, customer.getEmail());
            pstmt.setString(7, customer.getAdress());
            pstmt.setString(8, customer.getQq());
            pstmt.setString(9, customer.getCreatedate());
            pstmt.setString(10, customer.getCreator());
            pstmt.setString(11, customer.getSales());
            pstmt.setString(12, customer.getProvence());
            pstmt.setString(13, customer.getCity());
            pstmt.setString(14, customer.getCounty());
            if (pstmt.executeUpdate() == 1) {
                pstmt.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int deleteByID(Integer id) {
        String sql = "DELETE FROM CUSTOMER WHERE id= ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateByID(Customer customer) {
        String sql = "UPDATE CUSTOMER SET code=?,customer_type=?,sex=?,name=?,phone=?,email=?,adress=?,qq=?,createdate=?,creator=?,sales=?,provence=?,city=?,county=? WHERE id = ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, customer.getCode());
            pstmt.setInt(2, customer.getCustomerType());
            pstmt.setBoolean(3, customer.getSex());
            pstmt.setString(4, customer.getName());
            pstmt.setString(5, customer.getPhone());
            pstmt.setString(6, customer.getEmail());
            pstmt.setString(7, customer.getAdress());
            pstmt.setString(8, customer.getQq());
            pstmt.setString(9, customer.getCreatedate());
            pstmt.setString(10, customer.getCreator());
            pstmt.setString(11, customer.getSales());
            pstmt.setString(12, customer.getProvence());
            pstmt.setString(13, customer.getCity());
            pstmt.setString(14, customer.getCounty());
            pstmt.setInt(15, customer.getId());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Customer findByID(Integer id) {
        String sql = " SELECT * FROM CUSTOMER WHERE id = ? ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Customer customer = null;
            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setCode(rs.getString("code"));
                customer.setCustomerType(rs.getInt("customer_type"));
                customer.setSex(rs.getBoolean("sex"));
                customer.setName(rs.getString("name"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setAdress(rs.getString("adress"));
                customer.setQq(rs.getString("qq"));
                customer.setCreatedate(rs.getString("createdate"));
                customer.setCreator(rs.getString("creator"));
                customer.setSales(rs.getString("sales"));
                customer.setProvence(rs.getString("provence"));
                customer.setCity(rs.getString("city"));
                customer.setCounty(rs.getString("county"));
            }
            pstmt.close();
            rs.close();
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Customer> findAll() {
        List<Customer> all = new ArrayList<Customer>();
        String sql = " SELECT * FROM CUSTOMER";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setCode(rs.getString("code"));
                customer.setCustomerType(rs.getInt("customer_type"));
                customer.setSex(rs.getBoolean("sex"));
                customer.setName(rs.getString("name"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setAdress(rs.getString("adress"));
                customer.setQq(rs.getString("qq"));
                customer.setCreatedate(rs.getString("createdate"));
                customer.setCreator(rs.getString("creator"));
                customer.setSales(rs.getString("sales"));
                customer.setProvence(rs.getString("provence"));
                customer.setCity(rs.getString("city"));
                customer.setCounty(rs.getString("county"));
                all.add(customer);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<Customer> findAll(String column, String kw) {
        List<Customer> all = new ArrayList<Customer>();
        String sql = " SELECT * FROM CUSTOMER WHERE " + column + " LIKE ?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setCode(rs.getString("code"));
                customer.setCustomerType(rs.getInt("customer_type"));
                customer.setSex(rs.getBoolean("sex"));
                customer.setName(rs.getString("name"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setAdress(rs.getString("adress"));
                customer.setQq(rs.getString("qq"));
                customer.setCreatedate(rs.getString("createdate"));
                customer.setCreator(rs.getString("creator"));
                customer.setSales(rs.getString("sales"));
                customer.setProvence(rs.getString("provence"));
                customer.setCity(rs.getString("city"));
                customer.setCounty(rs.getString("county"));
                all.add(customer);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<Customer> findAll(int cp, int ls, String column, String kw) {
        List<Customer> all = new ArrayList<Customer>();
        String sql = " SELECT * FROM CUSTOMER WHERE " + column + " LIKE ? limit ?,?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            pstmt.setInt(2, (cp - 1) * ls);
            pstmt.setInt(3, ls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setCode(rs.getString("code"));
                customer.setCustomerType(rs.getInt("customer_type"));
                customer.setSex(rs.getBoolean("sex"));
                customer.setName(rs.getString("name"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setAdress(rs.getString("adress"));
                customer.setQq(rs.getString("qq"));
                customer.setCreatedate(rs.getString("createdate"));
                customer.setCreator(rs.getString("creator"));
                customer.setSales(rs.getString("sales"));
                customer.setProvence(rs.getString("provence"));
                customer.setCity(rs.getString("city"));
                customer.setCounty(rs.getString("county"));
                all.add(customer);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public int findCount() {
        String sql = " SELECT count(*) FROM CUSTOMER";
        int count = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int findCount(String column, String kw) {
        String sql = " SELECT count(*) FROM CUSTOMER WHERE " + column + " LIKE ? ";
        int count = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
