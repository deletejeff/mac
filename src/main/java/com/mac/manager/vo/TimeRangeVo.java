package com.mac.manager.vo;

/**
 * Created by machao on 2015/3/30.
 */
public class TimeRangeVo {
    private String timeRangeId;
    private String startTime;
    private String endTime;

    public TimeRangeVo() {
    }

    public TimeRangeVo(String timeRangeId, String startTime, String endTime) {
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
