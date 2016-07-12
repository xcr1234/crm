package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.oraclewdp.crm.dao.*;


import com.oraclewdp.crm.entity.*;

public class ContactDAOImpl implements IContactDAO {
    private Connection conn;

    public ContactDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean create(Contact contact) {
        String sql = "INSERT INTO CONTACT(contactor,creator,createdate,customer_id,phone,content,remark,attach_id) values (?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, contact.getContactor());
            pstmt.setString(2, contact.getCreator());
            pstmt.setString(3, contact.getCreatedate());
            pstmt.setInt(4, contact.getCustomerId());
            pstmt.setString(5, contact.getPhone());
            pstmt.setString(6, contact.getContent());
            pstmt.setString(7, contact.getRemark());
            pstmt.setInt(8, contact.getAttachId());
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
        String sql = "DELETE FROM CONTACT WHERE id= ? ";
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

    public int updateByID(Contact contact) {
        String sql = "UPDATE CONTACT SET contactor=?,creator=?,createdate=?,customer_id=?,phone=?,content=?,remark=?,attach_id=? WHERE id = ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, contact.getContactor());
            pstmt.setString(2, contact.getCreator());
            pstmt.setString(3, contact.getCreatedate());
            pstmt.setInt(4, contact.getCustomerId());
            pstmt.setString(5, contact.getPhone());
            pstmt.setString(6, contact.getContent());
            pstmt.setString(7, contact.getRemark());
            pstmt.setInt(8, contact.getAttachId());
            pstmt.setInt(9, contact.getId());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Contact findByID(Integer id) {
        String sql = " SELECT * FROM CONTACT WHERE id = ? ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Contact contact = null;
            while (rs.next()) {
                contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setContactor(rs.getInt("contactor"));
                contact.setCreator(rs.getString("creator"));
                contact.setCreatedate(rs.getString("createdate"));
                contact.setCustomerId(rs.getInt("customer_id"));
                contact.setPhone(rs.getString("phone"));
                contact.setContent(rs.getString("content"));
                contact.setRemark(rs.getString("remark"));
                contact.setAttachId(rs.getInt("attach_id"));
            }
            pstmt.close();
            rs.close();
            return contact;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Contact> findAll() {
        List<Contact> all = new ArrayList<Contact>();
        String sql = " SELECT * FROM CONTACT";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setContactor(rs.getInt("contactor"));
                contact.setCreator(rs.getString("creator"));
                contact.setCreatedate(rs.getString("createdate"));
                contact.setCustomerId(rs.getInt("customer_id"));
                contact.setPhone(rs.getString("phone"));
                contact.setContent(rs.getString("content"));
                contact.setRemark(rs.getString("remark"));
                contact.setAttachId(rs.getInt("attach_id"));
                all.add(contact);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<Contact> findAll(String column, String kw) {
        List<Contact> all = new ArrayList<Contact>();
        String sql = " SELECT * FROM CONTACT WHERE " + column + " LIKE ?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setContactor(rs.getInt("contactor"));
                contact.setCreator(rs.getString("creator"));
                contact.setCreatedate(rs.getString("createdate"));
                contact.setCustomerId(rs.getInt("customer_id"));
                contact.setPhone(rs.getString("phone"));
                contact.setContent(rs.getString("content"));
                contact.setRemark(rs.getString("remark"));
                contact.setAttachId(rs.getInt("attach_id"));
                all.add(contact);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<Contact> findAll(int cp, int ls, String column, String kw) {
        List<Contact> all = new ArrayList<Contact>();
        String sql = " SELECT * FROM CONTACT WHERE " + column + " LIKE ? limit ?,?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            pstmt.setInt(2, (cp - 1) * ls);
            pstmt.setInt(3, ls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setContactor(rs.getInt("contactor"));
                contact.setCreator(rs.getString("creator"));
                contact.setCreatedate(rs.getString("createdate"));
                contact.setCustomerId(rs.getInt("customer_id"));
                contact.setPhone(rs.getString("phone"));
                contact.setContent(rs.getString("content"));
                contact.setRemark(rs.getString("remark"));
                contact.setAttachId(rs.getInt("attach_id"));
                all.add(contact);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public int findCount() {
        String sql = " SELECT count(*) FROM CONTACT";
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
        String sql = " SELECT count(*) FROM CONTACT WHERE " + column + " LIKE ? ";
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
