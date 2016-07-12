package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.oraclewdp.crm.dao.*;


import com.oraclewdp.crm.entity.*;

public class CustomerCareDAOImpl implements ICustomerCareDAO {
    private Connection conn;

    public CustomerCareDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean create(CustomerCare customerCare) {
        String sql = "INSERT INTO CUSTOMER_CARE(id,customer_id,date,phone,phone2,creator,creatdate,content,remark) values (?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, customerCare.getId());
            pstmt.setInt(2, customerCare.getCustomerId());
            pstmt.setTimestamp(3, customerCare.getDate());
            pstmt.setString(4, customerCare.getPhone());
            pstmt.setString(5, customerCare.getPhone2());
            pstmt.setInt(6, customerCare.getCreator());
            pstmt.setString(7, customerCare.getCreatdate());
            pstmt.setString(8, customerCare.getContent());
            pstmt.setString(9, customerCare.getRemark());
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
        String sql = "DELETE FROM CUSTOMER_CARE WHERE id= ? ";
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

    public int updateByID(CustomerCare customerCare) {
        String sql = "UPDATE CUSTOMER_CARE SET customer_id=?,date=?,phone=?,phone2=?,creator=?,creatdate=?,content=?,remark=? WHERE id = ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, customerCare.getCustomerId());
            pstmt.setTimestamp(2, customerCare.getDate());
            pstmt.setString(3, customerCare.getPhone());
            pstmt.setString(4, customerCare.getPhone2());
            pstmt.setInt(5, customerCare.getCreator());
            pstmt.setString(6, customerCare.getCreatdate());
            pstmt.setString(7, customerCare.getContent());
            pstmt.setString(8, customerCare.getRemark());
            pstmt.setInt(9, customerCare.getId());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CustomerCare findByID(Integer id) {
        String sql = " SELECT * FROM CUSTOMER_CARE WHERE id = ? ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            CustomerCare customerCare = null;
            while (rs.next()) {
                customerCare = new CustomerCare();
                customerCare.setId(rs.getInt("id"));
                customerCare.setCustomerId(rs.getInt("customer_id"));
                customerCare.setDate(rs.getTimestamp("date"));
                customerCare.setPhone(rs.getString("phone"));
                customerCare.setPhone2(rs.getString("phone2"));
                customerCare.setCreator(rs.getInt("creator"));
                customerCare.setCreatdate(rs.getString("creatdate"));
                customerCare.setContent(rs.getString("content"));
                customerCare.setRemark(rs.getString("remark"));
            }
            pstmt.close();
            rs.close();
            return customerCare;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CustomerCare> findAll() {
        List<CustomerCare> all = new ArrayList<CustomerCare>();
        String sql = " SELECT * FROM CUSTOMER_CARE";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomerCare customerCare = new CustomerCare();
                customerCare.setId(rs.getInt("id"));
                customerCare.setCustomerId(rs.getInt("customer_id"));
                customerCare.setDate(rs.getTimestamp("date"));
                customerCare.setPhone(rs.getString("phone"));
                customerCare.setPhone2(rs.getString("phone2"));
                customerCare.setCreator(rs.getInt("creator"));
                customerCare.setCreatdate(rs.getString("creatdate"));
                customerCare.setContent(rs.getString("content"));
                customerCare.setRemark(rs.getString("remark"));
                all.add(customerCare);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<CustomerCare> findAll(String column, String kw) {
        List<CustomerCare> all = new ArrayList<CustomerCare>();
        String sql = " SELECT * FROM CUSTOMER_CARE WHERE " + column + " LIKE ?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomerCare customerCare = new CustomerCare();
                customerCare.setId(rs.getInt("id"));
                customerCare.setCustomerId(rs.getInt("customer_id"));
                customerCare.setDate(rs.getTimestamp("date"));
                customerCare.setPhone(rs.getString("phone"));
                customerCare.setPhone2(rs.getString("phone2"));
                customerCare.setCreator(rs.getInt("creator"));
                customerCare.setCreatdate(rs.getString("creatdate"));
                customerCare.setContent(rs.getString("content"));
                customerCare.setRemark(rs.getString("remark"));
                all.add(customerCare);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<CustomerCare> findAll(int cp, int ls, String column, String kw) {
        List<CustomerCare> all = new ArrayList<CustomerCare>();
        String sql = " SELECT * FROM CUSTOMER_CARE WHERE " + column + " LIKE ? limit ?,?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            pstmt.setInt(2, (cp - 1) * ls);
            pstmt.setInt(3, ls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomerCare customerCare = new CustomerCare();
                customerCare.setId(rs.getInt("id"));
                customerCare.setCustomerId(rs.getInt("customer_id"));
                customerCare.setDate(rs.getTimestamp("date"));
                customerCare.setPhone(rs.getString("phone"));
                customerCare.setPhone2(rs.getString("phone2"));
                customerCare.setCreator(rs.getInt("creator"));
                customerCare.setCreatdate(rs.getString("creatdate"));
                customerCare.setContent(rs.getString("content"));
                customerCare.setRemark(rs.getString("remark"));
                all.add(customerCare);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public int findCount() {
        String sql = " SELECT count(*) FROM CUSTOMER_CARE";
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
        String sql = " SELECT count(*) FROM CUSTOMER_CARE WHERE " + column + " LIKE ? ";
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
