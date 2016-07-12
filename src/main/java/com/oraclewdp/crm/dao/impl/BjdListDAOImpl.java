package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.oraclewdp.crm.dao.*;


import com.oraclewdp.crm.entity.*;

public class BjdListDAOImpl implements IBjdListDAO {
    private Connection conn;

    public BjdListDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean create(BjdList bjdList) {
        String sql = "INSERT INTO BJD_LIST(goods_id,bjd_id,count,rate,per_price_rate,digest,price_rate,price,totle_price) values (?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, bjdList.getGoodsId());
            pstmt.setInt(2, bjdList.getBjdId());
            pstmt.setInt(3, bjdList.getCount());
            pstmt.setInt(4, bjdList.getRate());
            pstmt.setFloat(5, bjdList.getPerPriceRate());
            pstmt.setString(6, bjdList.getDigest());
            pstmt.setFloat(7, bjdList.getPriceRate());
            pstmt.setFloat(8, bjdList.getPrice());
            pstmt.setFloat(9, bjdList.getTotlePrice());
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
        String sql = "DELETE FROM BJD_LIST WHERE id= ? ";
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

    public int updateByID(BjdList bjdList) {
        String sql = "UPDATE BJD_LIST SET goods_id=?,bjd_id=?,count=?,rate=?,per_price_rate=?,digest=?,price_rate=?,price=?,totle_price=? WHERE id = ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, bjdList.getGoodsId());
            pstmt.setInt(2, bjdList.getBjdId());
            pstmt.setInt(3, bjdList.getCount());
            pstmt.setInt(4, bjdList.getRate());
            pstmt.setFloat(5, bjdList.getPerPriceRate());
            pstmt.setString(6, bjdList.getDigest());
            pstmt.setFloat(7, bjdList.getPriceRate());
            pstmt.setFloat(8, bjdList.getPrice());
            pstmt.setFloat(9, bjdList.getTotlePrice());
            pstmt.setInt(10, bjdList.getId());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public BjdList findByID(Integer id) {
        String sql = " SELECT * FROM BJD_LIST WHERE id = ? ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            BjdList bjdList = null;
            while (rs.next()) {
                bjdList = new BjdList();
                bjdList.setId(rs.getInt("id"));
                bjdList.setGoodsId(rs.getInt("goods_id"));
                bjdList.setBjdId(rs.getInt("bjd_id"));
                bjdList.setCount(rs.getInt("count"));
                bjdList.setRate(rs.getInt("rate"));
                bjdList.setPerPriceRate(rs.getFloat("per_price_rate"));
                bjdList.setDigest(rs.getString("digest"));
                bjdList.setPriceRate(rs.getFloat("price_rate"));
                bjdList.setPrice(rs.getFloat("price"));
                bjdList.setTotlePrice(rs.getFloat("totle_price"));
            }
            pstmt.close();
            rs.close();
            return bjdList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BjdList> findAll() {
        List<BjdList> all = new ArrayList<BjdList>();
        String sql = " SELECT * FROM BJD_LIST";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BjdList bjdList = new BjdList();
                bjdList.setId(rs.getInt("id"));
                bjdList.setGoodsId(rs.getInt("goods_id"));
                bjdList.setBjdId(rs.getInt("bjd_id"));
                bjdList.setCount(rs.getInt("count"));
                bjdList.setRate(rs.getInt("rate"));
                bjdList.setPerPriceRate(rs.getFloat("per_price_rate"));
                bjdList.setDigest(rs.getString("digest"));
                bjdList.setPriceRate(rs.getFloat("price_rate"));
                bjdList.setPrice(rs.getFloat("price"));
                bjdList.setTotlePrice(rs.getFloat("totle_price"));
                all.add(bjdList);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<BjdList> findAll(String column, String kw) {
        List<BjdList> all = new ArrayList<BjdList>();
        String sql = " SELECT * FROM BJD_LIST WHERE " + column + " LIKE ?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BjdList bjdList = new BjdList();
                bjdList.setId(rs.getInt("id"));
                bjdList.setGoodsId(rs.getInt("goods_id"));
                bjdList.setBjdId(rs.getInt("bjd_id"));
                bjdList.setCount(rs.getInt("count"));
                bjdList.setRate(rs.getInt("rate"));
                bjdList.setPerPriceRate(rs.getFloat("per_price_rate"));
                bjdList.setDigest(rs.getString("digest"));
                bjdList.setPriceRate(rs.getFloat("price_rate"));
                bjdList.setPrice(rs.getFloat("price"));
                bjdList.setTotlePrice(rs.getFloat("totle_price"));
                all.add(bjdList);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<BjdList> findAll(int cp, int ls, String column, String kw) {
        List<BjdList> all = new ArrayList<BjdList>();
        String sql = " SELECT * FROM BJD_LIST WHERE " + column + " LIKE ? limit ?,?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            pstmt.setInt(2, (cp - 1) * ls);
            pstmt.setInt(3, ls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BjdList bjdList = new BjdList();
                bjdList.setId(rs.getInt("id"));
                bjdList.setGoodsId(rs.getInt("goods_id"));
                bjdList.setBjdId(rs.getInt("bjd_id"));
                bjdList.setCount(rs.getInt("count"));
                bjdList.setRate(rs.getInt("rate"));
                bjdList.setPerPriceRate(rs.getFloat("per_price_rate"));
                bjdList.setDigest(rs.getString("digest"));
                bjdList.setPriceRate(rs.getFloat("price_rate"));
                bjdList.setPrice(rs.getFloat("price"));
                bjdList.setTotlePrice(rs.getFloat("totle_price"));
                all.add(bjdList);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public int findCount() {
        String sql = " SELECT count(*) FROM BJD_LIST";
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
        String sql = " SELECT count(*) FROM BJD_LIST WHERE " + column + " LIKE ? ";
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
