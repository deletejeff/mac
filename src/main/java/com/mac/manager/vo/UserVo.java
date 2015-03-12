package com.mac.manager.vo;

import java.sql.Timestamp;

/**
 * Created by machao on 2015/3/12.
 */
public class UserVo {
    private String uid;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String nickname;
    private String openId;
    private String realName;
    private String phone;
    private String gender;
    private Integer status;
    private String lastLoginIp;
    private Integer superman;
    private Timestamp createdAt;
    private String createdByUserId;
    private String headImgUrl;

    public UserVo(String uid, String userName, String userPassword, String userEmail, String nickname, String openId, String realName, String phone, String gender, Integer status, String lastLoginIp, Integer superman, Timestamp createdAt, String createdByUserId, String headImgUrl) {
        this.uid = uid;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.nickname = nickname;
        this.openId = openId;
        this.realName = realName;
        this.phone = phone;
        this.gender = gender;
        this.status = status;
        this.lastLoginIp = lastLoginIp;
        this.superman = superman;
        this.createdAt = createdAt;
        this.createdByUserId = createdByUserId;
        this.headImgUrl = headImgUrl;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Integer getSuperman() {
        return superman;
    }

    public void setSuperman(Integer superman) {
        this.superman = superman;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(String createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
}
