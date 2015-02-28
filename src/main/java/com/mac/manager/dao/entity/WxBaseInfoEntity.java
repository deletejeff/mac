package com.mac.manager.dao.entity;

import javax.persistence.*;

/**
 * Created by machao on 2015/2/11.
 */
@Entity
@Table(name = "wx_base_info", schema = "", catalog = "mac")
public class WxBaseInfoEntity {
    private String mpId;
    private String mpName;
    private Integer mpType;
    private String mpDescription;
    private String domainName;
    private String wxId;
    private String appId;
    private String appSecret;
    private String token;
    private String url;
    private String encodingAesKey;
    private Integer encondingType;
    private Integer fansQuantity;
    private Integer verified;
    private String email;

    @Id
    @Column(name = "mp_id")
    public String getMpId() {
        return mpId;
    }

    public void setMpId(String mpId) {
        this.mpId = mpId;
    }

    @Basic
    @Column(name = "mp_name")
    public String getMpName() {
        return mpName;
    }

    public void setMpName(String mpName) {
        this.mpName = mpName;
    }

    @Basic
    @Column(name = "mp_type")
    public Integer getMpType() {
        return mpType;
    }

    public void setMpType(Integer mpType) {
        this.mpType = mpType;
    }

    @Basic
    @Column(name = "mp_description")
    public String getMpDescription() {
        return mpDescription;
    }

    public void setMpDescription(String mpDescription) {
        this.mpDescription = mpDescription;
    }

    @Basic
    @Column(name = "domain_name")
    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @Basic
    @Column(name = "wx_id")
    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    @Basic
    @Column(name = "app_id")
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "app_secret")
    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "encoding_aes_key")
    public String getEncodingAesKey() {
        return encodingAesKey;
    }

    public void setEncodingAesKey(String encodingAesKey) {
        this.encodingAesKey = encodingAesKey;
    }

    @Basic
    @Column(name = "enconding_type")
    public Integer getEncondingType() {
        return encondingType;
    }

    public void setEncondingType(Integer encondingType) {
        this.encondingType = encondingType;
    }

    @Basic
    @Column(name = "fans_quantity")
    public Integer getFansQuantity() {
        return fansQuantity;
    }

    public void setFansQuantity(Integer fansQuantity) {
        this.fansQuantity = fansQuantity;
    }

    @Basic
    @Column(name = "verified")
    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WxBaseInfoEntity that = (WxBaseInfoEntity) o;

        if (appId != null ? !appId.equals(that.appId) : that.appId != null) return false;
        if (appSecret != null ? !appSecret.equals(that.appSecret) : that.appSecret != null) return false;
        if (domainName != null ? !domainName.equals(that.domainName) : that.domainName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (encodingAesKey != null ? !encodingAesKey.equals(that.encodingAesKey) : that.encodingAesKey != null)
            return false;
        if (encondingType != null ? !encondingType.equals(that.encondingType) : that.encondingType != null)
            return false;
        if (fansQuantity != null ? !fansQuantity.equals(that.fansQuantity) : that.fansQuantity != null) return false;
        if (mpDescription != null ? !mpDescription.equals(that.mpDescription) : that.mpDescription != null)
            return false;
        if (mpId != null ? !mpId.equals(that.mpId) : that.mpId != null) return false;
        if (mpName != null ? !mpName.equals(that.mpName) : that.mpName != null) return false;
        if (mpType != null ? !mpType.equals(that.mpType) : that.mpType != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (verified != null ? !verified.equals(that.verified) : that.verified != null) return false;
        if (wxId != null ? !wxId.equals(that.wxId) : that.wxId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mpId != null ? mpId.hashCode() : 0;
        result = 31 * result + (mpName != null ? mpName.hashCode() : 0);
        result = 31 * result + (mpType != null ? mpType.hashCode() : 0);
        result = 31 * result + (mpDescription != null ? mpDescription.hashCode() : 0);
        result = 31 * result + (domainName != null ? domainName.hashCode() : 0);
        result = 31 * result + (wxId != null ? wxId.hashCode() : 0);
        result = 31 * result + (appId != null ? appId.hashCode() : 0);
        result = 31 * result + (appSecret != null ? appSecret.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (encodingAesKey != null ? encodingAesKey.hashCode() : 0);
        result = 31 * result + (encondingType != null ? encondingType.hashCode() : 0);
        result = 31 * result + (fansQuantity != null ? fansQuantity.hashCode() : 0);
        result = 31 * result + (verified != null ? verified.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
