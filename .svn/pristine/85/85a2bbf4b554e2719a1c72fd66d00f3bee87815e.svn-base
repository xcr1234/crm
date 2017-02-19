package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.oraclewdp.crm.dao.*;


import com.oraclewdp.crm.entity.*;

public class BjdDAOImpl implements IBjdDAO {
    private Connection conn;

    public BjdDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean create(Bjd bjd) {
        String sql = "INSERT INTO BJD(sskh,bjr,yxrq,bjrq,phone,creator,custom_chance_id,createdate,discount,totle_count,totle_rate,totle_pre_price_rate,totle_price_rate,totle_price,totle_discount_price) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, bjd.getSskh());
            pstmt.setInt(2, bjd.getBjr());
            pstmt.setString(3, bjd.getYxrq());
            pstmt.setString(4, bjd.getBjrq());
            pstmt.setString(5, bjd.getPhone());
            pstmt.setString(6, bjd.getCreator());
            pstmt.setInt(7, bjd.getCustomChanceId());
            pstmt.setString(8, bjd.getCreatedate());
            pstmt.setInt(9, bjd.getDiscount());
            pstmt.setInt(10, bjd.getTotleCount());
            pstmt.setFloat(11, bjd.getTotleRate());
            pstmt.setFloat(12, bjd.getTotlePrePriceRate());
            pstmt.setFloat(13, bjd.getTotlePriceRate());
            pstmt.setFloat(14, bjd.getTotlePrice());
            pstmt.setFloat(15, bjd.getTotleDiscountPrice());
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
        String sql = "DELETE FROM BJD WHERE id= ? ";
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

    public int updateByID(Bjd bjd) {
        String sql = "UPDATE BJD SET sskh=?,bjr=?,yxrq=?,bjrq=?,phone=?,creator=?,custom_chance_id=?,createdate=?,discount=?,totle_count=?,totle_rate=?,totle_pre_price_rate=?,totle_price_rate=?,totle_price=?,totle_discount_price=? WHERE id = ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, bjd.getSskh());
            pstmt.setInt(2, bjd.getBjr());
            pstmt.setString(3, bjd.getYxrq());
            pstmt.setString(4, bjd.getBjrq());
            pstmt.setString(5, bjd.getPhone());
            pstmt.setString(6, bjd.getCreator());
            pstmt.setInt(7, bjd.getCustomChanceId());
            pstmt.setString(8, bjd.getCreatedate());
            pstmt.setInt(9, bjd.getDiscount());
            pstmt.setInt(10, bjd.getTotleCount());
            pstmt.setFloat(11, bjd.getTotleRate());
            pstmt.setFloat(12, bjd.getTotlePrePriceRate());
            pstmt.setFloat(13, bjd.getTotlePriceRate());
            pstmt.setFloat(14, bjd.getTotlePrice());
            pstmt.setFloat(15, bjd.getTotleDiscountPrice());
            pstmt.setInt(16, bjd.getId());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Bjd findByID(Integer id) {
        String sql = " SELECT * FROM BJD WHERE id = ? ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Bjd bjd = null;
            while (rs.next()) {
                bjd = new Bjd();
                bjd.setId(rs.getInt("id"));
                bjd.setSskh(rs.getInt("sskh"));
                bjd.setBjr(rs.getInt("bjr"));
                bjd.setYxrq(rs.getString("yxrq"));
                bjd.setBjrq(rs.getString("bjrq"));
                bjd.setPhone(rs.getString("phone"));
                bjd.setCreator(rs.getString("creator"));
                bjd.setCustomChanceId(rs.getInt("custom_chance_id"));
                bjd.setCreatedate(rs.getString("createdate"));
                bjd.setDiscount(rs.getInt("discount"));
                bjd.setTotleCount(rs.getInt("totle_count"));
                bjd.setTotleRate(rs.getFloat("totle_rate"));
                bjd.setTotlePrePriceRate(rs.getFloat("totle_pre_price_rate"));
                bjd.setTotlePriceRate(rs.getFloat("totle_price_rate"));
                bjd.setTotlePrice(rs.getFloat("totle_price"));
                bjd.setTotleDiscountPrice(rs.getFloat("totle_discount_price"));
            }
            pstmt.close();
            rs.close();
            return bjd;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Bjd> findAll() {
        List<Bjd> all = new ArrayList<Bjd>();
        String sql = " SELECT * FROM BJD";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Bjd bjd = new Bjd();
                bjd.setId(rs.getInt("id"));
                bjd.setSskh(rs.getInt("sskh"));
                bjd.setBjr(rs.getInt("bjr"));
                bjd.setYxrq(rs.getString("yxrq"));
                bjd.setBjrq(rs.getString("bjrq"));
                bjd.setPhone(rs.getString("phone"));
                bjd.setCreator(rs.getString("creator"));
                bjd.setCustomChanceId(rs.getInt("custom_chance_id"));
                bjd.setCreatedate(rs.getString("createdate"));
                bjd.setDiscount(rs.getInt("discount"));
                bjd.setTotleCount(rs.getInt("totle_count"));
                bjd.setTotleRate(rs.getFloat("totle_rate"));
                bjd.setTotlePrePriceRate(rs.getFloat("totle_pre_price_rate"));
                bjd.setTotlePriceRate(rs.getFloat("totle_price_rate"));
                bjd.setTotlePrice(rs.getFloat("totle_price"));
                bjd.setTotleDiscountPrice(rs.getFloat("totle_discount_price"));
                all.add(bjd);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<Bjd> findAll(String column, String kw) {
        List<Bjd> all = new ArrayList<Bjd>();
        String sql = " SELECT * FROM BJD WHERE " + column + " LIKE ?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Bjd bjd = new Bjd();
                bjd.setId(rs.getInt("id"));
                bjd.setSskh(rs.getInt("sskh"));
                bjd.setBjr(rs.getInt("bjr"));
                bjd.setYxrq(rs.getString("yxrq"));
                bjd.setBjrq(rs.getString("bjrq"));
                bjd.setPhone(rs.getString("phone"));
                bjd.setCreator(rs.getString("creator"));
                bjd.setCustomChanceId(rs.getInt("custom_chance_id"));
                bjd.setCreatedate(rs.getString("createdate"));
                bjd.setDiscount(rs.getInt("discount"));
                bjd.setTotleCount(rs.getInt("totle_count"));
                bjd.setTotleRate(rs.getFloat("totle_rate"));
                bjd.setTotlePrePriceRate(rs.getFloat("totle_pre_price_rate"));
                bjd.setTotlePriceRate(rs.getFloat("totle_price_rate"));
                bjd.setTotlePrice(rs.getFloat("totle_price"));
                bjd.setTotleDiscountPrice(rs.getFloat("totle_discount_price"));
                all.add(bjd);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<Bjd> findAll(int cp, int ls, String column, String kw) {
        List<Bjd> all = new ArrayList<Bjd>();
        String sql = " SELECT * FROM BJD WHERE " + column + " LIKE ? limit ?,?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            pstmt.setInt(2, (cp - 1) * ls);
            pstmt.setInt(3, ls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Bjd bjd = new Bjd();
                bjd.setId(rs.getInt("id"));
                bjd.setSskh(rs.getInt("sskh"));
                bjd.setBjr(rs.getInt("bjr"));
                bjd.setYxrq(rs.getString("yxrq"));
                bjd.setBjrq(rs.getString("bjrq"));
                bjd.setPhone(rs.getString("phone"));
                bjd.setCreator(rs.getString("creator"));
                bjd.setCustomChanceId(rs.getInt("custom_chance_id"));
                bjd.setCreatedate(rs.getString("createdate"));
                bjd.setDiscount(rs.getInt("discount"));
                bjd.setTotleCount(rs.getInt("totle_count"));
                bjd.setTotleRate(rs.getFloat("totle_rate"));
                bjd.setTotlePrePriceRate(rs.getFloat("totle_pre_price_rate"));
                bjd.setTotlePriceRate(rs.getFloat("totle_price_rate"));
                bjd.setTotlePrice(rs.getFloat("totle_price"));
                bjd.setTotleDiscountPrice(rs.getFloat("totle_discount_price"));
                all.add(bjd);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public int findCount() {
        String sql = " SELECT count(*) FROM BJD";
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
        String sql = " SELECT count(*) FROM BJD WHERE " + column + " LIKE ? ";
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
