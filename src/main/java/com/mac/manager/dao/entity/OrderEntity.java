package com.mac.manager.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by machao on 2015/3/30.
 */
@Entity
@Table(name = "order", schema = "", catalog = "mac")
public class OrderEntity {
    private String orderId;
    private Integer peopleNumber;
    private String orderByUsername;
    private String orderByPhone;
    private String orderMessage;

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(name = "order_id", nullable = false, insertable = true, updatable = true, length = 36)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "people_number", nullable = true, insertable = true, updatable = true)
    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    @Basic
    @Column(name = "order_by_username", nullable = true, insertable = true, updatable = true, length = 16)
    public String getOrderByUsername() {
        return orderByUsername;
    }

    public void setOrderByUsername(String orderByUsername) {
        this.orderByUsername = orderByUsername;
    }

    @Basic
    @Column(name = "order_by_phone", nullable = true, insertable = true, updatable = true, length = 11)
    public String getOrderByPhone() {
        return orderByPhone;
    }

    public void setOrderByPhone(String orderByPhone) {
        this.orderByPhone = orderByPhone;
    }

    @Basic
    @Column(name = "order_message", nullable = true, insertable = true, updatable = true, length = 2000)
    public String getOrderMessage() {
        return orderMessage;
    }

    public void setOrderMessage(String orderMessage) {
        this.orderMessage = orderMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (orderByPhone != null ? !orderByPhone.equals(that.orderByPhone) : that.orderByPhone != null) return false;
        if (orderByUsername != null ? !orderByUsername.equals(that.orderByUsername) : that.orderByUsername != null)
            return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (orderMessage != null ? !orderMessage.equals(that.orderMessage) : that.orderMessage != null) return false;
        if (peopleNumber != null ? !peopleNumber.equals(that.peopleNumber) : that.peopleNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (peopleNumber != null ? peopleNumber.hashCode() : 0);
        result = 31 * result + (orderByUsername != null ? orderByUsername.hashCode() : 0);
        result = 31 * result + (orderByPhone != null ? orderByPhone.hashCode() : 0);
        result = 31 * result + (orderMessage != null ? orderMessage.hashCode() : 0);
        return result;
    }
}
