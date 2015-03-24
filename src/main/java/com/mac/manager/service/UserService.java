package com.mac.manager.service;

import com.mac.manager.vo.UserVo;

import java.util.List;

/**
 * Created by machao on 2015/3/12.
 */
public interface UserService {
    public UserVo getUserById(String uid);
    public boolean deleteUser(String uid);
    public boolean addUser(UserVo userVo);
    public boolean updateUser(UserVo userVo);

    public List<UserVo> findList();


    public boolean isExist(String propertyName, Object value);

    public String encryptPassword(String userName, String plainPassword);
}
