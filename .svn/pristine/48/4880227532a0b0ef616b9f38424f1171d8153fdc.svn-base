package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.oraclewdp.crm.dao.*;


import com.oraclewdp.crm.entity.*;

public class CustomChanceDAOImpl implements ICustomChanceDAO {
    private Connection conn;

    public CustomChanceDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean create(CustomChance customChance) {
        String sql = "INSERT INTO CUSTOM_CHANCE(id,code,name,type,creator,createdate,attach_id,chance_stage,possibility) values (?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, customChance.getId());
            pstmt.setString(2, customChance.getCode());
            pstmt.setString(3, customChance.getName());
            pstmt.setInt(4, customChance.getType());
            pstmt.setInt(5, customChance.getCreator());
            pstmt.setString(6, customChance.getCreatedate());
            pstmt.setInt(7, customChance.getAttachId());
            pstmt.setInt(8, customChance.getChanceStage());
            pstmt.setString(9, customChance.getPossibility());
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
        String sql = "DELETE FROM CUSTOM_CHANCE WHERE id= ? ";
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

    public int updateByID(CustomChance customChance) {
        String sql = "UPDATE CUSTOM_CHANCE SET code=?,name=?,type=?,creator=?,createdate=?,attach_id=?,chance_stage=?,possibility=? WHERE id = ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, customChance.getCode());
            pstmt.setString(2, customChance.getName());
            pstmt.setInt(3, customChance.getType());
            pstmt.setInt(4, customChance.getCreator());
            pstmt.setString(5, customChance.getCreatedate());
            pstmt.setInt(6, customChance.getAttachId());
            pstmt.setInt(7, customChance.getChanceStage());
            pstmt.setString(8, customChance.getPossibility());
            pstmt.setInt(9, customChance.getId());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CustomChance findByID(Integer id) {
        String sql = " SELECT * FROM CUSTOM_CHANCE WHERE id = ? ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            CustomChance customChance = null;
            while (rs.next()) {
                customChance = new CustomChance();
                customChance.setId(rs.getInt("id"));
                customChance.setCode(rs.getString("code"));
                customChance.setName(rs.getString("name"));
                customChance.setType(rs.getInt("type"));
                customChance.setCreator(rs.getInt("creator"));
                customChance.setCreatedate(rs.getString("createdate"));
                customChance.setAttachId(rs.getInt("attach_id"));
                customChance.setChanceStage(rs.getInt("chance_stage"));
                customChance.setPossibility(rs.getString("possibility"));
            }
            pstmt.close();
            rs.close();
            return customChance;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CustomChance> findAll() {
        List<CustomChance> all = new ArrayList<CustomChance>();
        String sql = " SELECT * FROM CUSTOM_CHANCE";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomChance customChance = new CustomChance();
                customChance.setId(rs.getInt("id"));
                customChance.setCode(rs.getString("code"));
                customChance.setName(rs.getString("name"));
                customChance.setType(rs.getInt("type"));
                customChance.setCreator(rs.getInt("creator"));
                customChance.setCreatedate(rs.getString("createdate"));
                customChance.setAttachId(rs.getInt("attach_id"));
                customChance.setChanceStage(rs.getInt("chance_stage"));
                customChance.setPossibility(rs.getString("possibility"));
                all.add(customChance);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<CustomChance> findAll(String column, String kw) {
        List<CustomChance> all = new ArrayList<CustomChance>();
        String sql = " SELECT * FROM CUSTOM_CHANCE WHERE " + column + " LIKE ?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomChance customChance = new CustomChance();
                customChance.setId(rs.getInt("id"));
                customChance.setCode(rs.getString("code"));
                customChance.setName(rs.getString("name"));
                customChance.setType(rs.getInt("type"));
                customChance.setCreator(rs.getInt("creator"));
                customChance.setCreatedate(rs.getString("createdate"));
                customChance.setAttachId(rs.getInt("attach_id"));
                customChance.setChanceStage(rs.getInt("chance_stage"));
                customChance.setPossibility(rs.getString("possibility"));
                all.add(customChance);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<CustomChance> findAll(int cp, int ls, String column, String kw) {
        List<CustomChance> all = new ArrayList<CustomChance>();
        String sql = " SELECT * FROM CUSTOM_CHANCE WHERE " + column + " LIKE ? limit ?,?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            pstmt.setInt(2, (cp - 1) * ls);
            pstmt.setInt(3, ls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomChance customChance = new CustomChance();
                customChance.setId(rs.getInt("id"));
                customChance.setCode(rs.getString("code"));
                customChance.setName(rs.getString("name"));
                customChance.setType(rs.getInt("type"));
                customChance.setCreator(rs.getInt("creator"));
                customChance.setCreatedate(rs.getString("createdate"));
                customChance.setAttachId(rs.getInt("attach_id"));
                customChance.setChanceStage(rs.getInt("chance_stage"));
                customChance.setPossibility(rs.getString("possibility"));
                all.add(customChance);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public int findCount() {
        String sql = " SELECT count(*) FROM CUSTOM_CHANCE";
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
        String sql = " SELECT count(*) FROM CUSTOM_CHANCE WHERE " + column + " LIKE ? ";
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
