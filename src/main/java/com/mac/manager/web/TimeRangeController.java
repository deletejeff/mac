package com.mac.manager.web;

import com.mac.manager.service.TimeRangeService;
import com.mac.manager.vo.TimeRangeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by machao on 2015/3/30.
 */
@Controller
@RequestMapping("/time_range")
public class TimeRangeController {
    @Autowired
    private TimeRangeService timeRangeService;

    @RequestMapping("/list_manager.do")
    public String findList(ModelMap map, String msg){
        List<TimeRangeVo> list = this.timeRangeService.findList();
        if(list != null){
            map.put("list", list);
            map.put("msg", msg);
            map.put("success",true);
        }else{
            map.put("msg", msg);
            map.put("success", false);
        }
        return "manager/manager_time_range";
    }

    @RequestMapping(value = "/add.do" ,method = RequestMethod.GET)
    public String addTimeRange(){
        return "manager/time_range_add";
    }

    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public String addTimeRange(TimeRangeVo timeRangeVo){
        String msg = "";
        try {
            this.timeRangeService.addTimeRange(timeRangeVo);
            msg = "add:success";
        } catch (Exception e) {
            msg = "add:failure";
        }
        return "redirect:list_manager.do?msg="+msg;
    }

    @RequestMapping("/delete.do")
    public String deleteTimeRange(String timeRangeId){
        String msg = "";
        try {
            this.timeRangeService.deleteTimeRange(timeRangeId);
            msg = "delete:success";
        } catch (Exception e) {
            msg = "delete:failure";
        }
        return "redirect:list_manager.do?msg="+msg;
    }

    @RequestMapping(value = "/update.do",method = RequestMethod.GET)
    public String updateTimeRange(ModelMap map, String timeRangeId){
        map.put("timeRangeVo", this.timeRangeService.getById(timeRangeId));
        return "manager/time_range_update";
    }

    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    public String updateTimeRange(TimeRangeVo timeRangeVo){
        String msg = "";
        try {
            this.timeRangeService.updateTimeRange(timeRangeVo);
            msg = "update:success";
        } catch (Exception e) {
            msg = "update:failure";
        }
        return "redirect:list_manager.do?msg="+msg;
    }

}
