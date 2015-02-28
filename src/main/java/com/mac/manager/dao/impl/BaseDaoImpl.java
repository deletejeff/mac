package com.mac.manager.dao.impl;

import com.mac.common.bean.Page;
import com.mac.common.bean.Page.Offset;
import com.mac.common.bean.PageList;
import com.mac.manager.dao.BaseDao;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.query.spi.HQLQueryPlan;
import org.hibernate.engine.query.spi.QueryPlanCache;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: yangyan Date: 13-11-18 Time: 下午9:09 To
 * change this template use File | Settings | File Templates.
 *
 * @param <T>  对象类型
 * @param <PK> 对象主键类型
 */
@Repository
public abstract class BaseDaoImpl<T, PK extends Serializable> implements
        BaseDao<T, PK> {

    public static boolean JUNIT_TEST = false;
    protected SessionFactory sessionFactory;
    private Class<T> entityClass;

    protected BaseDaoImpl() {

        Class c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type)
                    .getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Session getCurrentSession() {
        //这里仅用于在JUNIT测试service 方法无法获得线程绑定的session的临时方法
        if (JUNIT_TEST) {
            return sessionFactory.openSession();
        } else { //这是正常获取session的方法
            Session s = sessionFactory.getCurrentSession();
            return s;
        }
    }

    @Override
    public T getById(PK id) {
        return (T) getCurrentSession().get(entityClass, id);
    }

    @Override
    public T loadById(PK id) {
        return (T) getCurrentSession().load(entityClass, id);
    }

    @Override
    public <T1> T1 getPropertyById(PK id, String propertyName, Class<T1> clazz) {
        return getUniqueResult(clazz, "select " + propertyName + " from " + entityClass.getName() + " where " + sessionFactory.getClassMetadata(this.entityClass).getIdentifierPropertyName() + "=?", id);
    }

    @Override
    public void save(T model) {
        getCurrentSession().save(model);
    }

    @Override
    public void saveOrUpdate(T model) {
        getCurrentSession().saveOrUpdate(model);
    }

    @Override
    public List<T> findListByProperty(String propertyName, Object value) {
        Query query = getCurrentSession().createQuery("from " + entityClass.getName() + " where " + propertyName + "=?");
        query.setParameter(0, value);
        return query.list();
    }

    @Override
    public void delete(T model) {
        getCurrentSession().delete(model);
    }

    @Override
    public void deleteById(PK... id) {
        for (int i = 0; i < id.length; i++) {
            Object load = getCurrentSession().load(entityClass, id[i]);
            getCurrentSession().delete(load);

        }
    }

    @Override
    public void update(T model) {
        getCurrentSession().update(model);
    }

    @Override
    public List<T> findAll() {
        return getCurrentSession().createCriteria(entityClass.getName()).list();
    }

    @Override
    public void deleteResultsByProperty(String propertyName, Object value) {
        Query query = getCurrentSession().createQuery("delete from " + entityClass.getName() + " where " + propertyName + "=?");
        query.setParameter(0, value);
        query.executeUpdate();
    }

    @Override
    public PageList<T> findByPage(Page page, String hql, List<Object> params) {
        Query q = getCurrentSession().createQuery(hql);
        if (page instanceof Offset) {
            q.setFirstResult(((Offset) page).getStart()).setMaxResults(
                    ((Offset) page).getLimit());
        } else {
            q.setFirstResult((page.getPage() - 1) * page.getPageSize())
                    .setMaxResults(page.getPageSize());
        }

        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                q.setParameter(i, params.get(i));
            }
        }
        page.setTotal(this.getTotalCount(hql, params));
        return new PageList<T>(page, q.list());
    }

    @Override
    public PageList<T> findByPage(Page page) {
        return this.findByPage(page, "from " + this.entityClass.getName(),
                Collections.EMPTY_LIST);
    }

    @Override
    public PageList<T> findByPage(Page page, String hql, Object... params) {
        return this.findByPage(page, hql, Arrays.asList(params));
    }

    @Override
    public void clear() {
        getCurrentSession().clear();
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }

    @Override
    public void evict(Object o) {
        getCurrentSession().evict(o);
    }

    @Override
    public boolean isExist(String propertyName, Object value) {
        String hql = "select count(*) from " + entityClass.getName()
                + " where " + propertyName + "=?";
        Query q = getCurrentSession().createQuery(hql);
        q.setParameter(0, value);
        return (Long) getCurrentSession().createQuery(hql)
                .setParameter(0, value).uniqueResult() > 0;
    }

    @Override
    public long getTotalCount() {
        String hql = "select count(*) from " + entityClass.getName();
        return Long.valueOf(getCurrentSession().createQuery(hql).uniqueResult()
                .toString());
    }

    @Override
    public long getTotalCount(String hql, List<Object> params) {
        Query q = getCurrentSession().createQuery(prepareCountHql(hql));
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                q.setParameter(i, params.get(i));
            }
        }
        return Long.valueOf(q.uniqueResult().toString());
    }

    @Override
    public long getTotalCount(String hql, Object... params) {
        return this.getTotalCount(hql,
                params == null ? null : Arrays.asList(params));
    }

    protected String prepareCountHql(String hql) {

        String fromHql = hql;

        fromHql = " from " + StringUtils.substringAfter(fromHql, "from ");

        fromHql = StringUtils.substringBefore(fromHql, "order by");

        int whereIndex = fromHql.indexOf("where");

        int leftIndex = fromHql.indexOf("left join");

        if (leftIndex >= 0) {

            if (whereIndex >= 0) {

                String temp = StringUtils.substringBefore(fromHql, "left");

                fromHql = temp + " where "
                        + StringUtils.substringAfter(fromHql, "where");

            } else {

                fromHql = StringUtils.substringBefore(fromHql, "left");

            }

        }

        String countHql = "select count(*) " + fromHql;

        return countHql;

    }

    protected String getCountSql(String originalHql,
                                 SessionFactory sessionFactory) {

        SessionFactoryImplementor sessionFactoryImplementor = (SessionFactoryImplementor) sessionFactory;

        HQLQueryPlan hqlQueryPlan = sessionFactoryImplementor
                .getQueryPlanCache().getHQLQueryPlan(originalHql, false,
                        Collections.emptyMap());

        String[] sqls = hqlQueryPlan.getSqlStrings();

        String countSql = "select count(*) from (" + sqls[0] + ") count";

        return countSql;

    }

    public SessionFactoryImplementor getSessionFactoryImplementor() {

        return (SessionFactoryImplementor) sessionFactory;

    }

    public QueryPlanCache getQueryPlanCache() {

        return getSessionFactoryImplementor().getQueryPlanCache();

    }

    public HQLQueryPlan getHqlQueryPlan(String hql) {

        return getQueryPlanCache().getHQLQueryPlan(hql, false,
                Collections.emptyMap());

    }

    protected String prepareCountSql(String sql) {
        return getCountSql(sql, sessionFactory);

    }

    @Override
    public <T> List<T> findList(Class<T> clazz, String hql, List<Object> params) {
        Query q = getCurrentSession().createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                q.setParameter(i, params.get(i));
            }
        }
        return q.list();
    }

    @Override
    public <T> List<T> findListLimit(Class<T> clazz, String hql, int limit,
                                     List<Object> params) {
        Query q = getCurrentSession().createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                q.setParameter(i, params.get(i));
            }
        }
        q.setFirstResult(0);
        q.setMaxResults(limit);
        return q.list();
    }

    @Override
    public T getUniqueResult(String hql, Object... params) {
        return getUniqueResult(this.entityClass, hql, params);
    }

    @Override
    public <T> T getUniqueResult(Class<T> clazz, String hql, List<Object> params) {
        Query q = getCurrentSession().createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                q.setParameter(i, params.get(i));
            }
        }
        q.setFirstResult(0);
        q.setMaxResults(1);
        List list = q.list();
        if (list == null || list.isEmpty() || list.get(0) == null) {
            return null;
        }
        return (T) list.get(0);
    }

    @Override
    public <T> List<T> findList(Class<T> clazz, String hql, Object... params) {
        return this.findList(clazz, hql,
                params == null ? null : Arrays.asList(params));
    }

    @Override
    /**
     * 用给定的HQL和参数查询前几条给定类型的数据列表
     * @param clazz
     * @param hql
     * @param limit
     * @param params
     * @return
     */
    public <T> List<T> findListLimit(Class<T> clazz, String hql, int limit,
                                     Object... params) {
        return this.findListLimit(clazz, hql, limit, params == null ? null
                : Arrays.asList(params));
    }

    @Override
    public <T> PageList<T> findPageList(Page page, Class<T> clazz, String hql,
                                        Object... params) {
        return findPageList(page, clazz, hql, Arrays.asList(params));
    }

    @Override
    public <T> PageList<T> findPageList(Page page, Class<T> clazz, String hql,
                                        List<Object> params) {
        Query q = getCurrentSession().createQuery(hql);
        if (page instanceof Offset) {
            q.setFirstResult(((Offset) page).getStart()).setMaxResults(
                    ((Offset) page).getLimit());
        } else {
            q.setFirstResult((page.getPage() - 1) * page.getPageSize())
                    .setMaxResults(page.getPageSize());
        }
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                q.setParameter(i, params.get(i));
            }
        }
        page.setTotal(this.getTotalCount(hql, params));
        return new PageList<T>(page, q.list());

    }

    @Override
    public T getUniqueResultByProperty(String propertyName, Object value) {
        return this.getUniqueResult("from " + this.entityClass.getName()
                + " where " + propertyName + "=?", value);
    }

    @Override
    public <T> T getUniqueResult(Class<T> clazz, String hql, Object... params) {
        return this.getUniqueResult(clazz, hql,
                params == null ? null : Arrays.asList(params));
    }

    @Override
    public void execute(String hql, List<Object> params) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                q.setParameter(i, params.get(i));
            }
        }
        q.executeUpdate();
    }

    @Override
    public void execute(String hql, Object... params) {
        this.execute(hql, params == null ? null : Arrays.asList(params));
    }

    @Override
    public void updateProperty(PK id, String propertyName, Object status) {
        String hql = "update " + this.entityClass.getName() + " set " + propertyName + " = ? where " + sessionFactory.getClassMetadata(this.entityClass).getIdentifierPropertyName() + "= ?";
        this.execute(hql, status, id);
    }

    @Override
    public void incr(PK id, String propertyName) {
        String hql = "update " + this.entityClass.getName() + " set " + propertyName + " = " + propertyName + "+1 where " + sessionFactory.getClassMetadata(this.entityClass).getIdentifierPropertyName() + "= ?";
        this.execute(hql, id);
    }

    @Override
    public void incr(PK id, String propertyName, Integer n) {
        String hql = "update " + this.entityClass.getName() + " set " + propertyName + " = " + propertyName + "+1 where " + sessionFactory.getClassMetadata(this.entityClass).getIdentifierPropertyName() + "= ?";
        this.execute(hql, id, n);
    }
}
