package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.oraclewdp.crm.dao.*;


import com.oraclewdp.crm.entity.*;

public class CustomerLinkDAOImpl implements ICustomerLinkDAO {
    private Connection conn;

    public CustomerLinkDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean create(CustomerLink customerLink) {
        String sql = "INSERT INTO CUSTOMER_LINK(sex,name,position,phone,phone2,content,customer_id) values (?,?,?,?,?,?,?) ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setBoolean(1, customerLink.getSex());
            pstmt.setString(2, customerLink.getName());
            pstmt.setString(3, customerLink.getPosition());
            pstmt.setString(4, customerLink.getPhone());
            pstmt.setString(5, customerLink.getPhone2());
            pstmt.setString(6, customerLink.getContent());
            pstmt.setInt(7, customerLink.getCustomerId());
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
        String sql = "DELETE FROM CUSTOMER_LINK WHERE id= ? ";
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

    public int updateByID(CustomerLink customerLink) {
        String sql = "UPDATE CUSTOMER_LINK SET sex=?,name=?,position=?,phone=?,phone2=?,content=?,customer_id=? WHERE id = ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setBoolean(1, customerLink.getSex());
            pstmt.setString(2, customerLink.getName());
            pstmt.setString(3, customerLink.getPosition());
            pstmt.setString(4, customerLink.getPhone());
            pstmt.setString(5, customerLink.getPhone2());
            pstmt.setString(6, customerLink.getContent());
            pstmt.setInt(7, customerLink.getCustomerId());
            pstmt.setInt(8, customerLink.getId());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CustomerLink findByID(Integer id) {
        String sql = " SELECT * FROM CUSTOMER_LINK WHERE id = ? ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            CustomerLink customerLink = null;
            while (rs.next()) {
                customerLink = new CustomerLink();
                customerLink.setId(rs.getInt("id"));
                customerLink.setSex(rs.getBoolean("sex"));
                customerLink.setName(rs.getString("name"));
                customerLink.setPosition(rs.getString("position"));
                customerLink.setPhone(rs.getString("phone"));
                customerLink.setPhone2(rs.getString("phone2"));
                customerLink.setContent(rs.getString("content"));
                customerLink.setCustomerId(rs.getInt("customer_id"));
            }
            pstmt.close();
            rs.close();
            return customerLink;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CustomerLink> findAll() {
        List<CustomerLink> all = new ArrayList<CustomerLink>();
        String sql = " SELECT * FROM CUSTOMER_LINK";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomerLink customerLink = new CustomerLink();
                customerLink.setId(rs.getInt("id"));
                customerLink.setSex(rs.getBoolean("sex"));
                customerLink.setName(rs.getString("name"));
                customerLink.setPosition(rs.getString("position"));
                customerLink.setPhone(rs.getString("phone"));
                customerLink.setPhone2(rs.getString("phone2"));
                customerLink.setContent(rs.getString("content"));
                customerLink.setCustomerId(rs.getInt("customer_id"));
                all.add(customerLink);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<CustomerLink> findAll(String column, String kw) {
        List<CustomerLink> all = new ArrayList<CustomerLink>();
        String sql = " SELECT * FROM CUSTOMER_LINK WHERE " + column + " LIKE ?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomerLink customerLink = new CustomerLink();
                customerLink.setId(rs.getInt("id"));
                customerLink.setSex(rs.getBoolean("sex"));
                customerLink.setName(rs.getString("name"));
                customerLink.setPosition(rs.getString("position"));
                customerLink.setPhone(rs.getString("phone"));
                customerLink.setPhone2(rs.getString("phone2"));
                customerLink.setContent(rs.getString("content"));
                customerLink.setCustomerId(rs.getInt("customer_id"));
                all.add(customerLink);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<CustomerLink> findAll(int cp, int ls, String column, String kw) {
        List<CustomerLink> all = new ArrayList<CustomerLink>();
        String sql = " SELECT * FROM CUSTOMER_LINK WHERE " + column + " LIKE ? limit ?,?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            pstmt.setInt(2, (cp - 1) * ls);
            pstmt.setInt(3, ls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomerLink customerLink = new CustomerLink();
                customerLink.setId(rs.getInt("id"));
                customerLink.setSex(rs.getBoolean("sex"));
                customerLink.setName(rs.getString("name"));
                customerLink.setPosition(rs.getString("position"));
                customerLink.setPhone(rs.getString("phone"));
                customerLink.setPhone2(rs.getString("phone2"));
                customerLink.setContent(rs.getString("content"));
                customerLink.setCustomerId(rs.getInt("customer_id"));
                all.add(customerLink);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public int findCount() {
        String sql = " SELECT count(*) FROM CUSTOMER_LINK";
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
        String sql = " SELECT count(*) FROM CUSTOMER_LINK WHERE " + column + " LIKE ? ";
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
