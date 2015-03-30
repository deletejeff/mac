package com.mac.manager.service.impl;

import com.mac.manager.dao.TimeRangeDao;
import com.mac.manager.dao.entity.TimeRangeEntity;
import com.mac.manager.service.TimeRangeService;
import com.mac.manager.vo.TimeRangeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by machao on 2015/3/30.
 */
@Service
public class TimeRangeServiceImpl implements TimeRangeService {

    @Autowired
    private TimeRangeDao timeRangeDao;

    @Override
    public List<TimeRangeVo> findList() {
        String hql = "select new " + TimeRangeVo.class.getName()
                + "(t.timeRangeId, t.startTime, t.endTime) " +
                " from TimeRangeEntity as t " +
                " where 1=1 " +
                " order by t.startTime";
        List<Object> params = new ArrayList<Object>();
        List<TimeRangeVo> list = this.timeRangeDao.findList(TimeRangeVo.class, hql, params);
        return list;
    }

    @Override
    public boolean addTimeRange(TimeRangeVo timeRangeVo) {
        try {
            TimeRangeEntity timeRangeEntity = new TimeRangeEntity();
            BeanUtils.copyProperties(timeRangeVo, timeRangeEntity);
            this.timeRangeDao.save(timeRangeEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteTimeRange(String timeRangeId) {
        try {
            this.timeRangeDao.deleteById(timeRangeId);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateTimeRange(TimeRangeVo timeRangeVo) {
        try {
            TimeRangeEntity timeRangeEntity = new TimeRangeEntity();
            BeanUtils.copyProperties(timeRangeVo, timeRangeEntity);
            this.timeRangeDao.update(timeRangeEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
