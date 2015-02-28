package com.mac.manager.dao;

import com.mac.common.bean.Page;
import com.mac.common.bean.PageList;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * hibernate 数据操作通实现接口
 *
 * @param <T>  对象类型
 * @param <PK> 对象的主键类型
 */
public interface BaseDao<T, PK extends Serializable> {

    /**
     * 用主键查询
     *
     * @param id
     * @return
     */
    public T getById(PK id);

    /**
     * load by id
     *
     * @param id
     * @return
     */
    public T loadById(PK id);

    /**
     * 根据主键查询某个属性
     *
     * @param id
     * @param propertyName
     * @param clazz
     * @return
     */
    <T> T getPropertyById(PK id, String propertyName, Class<T> clazz);

    /**
     * 保存
     *
     * @param model
     */
    public void save(T model);

    /**
     * 添加或更新
     *
     * @param model
     */
    public void saveOrUpdate(T model);

    /**
     * 删除
     *
     * @param model
     */
    public void delete(T model);

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(PK... id);

    /**
     * 执行hql，不返回结果，如果需要返回结果，请直接使用session
     *
     * @param hql
     * @param params
     */
    public void execute(String hql, List<Object> params);

    /**
     * 执行hql，不返回结果，如果需要返回结果，请直接使用session
     *
     * @param hql
     * @param params
     */
    public void execute(String hql, Object... params);

    /**
     * 将某个数字类型的属性值更新+1
     *
     * @param id           主键
     * @param propertyName 自增+1的属性名
     */
    public void incr(PK id, String propertyName);

    /**
     * 将某个数值类型的属性值更新 +N
     *
     * @param id           主键
     * @param propertyName 自增+n的属性名
     * @param n            增量
     */
    public void incr(PK id, String propertyName, Integer n);

    /**
     * 更新到数据库
     *
     * @param model
     */
    public void update(T model);

    /**
     * 更新状态属性
     *
     * @param id
     * @param propertyName
     * @param status
     */
    public void updateProperty(PK id, String propertyName, Object status);

    /**
     * 查询所有
     *
     * @return
     */
    public List<T> findAll();

    /**
     * 根据某个属性值查询
     *
     * @param properName
     * @param value
     * @return
     */
    public List<T> findListByProperty(String properName, Object value);


    /**
     * 用给定的HQL和参数查询给定类型的数据列表
     *
     * @param <T>
     * @param clazz
     * @param hql
     * @param params
     * @return
     */
    public <T> List<T> findList(Class<T> clazz, String hql, List<Object> params);

    /**
     * 用给定的HQL和参数查询给定类型的数据列表
     *
     * @param <T>
     * @param clazz
     * @param hql
     * @param params
     * @return
     */
    public <T> List<T> findList(Class<T> clazz, String hql, Object... params);

    /**
     * 用给定的HQL和参数查询前几条给定类型的数据列表
     *
     * @param clazz
     * @param hql
     * @param limit
     * @param params
     * @return
     */
    public <T> List<T> findListLimit(Class<T> clazz, String hql, int limit,
                                     List<Object> params);

    /**
     * 用给定的HQL和参数查询前几条给定类型的数据列表
     *
     * @param clazz
     * @param hql
     * @param limit
     * @param params
     * @return
     */
    public <T> List<T> findListLimit(Class<T> clazz, String hql, int limit,
                                     Object... params);

    /**
     * 用给定的HQL和参数查询分页给定类型的数据列表
     *
     * @param page   分页对象
     * @param clazz  返回对象的类型
     * @param hql    HQL
     * @param params HQL 参数
     * @return
     */
    public <T> PageList<T> findPageList(Page page, Class<T> clazz, String hql,
                                        Object... params);

    /**
     * 用给定的HQL和参数查询分页给定类型的数据列表
     *
     * @param page
     * @param clazz
     * @param hql
     * @param params
     * @return
     */
    public <T> PageList<T> findPageList(Page page, Class<T> clazz, String hql,
                                        List<Object> params);


    /**
     * 根据唯一的属性值返回单条数据
     *
     * @param propertyName
     * @param value
     * @return
     */
    public T getUniqueResultByProperty(String propertyName, Object value);

    /**
     * 删除匹配此属性的所有记录
     *
     * @param propertyName
     * @param value
     */
    public void deleteResultsByProperty(String propertyName, Object value);

    /**
     * 返回单条数据
     *
     * @param hql
     * @param params
     * @return
     */
    public T getUniqueResult(String hql, Object... params);

    /**
     * 用给定的HQL和参数查询给定类型的唯一一条数据
     *
     * @param <T>
     * @param clazz
     * @param hql
     * @param params
     * @return
     */
    public <T> T getUniqueResult(Class<T> clazz, String hql, List<Object> params);

    /**
     * 用给定的HQL和参数查询给定类型的唯一一条数据
     *
     * @param <T>
     * @param clazz
     * @param hql
     * @param params
     * @return
     */
    public <T> T getUniqueResult(Class<T> clazz, String hql, Object... params);

    /**
     * 使用给定的HQL分页查询
     *
     * @param page
     * @param hql
     * @param params
     * @return
     */
    public PageList<T> findByPage(Page page, String hql, List<Object> params);

    /**
     * 使用给定的HQL分页查询
     *
     * @param page
     * @param hql
     * @param params
     * @return
     */
    public PageList<T> findByPage(Page page, String hql, Object... params);

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    public PageList<T> findByPage(Page page);

    /**
     * 刷新当前session的操作
     */
    public void flush();

    /**
     * 清除当前session的缓存和状态
     */
    public void clear();

    /**
     * 将持久化对象脱离session
     *
     * @param o
     */
    public void evict(Object o);

    /**
     * 查询指定属性值的记录是否存在
     *
     * @param propertyName
     * @param value
     * @return
     */
    public boolean isExist(String propertyName, Object value);

    /**
     * 查询总条数
     *
     * @return
     */
    public long getTotalCount();

    /**
     * 查询给定HQL和参数查询结果的总条数
     *
     * @param hql
     * @param params
     * @return
     */
    public long getTotalCount(String hql, List<Object> params);

    /**
     * 查询给定HQL和参数查询结果的总条数
     *
     * @param hql
     * @param params
     * @return
     */
    public long getTotalCount(String hql, Object... params);

    /**
     * 获取当前的Session
     *
     * @return
     */
    public Session getCurrentSession();

}
