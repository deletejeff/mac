package com.mac.manager.vo;

import java.util.Date;

/**
 * Created by machao on 2015/3/30.
 */
public class TimeRangeVo {
    private String timeRangeId;
    private Date startTime;
    private Date endTime;

    public TimeRangeVo() {
    }

    public TimeRangeVo(String timeRangeId, Date startTime, Date endTime) {
        this.timeRangeId = timeRangeId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTimeRangeId() {
        return timeRangeId;
    }

    public void setTimeRangeId(String timeRangeId) {
        this.timeRangeId = timeRangeId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
