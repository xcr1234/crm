package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.oraclewdp.crm.dao.*;


import com.oraclewdp.crm.entity.*;

public class DicAllDAOImpl implements IDicAllDAO {
    private Connection conn;

    public DicAllDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean create(DicAll dicAll) {
        String sql = "INSERT INTO DIC_ALL(type,name,status) values (?,?,?) ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, dicAll.getType());
            pstmt.setString(2, dicAll.getName());
            pstmt.setBoolean(3, dicAll.getStatus());
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
        String sql = "DELETE FROM DIC_ALL WHERE id= ? ";
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

    public int updateByID(DicAll dicAll) {
        String sql = "UPDATE DIC_ALL SET type=?,name=?,status=? WHERE id = ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, dicAll.getType());
            pstmt.setString(2, dicAll.getName());
            pstmt.setBoolean(3, dicAll.getStatus());
            pstmt.setInt(4, dicAll.getId());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public DicAll findByID(Integer id) {
        String sql = " SELECT * FROM DIC_ALL WHERE id = ? ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            DicAll dicAll = null;
            while (rs.next()) {
                dicAll = new DicAll();
                dicAll.setId(rs.getInt("id"));
                dicAll.setType(rs.getString("type"));
                dicAll.setName(rs.getString("name"));
                dicAll.setStatus(rs.getBoolean("status"));
            }
            pstmt.close();
            rs.close();
            return dicAll;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DicAll> findAll() {
        List<DicAll> all = new ArrayList<DicAll>();
        String sql = " SELECT * FROM DIC_ALL";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DicAll dicAll = new DicAll();
                dicAll.setId(rs.getInt("id"));
                dicAll.setType(rs.getString("type"));
                dicAll.setName(rs.getString("name"));
                dicAll.setStatus(rs.getBoolean("status"));
                all.add(dicAll);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<DicAll> findAll(String column, String kw) {
        List<DicAll> all = new ArrayList<DicAll>();
        String sql = " SELECT * FROM DIC_ALL WHERE " + column + " LIKE ?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DicAll dicAll = new DicAll();
                dicAll.setId(rs.getInt("id"));
                dicAll.setType(rs.getString("type"));
                dicAll.setName(rs.getString("name"));
                dicAll.setStatus(rs.getBoolean("status"));
                all.add(dicAll);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<DicAll> findAll(int cp, int ls, String column, String kw) {
        List<DicAll> all = new ArrayList<DicAll>();
        String sql = " SELECT * FROM DIC_ALL WHERE " + column + " LIKE ? limit ?,?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            pstmt.setInt(2, (cp - 1) * ls);
            pstmt.setInt(3, ls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DicAll dicAll = new DicAll();
                dicAll.setId(rs.getInt("id"));
                dicAll.setType(rs.getString("type"));
                dicAll.setName(rs.getString("name"));
                dicAll.setStatus(rs.getBoolean("status"));
                all.add(dicAll);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public int findCount() {
        String sql = " SELECT count(*) FROM DIC_ALL";
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
        String sql = " SELECT count(*) FROM DIC_ALL WHERE " + column + " LIKE ? ";
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
