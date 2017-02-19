package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.oraclewdp.crm.dao.*;


import com.oraclewdp.crm.entity.*;

public class AuthorityDAOImpl implements IAuthorityDAO {
    private Connection conn;

    public AuthorityDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean create(Authority authority) {
        String sql = "INSERT INTO AUTHORITY(menu_id) values (?) ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, authority.getMenuId());
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
        String sql = "DELETE FROM AUTHORITY WHERE id= ? ";
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

    public int updateByID(Authority authority) {
        String sql = "UPDATE AUTHORITY SET menu_id=? WHERE id = ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, authority.getMenuId());
            pstmt.setInt(2, authority.getId());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Authority findByID(Integer id) {
        String sql = " SELECT * FROM AUTHORITY WHERE id = ? ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Authority authority = null;
            while (rs.next()) {
                authority = new Authority();
                authority.setId(rs.getInt("id"));
                authority.setMenuId(rs.getInt("menu_id"));
            }
            pstmt.close();
            rs.close();
            return authority;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Authority> findAll() {
        List<Authority> all = new ArrayList<Authority>();
        String sql = " SELECT * FROM AUTHORITY";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Authority authority = new Authority();
                authority.setId(rs.getInt("id"));
                authority.setMenuId(rs.getInt("menu_id"));
                all.add(authority);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<Authority> findAll(String column, String kw) {
        List<Authority> all = new ArrayList<Authority>();
        String sql = " SELECT * FROM AUTHORITY WHERE " + column + " LIKE ?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Authority authority = new Authority();
                authority.setId(rs.getInt("id"));
                authority.setMenuId(rs.getInt("menu_id"));
                all.add(authority);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<Authority> findAll(int cp, int ls, String column, String kw) {
        List<Authority> all = new ArrayList<Authority>();
        String sql = " SELECT * FROM AUTHORITY WHERE " + column + " LIKE ? limit ?,?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            pstmt.setInt(2, (cp - 1) * ls);
            pstmt.setInt(3, ls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Authority authority = new Authority();
                authority.setId(rs.getInt("id"));
                authority.setMenuId(rs.getInt("menu_id"));
                all.add(authority);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public int findCount() {
        String sql = " SELECT count(*) FROM AUTHORITY";
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
        String sql = " SELECT count(*) FROM AUTHORITY WHERE " + column + " LIKE ? ";
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
