package com.mac.manager.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by machao on 2015/3/30.
 */
@Entity
@Table(name = "order_time_range", schema = "", catalog = "mac")
public class OrderTimeRangeEntity {
    private String orderId;
    private TimeRangeEntity timeRangeByTimeRangeId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderTimeRangeEntity that = (OrderTimeRangeEntity) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return orderId != null ? orderId.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "time_range_id", referencedColumnName = "time_range_id")
    public TimeRangeEntity getTimeRangeByTimeRangeId() {
        return timeRangeByTimeRangeId;
    }

    public void setTimeRangeByTimeRangeId(TimeRangeEntity timeRangeByTimeRangeId) {
        this.timeRangeByTimeRangeId = timeRangeByTimeRangeId;
    }
}
