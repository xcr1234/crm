package com.oraclewdp.crm.entity;

import com.oraclewdp.crm.persistence.Column;
import com.oraclewdp.crm.persistence.Id;

public class User {
    @Id
    private Integer id;

    private String workno;
    @Column(value = "workposition",foreign = "dic_all",target = "id")
    private DicAll workposition;

    private String userName;

    private String sex;

    private String oldpassword;

    private String nickName;

    private String userPic;

    private String phone;

    private String email;

    private String address;

    private Integer userDetailId;

    private String password;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkno() {
        return workno;
    }

    public void setWorkno(String workno) {
        this.workno = workno;
    }

    public DicAll getWorkposition() {
        return workposition;
    }

    public void setWorkposition(DicAll workposition) {
        this.workposition = workposition;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(Integer userDetailId) {
        this.userDetailId = userDetailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", workno='" + workno + '\'' +
                ", workposition=" + workposition +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", oldpassword='" + oldpassword + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userPic='" + userPic + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", userDetailId=" + userDetailId +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}