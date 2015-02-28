package com.mac.manager.vo;

import java.math.BigDecimal;

/**
 * Created by machao on 2015/2/12.
 */
public class MenuVo {
    private String dishId;
    private String dishName;
    private String dishEnglishName;
    private BigDecimal dishPrice;
    private String dishDescription;
    private Integer spicyLevel;
    private Integer hotLevel;
    private String dishImgurl;
    private BigDecimal dishPrice2;
    private String dishOrigin;
    private Integer dishCapacity;
    private String dishUnit;
    private String dishGroup;
    private Integer dishOrder;
    private Integer categoryId;
    private String categoryName;
    private Integer categoryOrder;

    public MenuVo(String dishId, String dishName, String dishEnglishName, BigDecimal dishPrice, String dishDescription, Integer spicyLevel, Integer hotLevel, String dishImgurl, BigDecimal dishPrice2, String dishOrigin, Integer dishCapacity, String dishUnit, String dishGroup, Integer dishOrder, Integer categoryId, String categoryName, Integer categoryOrder) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishEnglishName = dishEnglishName;
        this.dishPrice = dishPrice;
        this.dishDescription = dishDescription;
        this.spicyLevel = spicyLevel;
        this.hotLevel = hotLevel;
        this.dishImgurl = dishImgurl;
        this.dishPrice2 = dishPrice2;
        this.dishOrigin = dishOrigin;
        this.dishCapacity = dishCapacity;
        this.dishUnit = dishUnit;
        this.dishGroup = dishGroup;
        this.dishOrder = dishOrder;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryOrder = categoryOrder;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishEnglishName() {
        return dishEnglishName;
    }

    public void setDishEnglishName(String dishEnglishName) {
        this.dishEnglishName = dishEnglishName;
    }

    public BigDecimal getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(BigDecimal dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public Integer getSpicyLevel() {
        return spicyLevel;
    }

    public void setSpicyLevel(Integer spicyLevel) {
        this.spicyLevel = spicyLevel;
    }

    public Integer getHotLevel() {
        return hotLevel;
    }

    public void setHotLevel(Integer hotLevel) {
        this.hotLevel = hotLevel;
    }

    public String getDishImgurl() {
        return dishImgurl;
    }

    public void setDishImgurl(String dishImgurl) {
        this.dishImgurl = dishImgurl;
    }

    public BigDecimal getDishPrice2() {
        return dishPrice2;
    }

    public void setDishPrice2(BigDecimal dishPrice2) {
        this.dishPrice2 = dishPrice2;
    }

    public String getDishOrigin() {
        return dishOrigin;
    }

    public void setDishOrigin(String dishOrigin) {
        this.dishOrigin = dishOrigin;
    }

    public Integer getDishCapacity() {
        return dishCapacity;
    }

    public void setDishCapacity(Integer dishCapacity) {
        this.dishCapacity = dishCapacity;
    }

    public String getDishUnit() {
        return dishUnit;
    }

    public void setDishUnit(String dishUnit) {
        this.dishUnit = dishUnit;
    }

    public String getDishGroup() {
        return dishGroup;
    }

    public void setDishGroup(String dishGroup) {
        this.dishGroup = dishGroup;
    }

    public Integer getDishOrder() {
        return dishOrder;
    }

    public void setDishOrder(Integer dishOrder) {
        this.dishOrder = dishOrder;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(Integer categoryOrder) {
        this.categoryOrder = categoryOrder;
    }
}
