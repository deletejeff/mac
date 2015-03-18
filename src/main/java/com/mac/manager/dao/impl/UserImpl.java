package com.mac.manager.dao.impl;

import com.mac.manager.dao.UserDao;
import com.mac.manager.dao.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by machao on 2015/3/12.
 */
@Repository
public class UserImpl extends BaseDaoImpl<UserEntity, String> implements UserDao {
}
