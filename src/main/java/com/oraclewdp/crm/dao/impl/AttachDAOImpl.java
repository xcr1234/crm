package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.oraclewdp.crm.dao.*;


import com.oraclewdp.crm.entity.*;

public class AttachDAOImpl implements IAttachDAO {
    private Connection conn;

    public AttachDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean create(Attach attach) {
        String sql = "INSERT INTO ATTACH(name,type,path) values (?,?,?) ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, attach.getName());
            pstmt.setInt(2, attach.getType());
            pstmt.setString(3, attach.getPath());
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
        String sql = "DELETE FROM ATTACH WHERE id= ? ";
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

    public int updateByID(Attach attach) {
        String sql = "UPDATE ATTACH SET name=?,type=?,path=? WHERE id = ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, attach.getName());
            pstmt.setInt(2, attach.getType());
            pstmt.setString(3, attach.getPath());
            pstmt.setInt(4, attach.getId());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Attach findByID(Integer id) {
        String sql = " SELECT * FROM ATTACH WHERE id = ? ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Attach attach = null;
            while (rs.next()) {
                attach = new Attach();
                attach.setId(rs.getInt("id"));
                attach.setName(rs.getString("name"));
                attach.setType(rs.getInt("type"));
                attach.setPath(rs.getString("path"));
            }
            pstmt.close();
            rs.close();
            return attach;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Attach> findAll() {
        List<Attach> all = new ArrayList<Attach>();
        String sql = " SELECT * FROM ATTACH";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Attach attach = new Attach();
                attach.setId(rs.getInt("id"));
                attach.setName(rs.getString("name"));
                attach.setType(rs.getInt("type"));
                attach.setPath(rs.getString("path"));
                all.add(attach);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<Attach> findAll(String column, String kw) {
        List<Attach> all = new ArrayList<Attach>();
        String sql = " SELECT * FROM ATTACH WHERE " + column + " LIKE ?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Attach attach = new Attach();
                attach.setId(rs.getInt("id"));
                attach.setName(rs.getString("name"));
                attach.setType(rs.getInt("type"));
                attach.setPath(rs.getString("path"));
                all.add(attach);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<Attach> findAll(int cp, int ls, String column, String kw) {
        List<Attach> all = new ArrayList<Attach>();
        String sql = " SELECT * FROM ATTACH WHERE " + column + " LIKE ? limit ?,?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            pstmt.setInt(2, (cp - 1) * ls);
            pstmt.setInt(3, ls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Attach attach = new Attach();
                attach.setId(rs.getInt("id"));
                attach.setName(rs.getString("name"));
                attach.setType(rs.getInt("type"));
                attach.setPath(rs.getString("path"));
                all.add(attach);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public int findCount() {
        String sql = " SELECT count(*) FROM ATTACH";
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
        String sql = " SELECT count(*) FROM ATTACH WHERE " + column + " LIKE ? ";
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
