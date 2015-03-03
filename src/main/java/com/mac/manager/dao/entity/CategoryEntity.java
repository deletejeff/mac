package com.mac.manager.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by machao on 2015/3/2.
 */
@Entity
@Table(name = "category", schema = "", catalog = "mac")
public class CategoryEntity {
    private String categoryId;
    private String categoryName;
    private Integer categoryOrder;

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(name = "category_id", nullable = false, insertable = true, updatable = true, length = 36)
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "category_name", nullable = true, insertable = true, updatable = true, length = 40)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "category_order", nullable = true, insertable = true, updatable = true)
    public Integer getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(Integer categoryOrder) {
        this.categoryOrder = categoryOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;
        if (categoryOrder != null ? !categoryOrder.equals(that.categoryOrder) : that.categoryOrder != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId != null ? categoryId.hashCode() : 0;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (categoryOrder != null ? categoryOrder.hashCode() : 0);
        return result;
    }
}
