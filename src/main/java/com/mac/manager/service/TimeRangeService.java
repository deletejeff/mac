package com.mac.manager.service;

import com.mac.manager.vo.TimeRangeVo;

import java.util.List;

/**
 * Created by machao on 2015/3/30.
 */
public interface TimeRangeService {
    public List<TimeRangeVo> findList();

    public boolean addTimeRange(TimeRangeVo timeRangeVo);

    public boolean deleteTimeRange(String timeRangeId);

    public boolean updateTimeRange(TimeRangeVo timeRangeVo);
}
