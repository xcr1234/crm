package com.oraclewdp.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.oraclewdp.crm.dao.*;


import com.oraclewdp.crm.entity.*;

public class RoleauthorityDAOImpl implements IRoleauthorityDAO {
    private Connection conn;

    public RoleauthorityDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean create(RoleAuthority roleauthority) {
        String sql = "INSERT INTO ROLEAUTHORITY(roleId,authorityId) values (?,?) ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, roleauthority.getRoleid());
            pstmt.setInt(2, roleauthority.getAuthorityid());
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
        String sql = "DELETE FROM ROLEAUTHORITY WHERE id= ? ";
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

    public int updateByID(RoleAuthority roleauthority) {
        String sql = "UPDATE ROLEAUTHORITY SET roleId=?,authorityId=? WHERE id = ? ";
        int result = 0;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, roleauthority.getRoleid());
            pstmt.setInt(2, roleauthority.getAuthorityid());
            pstmt.setInt(3, roleauthority.getId());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public RoleAuthority findByID(Integer id) {
        String sql = " SELECT * FROM ROLEAUTHORITY WHERE id = ? ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            RoleAuthority roleauthority = null;
            while (rs.next()) {
                roleauthority = new RoleAuthority();
                roleauthority.setId(rs.getInt("id"));
                roleauthority.setRoleid(rs.getInt("roleId"));
                roleauthority.setAuthorityid(rs.getInt("authorityId"));
            }
            pstmt.close();
            rs.close();
            return roleauthority;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<RoleAuthority> findAll() {
        List<RoleAuthority> all = new ArrayList<RoleAuthority>();
        String sql = " SELECT * FROM ROLEAUTHORITY";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                RoleAuthority roleauthority = new RoleAuthority();
                roleauthority.setId(rs.getInt("id"));
                roleauthority.setRoleid(rs.getInt("roleId"));
                roleauthority.setAuthorityid(rs.getInt("authorityId"));
                all.add(roleauthority);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<RoleAuthority> findAll(String column, String kw) {
        List<RoleAuthority> all = new ArrayList<RoleAuthority>();
        String sql = " SELECT * FROM ROLEAUTHORITY WHERE " + column + " LIKE ?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                RoleAuthority roleauthority = new RoleAuthority();
                roleauthority.setId(rs.getInt("id"));
                roleauthority.setRoleid(rs.getInt("roleId"));
                roleauthority.setAuthorityid(rs.getInt("authorityId"));
                all.add(roleauthority);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<RoleAuthority> findAll(int cp, int ls, String column, String kw) {
        List<RoleAuthority> all = new ArrayList<RoleAuthority>();
        String sql = " SELECT * FROM ROLEAUTHORITY WHERE " + column + " LIKE ? limit ?,?  ";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, "%" + kw + "%");
            pstmt.setInt(2, (cp - 1) * ls);
            pstmt.setInt(3, ls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                RoleAuthority roleauthority = new RoleAuthority();
                roleauthority.setId(rs.getInt("id"));
                roleauthority.setRoleid(rs.getInt("roleId"));
                roleauthority.setAuthorityid(rs.getInt("authorityId"));
                all.add(roleauthority);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public int findCount() {
        String sql = " SELECT count(*) FROM ROLEAUTHORITY";
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
        String sql = " SELECT count(*) FROM ROLEAUTHORITY WHERE " + column + " LIKE ? ";
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
