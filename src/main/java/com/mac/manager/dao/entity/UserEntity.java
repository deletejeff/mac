package com.mac.manager.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by machao on 2015/3/12.
 */
@Entity
@Table(name = "user", schema = "", catalog = "mac")
public class UserEntity {
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

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(name = "uid", nullable = false, insertable = true, updatable = true, length = 16)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "user_name", nullable = true, insertable = true, updatable = true, length = 32)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_password", nullable = true, insertable = true, updatable = true, length = 64)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_email", nullable = true, insertable = true, updatable = true, length = 60)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "nickname", nullable = true, insertable = true, updatable = true, length = 60)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "open_id", nullable = true, insertable = true, updatable = true, length = 30)
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "real_name", nullable = true, insertable = true, updatable = true, length = 20)
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "phone", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "gender", nullable = true, insertable = true, updatable = true, length = 20)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "status", nullable = true, insertable = true, updatable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "last_login_ip", nullable = true, insertable = true, updatable = true, length = 15)
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Basic
    @Column(name = "superman", nullable = true, insertable = true, updatable = true)
    public Integer getSuperman() {
        return superman;
    }

    public void setSuperman(Integer superman) {
        this.superman = superman;
    }

    @Basic
    @Column(name = "created_at", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "created_by_user_id", nullable = true, insertable = true, updatable = true, length = 60)
    public String getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(String createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    @Basic
    @Column(name = "head_img_url", nullable = true, insertable = true, updatable = true, length = 300)
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (createdByUserId != null ? !createdByUserId.equals(that.createdByUserId) : that.createdByUserId != null)
            return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (headImgUrl != null ? !headImgUrl.equals(that.headImgUrl) : that.headImgUrl != null) return false;
        if (lastLoginIp != null ? !lastLoginIp.equals(that.lastLoginIp) : that.lastLoginIp != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (openId != null ? !openId.equals(that.openId) : that.openId != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (superman != null ? !superman.equals(that.superman) : that.superman != null) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (openId != null ? openId.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (lastLoginIp != null ? lastLoginIp.hashCode() : 0);
        result = 31 * result + (superman != null ? superman.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (createdByUserId != null ? createdByUserId.hashCode() : 0);
        result = 31 * result + (headImgUrl != null ? headImgUrl.hashCode() : 0);
        return result;
    }
}
