package com.mac.manager.service.impl;

import com.mac.manager.dao.UserDao;
import com.mac.manager.dao.entity.UserEntity;
import com.mac.manager.service.UserService;
import com.mac.manager.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by machao on 2015/3/12.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserVo getUserById(Integer uid) {
        String hql = "select new "
                + UserVo.class.getName()
                + "("
                + "u.uid,u.userName,u.userPassword,u.userEmail,u.nickname,u.openId,"
                + "u.realName,u.phone,u.gender,u.status,u.lastLoginIp,u.superman,u.createdAt,"
                + "u.createdByUserId" +
                ") from UserEntity as u where u.uid = ?";
        return this.userDao.getUniqueResult(UserVo.class, hql, uid);
    }

    public boolean deleteUser(String uid) {
        try {
            this.userDao.deleteById(uid);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    
    public boolean addUser(UserVo userVo) {
        try {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userVo, userEntity);
            this.userDao.save(userEntity);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
