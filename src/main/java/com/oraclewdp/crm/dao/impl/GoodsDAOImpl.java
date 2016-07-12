package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.oraclewdp.crm.dao.*;


import com.oraclewdp.crm.entity.*;

public class GoodsDAOImpl implements IGoodsDAO {
    private Connection conn;

    public GoodsDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean create(Goods goods) {
        String sql = "INSERT INTO GOODS(id,name,code,picture,model,unit,kcsl,kykc,price,status) values (?,?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, goods.getId());
            pstmt.setString(2, goods.getName());
            pstmt.setString(3, goods.getCode());
            pstmt.setString(4, goods.getPicture());
            pstmt.setString(5, goods.getModel());
            pstmt.setInt(6, goods.getUnit());
            pstmt.setInt(7, goods.getKcsl());
            pstmt.setInt(8, goods.getKykc());
            pstmt.setFloat(9, goods.getPrice());
            pstmt.setBoolean(10, goods.getStatus());
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
        String sql = "DELETE FROM GOODS WHERE id= ? ";
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

    public int updateByID(Goods goods) {
        String sql = "UPDATE GOODS SET name=?,code=?,picture=?,model=?,unit=?,kcsl=?,kykc=?,price=?,status=? WHERE id = ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, goods.getName());
            pstmt.setString(2, goods.getCode());
            pstmt.setString(3, goods.getPicture());
            pstmt.setString(4, goods.getModel());
            pstmt.setInt(5, goods.getUnit());
            pstmt.setInt(6, goods.getKcsl());
            pstmt.setInt(7, goods.getKykc());
            pstmt.setFloat(8, goods.getPrice());
            pstmt.setBoolean(9, goods.getStatus());
            pstmt.setInt(10, goods.getId());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Goods findByID(Integer id) {
        String sql = " SELECT * FROM GOODS WHERE id = ? ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Goods goods = null;
            while (rs.next()) {
                goods = new Goods();
                goods.setId(rs.getInt("id"));
                goods.setName(rs.getString("name"));
                goods.setCode(rs.getString("code"));
                goods.setPicture(rs.getString("picture"));
                goods.setModel(rs.getString("model"));
                goods.setUnit(rs.getInt("unit"));
                goods.setKcsl(rs.getInt("kcsl"));
                goods.setKykc(rs.getInt("kykc"));
                goods.setPrice(rs.getFloat("price"));
                goods.setStatus(rs.getBoolean("status"));
            }
            pstmt.close();
            rs.close();
            return goods;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Goods> findAll() {
        List<Goods> all = new ArrayList<Goods>();
        String sql = " SELECT * FROM GOODS";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setId(rs.getInt("id"));
                goods.setName(rs.getString("name"));
                goods.setCode(rs.getString("code"));
                goods.setPicture(rs.getString("picture"));
                goods.setModel(rs.getString("model"));
                goods.setUnit(rs.getInt("unit"));
                goods.setKcsl(rs.getInt("kcsl"));
                goods.setKykc(rs.getInt("kykc"));
                goods.setPrice(rs.getFloat("price"));
                goods.setStatus(rs.getBoolean("status"));
                all.add(goods);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<Goods> findAll(String column, String kw) {
        List<Goods> all = new ArrayList<Goods>();
        String sql = " SELECT * FROM GOODS WHERE " + column + " LIKE ?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setId(rs.getInt("id"));
                goods.setName(rs.getString("name"));
                goods.setCode(rs.getString("code"));
                goods.setPicture(rs.getString("picture"));
                goods.setModel(rs.getString("model"));
                goods.setUnit(rs.getInt("unit"));
                goods.setKcsl(rs.getInt("kcsl"));
                goods.setKykc(rs.getInt("kykc"));
                goods.setPrice(rs.getFloat("price"));
                goods.setStatus(rs.getBoolean("status"));
                all.add(goods);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<Goods> findAll(int cp, int ls, String column, String kw) {
        List<Goods> all = new ArrayList<Goods>();
        String sql = " SELECT * FROM GOODS WHERE " + column + " LIKE ? limit ?,?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            pstmt.setInt(2, (cp - 1) * ls);
            pstmt.setInt(3, ls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setId(rs.getInt("id"));
                goods.setName(rs.getString("name"));
                goods.setCode(rs.getString("code"));
                goods.setPicture(rs.getString("picture"));
                goods.setModel(rs.getString("model"));
                goods.setUnit(rs.getInt("unit"));
                goods.setKcsl(rs.getInt("kcsl"));
                goods.setKykc(rs.getInt("kykc"));
                goods.setPrice(rs.getFloat("price"));
                goods.setStatus(rs.getBoolean("status"));
                all.add(goods);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public int findCount() {
        String sql = " SELECT count(*) FROM GOODS";
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
        String sql = " SELECT count(*) FROM GOODS WHERE " + column + " LIKE ? ";
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
