package com.mac.manager.dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by machao on 2015/2/28.
 */
@Entity
@Table(name = "menu", schema = "", catalog = "mac")
public class MenuEntity {
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
    private CategoryEntity categoryByCategoryId;

    @Id
    @Column(name = "dish_id", nullable = false, insertable = true, updatable = true, length = 36)
    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    @Basic
    @Column(name = "dish_name", nullable = true, insertable = true, updatable = true, length = 45)
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Basic
    @Column(name = "dish_english_name", nullable = true, insertable = true, updatable = true, length = 40)
    public String getDishEnglishName() {
        return dishEnglishName;
    }

    public void setDishEnglishName(String dishEnglishName) {
        this.dishEnglishName = dishEnglishName;
    }

    @Basic
    @Column(name = "dish_price", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(BigDecimal dishPrice) {
        this.dishPrice = dishPrice;
    }

    @Basic
    @Column(name = "dish_description", nullable = true, insertable = true, updatable = true, length = 200)
    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    @Basic
    @Column(name = "spicy_level", nullable = true, insertable = true, updatable = true)
    public Integer getSpicyLevel() {
        return spicyLevel;
    }

    public void setSpicyLevel(Integer spicyLevel) {
        this.spicyLevel = spicyLevel;
    }

    @Basic
    @Column(name = "hot_level", nullable = true, insertable = true, updatable = true)
    public Integer getHotLevel() {
        return hotLevel;
    }

    public void setHotLevel(Integer hotLevel) {
        this.hotLevel = hotLevel;
    }

    @Basic
    @Column(name = "dish_imgurl", nullable = true, insertable = true, updatable = true, length = 100)
    public String getDishImgurl() {
        return dishImgurl;
    }

    public void setDishImgurl(String dishImgurl) {
        this.dishImgurl = dishImgurl;
    }

    @Basic
    @Column(name = "dish_price2", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getDishPrice2() {
        return dishPrice2;
    }

    public void setDishPrice2(BigDecimal dishPrice2) {
        this.dishPrice2 = dishPrice2;
    }

    @Basic
    @Column(name = "dish_origin", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDishOrigin() {
        return dishOrigin;
    }

    public void setDishOrigin(String dishOrigin) {
        this.dishOrigin = dishOrigin;
    }

    @Basic
    @Column(name = "dish_capacity", nullable = true, insertable = true, updatable = true)
    public Integer getDishCapacity() {
        return dishCapacity;
    }

    public void setDishCapacity(Integer dishCapacity) {
        this.dishCapacity = dishCapacity;
    }

    @Basic
    @Column(name = "dish_unit", nullable = true, insertable = true, updatable = true, length = 8)
    public String getDishUnit() {
        return dishUnit;
    }

    public void setDishUnit(String dishUnit) {
        this.dishUnit = dishUnit;
    }

    @Basic
    @Column(name = "dish_group", nullable = true, insertable = true, updatable = true, length = 4)
    public String getDishGroup() {
        return dishGroup;
    }

    public void setDishGroup(String dishGroup) {
        this.dishGroup = dishGroup;
    }

    @Basic
    @Column(name = "dish_order", nullable = true, insertable = true, updatable = true)
    public Integer getDishOrder() {
        return dishOrder;
    }

    public void setDishOrder(Integer dishOrder) {
        this.dishOrder = dishOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuEntity that = (MenuEntity) o;

        if (dishCapacity != null ? !dishCapacity.equals(that.dishCapacity) : that.dishCapacity != null) return false;
        if (dishDescription != null ? !dishDescription.equals(that.dishDescription) : that.dishDescription != null)
            return false;
        if (dishEnglishName != null ? !dishEnglishName.equals(that.dishEnglishName) : that.dishEnglishName != null)
            return false;
        if (dishGroup != null ? !dishGroup.equals(that.dishGroup) : that.dishGroup != null) return false;
        if (dishId != null ? !dishId.equals(that.dishId) : that.dishId != null) return false;
        if (dishImgurl != null ? !dishImgurl.equals(that.dishImgurl) : that.dishImgurl != null) return false;
        if (dishName != null ? !dishName.equals(that.dishName) : that.dishName != null) return false;
        if (dishOrder != null ? !dishOrder.equals(that.dishOrder) : that.dishOrder != null) return false;
        if (dishOrigin != null ? !dishOrigin.equals(that.dishOrigin) : that.dishOrigin != null) return false;
        if (dishPrice != null ? !dishPrice.equals(that.dishPrice) : that.dishPrice != null) return false;
        if (dishPrice2 != null ? !dishPrice2.equals(that.dishPrice2) : that.dishPrice2 != null) return false;
        if (dishUnit != null ? !dishUnit.equals(that.dishUnit) : that.dishUnit != null) return false;
        if (hotLevel != null ? !hotLevel.equals(that.hotLevel) : that.hotLevel != null) return false;
        if (spicyLevel != null ? !spicyLevel.equals(that.spicyLevel) : that.spicyLevel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dishId != null ? dishId.hashCode() : 0;
        result = 31 * result + (dishName != null ? dishName.hashCode() : 0);
        result = 31 * result + (dishEnglishName != null ? dishEnglishName.hashCode() : 0);
        result = 31 * result + (dishPrice != null ? dishPrice.hashCode() : 0);
        result = 31 * result + (dishDescription != null ? dishDescription.hashCode() : 0);
        result = 31 * result + (spicyLevel != null ? spicyLevel.hashCode() : 0);
        result = 31 * result + (hotLevel != null ? hotLevel.hashCode() : 0);
        result = 31 * result + (dishImgurl != null ? dishImgurl.hashCode() : 0);
        result = 31 * result + (dishPrice2 != null ? dishPrice2.hashCode() : 0);
        result = 31 * result + (dishOrigin != null ? dishOrigin.hashCode() : 0);
        result = 31 * result + (dishCapacity != null ? dishCapacity.hashCode() : 0);
        result = 31 * result + (dishUnit != null ? dishUnit.hashCode() : 0);
        result = 31 * result + (dishGroup != null ? dishGroup.hashCode() : 0);
        result = 31 * result + (dishOrder != null ? dishOrder.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
