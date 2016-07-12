package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.oraclewdp.crm.dao.*;


import com.oraclewdp.crm.entity.*;

public class UserroleDAOImpl implements IUserroleDAO {
    private Connection conn;

    public UserroleDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean create(UserRole userrole) {
        String sql = "INSERT INTO USERROLE(userId,roleId) values (?,?) ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, userrole.getUserid());
            pstmt.setInt(2, userrole.getRoleid());
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
        String sql = "DELETE FROM USERROLE WHERE id= ? ";
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

    public int updateByID(UserRole userrole) {
        String sql = "UPDATE USERROLE SET userId=?,roleId=? WHERE id = ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, userrole.getUserid());
            pstmt.setInt(2, userrole.getRoleid());
            pstmt.setInt(3, userrole.getId());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public UserRole findByID(Integer id) {
        String sql = " SELECT * FROM USERROLE WHERE id = ? ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            UserRole userrole = null;
            while (rs.next()) {
                userrole = new UserRole();
                userrole.setId(rs.getInt("id"));
                userrole.setUserid(rs.getInt("userId"));
                userrole.setRoleid(rs.getInt("roleId"));
            }
            pstmt.close();
            rs.close();
            return userrole;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UserRole> findAll() {
        List<UserRole> all = new ArrayList<UserRole>();
        String sql = " SELECT * FROM USERROLE";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UserRole userrole = new UserRole();
                userrole.setId(rs.getInt("id"));
                userrole.setUserid(rs.getInt("userId"));
                userrole.setRoleid(rs.getInt("roleId"));
                all.add(userrole);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<UserRole> findAll(String column, String kw) {
        List<UserRole> all = new ArrayList<UserRole>();
        String sql = " SELECT * FROM USERROLE WHERE " + column + " LIKE ?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UserRole userrole = new UserRole();
                userrole.setId(rs.getInt("id"));
                userrole.setUserid(rs.getInt("userId"));
                userrole.setRoleid(rs.getInt("roleId"));
                all.add(userrole);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<UserRole> findAll(int cp, int ls, String column, String kw) {
        List<UserRole> all = new ArrayList<UserRole>();
        String sql = " SELECT * FROM USERROLE WHERE " + column + " LIKE ? limit ?,?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            pstmt.setInt(2, (cp - 1) * ls);
            pstmt.setInt(3, ls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UserRole userrole = new UserRole();
                userrole.setId(rs.getInt("id"));
                userrole.setUserid(rs.getInt("userId"));
                userrole.setRoleid(rs.getInt("roleId"));
                all.add(userrole);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public int findCount() {
        String sql = " SELECT count(*) FROM USERROLE";
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
        String sql = " SELECT count(*) FROM USERROLE WHERE " + column + " LIKE ? ";
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
