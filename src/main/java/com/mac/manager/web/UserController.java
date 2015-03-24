package com.mac.manager.web;

import com.mac.manager.service.UserService;
import com.mac.manager.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * Created by machao on 2015/3/23.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list_manager.do")
    public String findList(ModelMap map, String msg){
        List<UserVo> list = this.userService.findList();
        if(list != null){
            map.put("list", list);
            map.put("msg", msg);
            map.put("success",true);
        }else{
            map.put("msg", msg);
            map.put("sucess", false);
        }
        return "/manager/manager_user";
    }

    @RequestMapping(value = "/add.do", method = RequestMethod.GET)
    public String addUser(){
        return "/manager/user_add";
    }

    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public String addUser(UserVo userVo){
        String msg = "";
        try {
            boolean exist = this.userService.isExist("userName", userVo.getUserName());
            if(exist){
                msg = "add:exist";
                return "redirect:list_manager.do?msg="+msg;
            }
            this.userService.addUser(userVo);
            msg = "add:success";
        } catch (Exception e) {
            msg = "add:failure";
        }
        return "redirect:list_manager.do?msg="+msg;
    }

    @RequestMapping("/delete.do")
    public String deleteUser(String uid){
        String msg = "";
        try {
            this.userService.deleteUser(uid);
            msg = "delete:success";
        } catch (Exception e) {
            msg = "delete:failure";
        }
        return "redirect:list_manager.do?msg="+msg;
    }

    @RequestMapping(value = "/update.do",method = RequestMethod.GET)
    public String updateUser(ModelMap map, String uid){
        map.put("userVo", this.userService.getUserById(uid));
        return "/manager/user_update";
    }

    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    public String updateUser(UserVo userVo){
        String msg = "";
        try {
            this.userService.updateUser(userVo);
            msg = "update:success";
        } catch (Exception e) {
            msg = "update:failure";
        }
        return "redirect:list_manager.do?msg="+msg;
    }
}
