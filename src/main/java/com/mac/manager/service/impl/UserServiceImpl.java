package com.mac.manager.service.impl;

import com.mac.manager.dao.UserDao;
import com.mac.manager.dao.entity.UserEntity;
import com.mac.manager.service.UserService;
import com.mac.manager.vo.UserVo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by machao on 2015/3/12.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserVo> findList() {
        String hql = "select new " +UserVo.class.getName()
                + "("
                + "u.uid,u.userName,u.userPassword,u.userEmail,u.nickname,u.openId,"
                + "u.realName,u.phone,u.gender,u.status,u.lastLoginIp,u.superman,u.createdAt,"
                + "u.createdByUserId,u.headImgUrl" +
                ") from UserEntity as u where 1=1 and u.superman<>1 order by u.createdAt desc";
        List<Object> params = new ArrayList<Object>();
        List<UserVo> list = this.userDao.findList(UserVo.class, hql, params);
        return list;
    }

    @Override
    public boolean isExist(String propertyName, Object value) {
        return this.userDao.isExist(propertyName, value);
    }

    @Override
    public UserVo getUserById(String uid) {
        String hql = "select new "
                + UserVo.class.getName()
                + "("
                + "u.uid,u.userName,u.userPassword,u.userEmail,u.nickname,u.openId,"
                + "u.realName,u.phone,u.gender,u.status,u.lastLoginIp,u.superman,u.createdAt,"
                + "u.createdByUserId,u.headImgUrl" +
                ") from UserEntity as u where u.uid = ?";
        return this.userDao.getUniqueResult(UserVo.class, hql, uid);
    }

    @Override
    public boolean deleteUser(String uid) {
        try {
            this.userDao.deleteById(uid);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean addUser(UserVo userVo) {
        try {
            userVo.setSuperman(0);
            userVo.setStatus(1);
            userVo.setUserPassword(this.encryptPassword(userVo.getUserName(), userVo.getUserPassword()));
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userVo, userEntity);
            userEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            this.userDao.save(userEntity);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUser(UserVo userVo){
        try {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userVo, userEntity);
            userEntity.setCreatedAt(new Timestamp(userVo.getCreatedAt().getTime()));
            this.userDao.update(userEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String encryptPassword(String userName, String plainPassword) {
        return DigestUtils.md5Hex(userName + plainPassword + userName);
    }

}
