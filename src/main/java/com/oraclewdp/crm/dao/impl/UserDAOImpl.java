package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.oraclewdp.crm.dao.*;


import com.oraclewdp.crm.entity.*;

public class UserDAOImpl implements IUserDAO {
    private Connection conn;

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean create(User user) {
        String sql = "INSERT INTO USER(workno,workposition,userName,sex,oldpassword,nickName,userPic,phone,email,address,userDetailId,password,status) values (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, user.getWorkno());
            pstmt.setInt(2, user.getWorkposition());
            pstmt.setString(3, user.getUserName());
            pstmt.setString(4, user.getSex());
            pstmt.setString(5, user.getOldpassword());
            pstmt.setString(6, user.getNickName());
            pstmt.setString(7, user.getUserPic());
            pstmt.setString(8, user.getPhone());
            pstmt.setString(9, user.getEmail());
            pstmt.setString(10, user.getAddress());
            pstmt.setInt(11, user.getUserDetailId());
            pstmt.setString(12, user.getPassword());
            pstmt.setInt(13, user.getStatus());
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
        String sql = "DELETE FROM USER WHERE id= ? ";
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

    public int updateByID(User user) {
        String sql = "UPDATE USER SET workno=?,workposition=?,userName=?,sex=?,oldpassword=?,nickName=?,userPic=?,phone=?,email=?,address=?,userDetailId=?,password=?,status=? WHERE id = ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, user.getWorkno());
            pstmt.setInt(2, user.getWorkposition());
            pstmt.setString(3, user.getUserName());
            pstmt.setString(4, user.getSex());
            pstmt.setString(5, user.getOldpassword());
            pstmt.setString(6, user.getNickName());
            pstmt.setString(7, user.getUserPic());
            pstmt.setString(8, user.getPhone());
            pstmt.setString(9, user.getEmail());
            pstmt.setString(10, user.getAddress());
            pstmt.setInt(11, user.getUserDetailId());
            pstmt.setString(12, user.getPassword());
            pstmt.setInt(13, user.getStatus());
            pstmt.setInt(14, user.getId());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public User findByID(Integer id) {
        String sql = " SELECT * FROM USER WHERE id = ? ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setWorkno(rs.getString("workno"));
                user.setWorkposition(rs.getInt("workposition"));
                user.setUserName(rs.getString("userName"));
                user.setSex(rs.getString("sex"));
                user.setOldpassword(rs.getString("oldpassword"));
                user.setNickName(rs.getString("nickName"));
                user.setUserPic(rs.getString("userPic"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setUserDetailId(rs.getInt("userDetailId"));
                user.setPassword(rs.getString("password"));
                user.setStatus(rs.getInt("status"));
            }
            pstmt.close();
            rs.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findAll() {
        List<User> all = new ArrayList<User>();
        String sql = " SELECT * FROM USER";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setWorkno(rs.getString("workno"));
                user.setWorkposition(rs.getInt("workposition"));
                user.setUserName(rs.getString("userName"));
                user.setSex(rs.getString("sex"));
                user.setOldpassword(rs.getString("oldpassword"));
                user.setNickName(rs.getString("nickName"));
                user.setUserPic(rs.getString("userPic"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setUserDetailId(rs.getInt("userDetailId"));
                user.setPassword(rs.getString("password"));
                user.setStatus(rs.getInt("status"));
                all.add(user);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<User> findAll(String column, String kw) {
        List<User> all = new ArrayList<User>();
        String sql = " SELECT * FROM USER WHERE " + column + " LIKE ?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setWorkno(rs.getString("workno"));
                user.setWorkposition(rs.getInt("workposition"));
                user.setUserName(rs.getString("userName"));
                user.setSex(rs.getString("sex"));
                user.setOldpassword(rs.getString("oldpassword"));
                user.setNickName(rs.getString("nickName"));
                user.setUserPic(rs.getString("userPic"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setUserDetailId(rs.getInt("userDetailId"));
                user.setPassword(rs.getString("password"));
                user.setStatus(rs.getInt("status"));
                all.add(user);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<User> findAll(int cp, int ls, String column, String kw) {
        List<User> all = new ArrayList<User>();
        String sql = " SELECT * FROM USER WHERE " + column + " LIKE ? limit ?,?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            pstmt.setInt(2, (cp - 1) * ls);
            pstmt.setInt(3, ls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setWorkno(rs.getString("workno"));
                user.setWorkposition(rs.getInt("workposition"));
                user.setUserName(rs.getString("userName"));
                user.setSex(rs.getString("sex"));
                user.setOldpassword(rs.getString("oldpassword"));
                user.setNickName(rs.getString("nickName"));
                user.setUserPic(rs.getString("userPic"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setUserDetailId(rs.getInt("userDetailId"));
                user.setPassword(rs.getString("password"));
                user.setStatus(rs.getInt("status"));
                all.add(user);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public int findCount() {
        String sql = " SELECT count(*) FROM USER";
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
        String sql = " SELECT count(*) FROM USER WHERE " + column + " LIKE ? ";
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
