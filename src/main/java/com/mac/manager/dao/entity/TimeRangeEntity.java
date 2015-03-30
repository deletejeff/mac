package com.mac.manager.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by machao on 2015/3/30.
 */
@Entity
@Table(name = "time_range", schema = "", catalog = "mac")
public class TimeRangeEntity {
    private String timeRangeId;
    private Time startTime;
    private Time endTime;

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(name = "time_range_id", nullable = false, insertable = true, updatable = true, length = 36)
    public String getTimeRangeId() {
        return timeRangeId;
    }

    public void setTimeRangeId(String timeRangeId) {
        this.timeRangeId = timeRangeId;
    }

    @Basic
    @Column(name = "start_time", nullable = true, insertable = true, updatable = true)
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = true, insertable = true, updatable = true)
    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeRangeEntity that = (TimeRangeEntity) o;

        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (timeRangeId != null ? !timeRangeId.equals(that.timeRangeId) : that.timeRangeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = timeRangeId != null ? timeRangeId.hashCode() : 0;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }
}
