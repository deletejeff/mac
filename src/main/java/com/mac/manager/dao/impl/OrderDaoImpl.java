package com.mac.manager.dao.impl;

import com.mac.manager.dao.OrderDao;
import com.mac.manager.dao.entity.OrderEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by machao on 2015/3/30.
 */
@Repository
public class OrderDaoImpl extends BaseDaoImpl<OrderEntity, String> implements OrderDao {
}
