package com.hlfc.db.hibernate.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Repository("HBaseDao")
public class BaseDao<T,PK extends Serializable>
{
    // 泛型反射类
    private Class<T> entityClass;

    @Autowired
    protected HibernateTemplate ht;

    public Class<T>   getEntityClass() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        return  entityClass = (Class) params[0];
    }

    @Transactional
    public void add(T t)
    {
        ht.save(t);
    }

    public T getByID(PK pk)
    {

        return ht.get(getEntityClass(), pk);
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll()
    {
       return ht.loadAll(getEntityClass());
    }




    @Transactional
    public void update( T t)
    {
        ht.update(t);
    }

    @Transactional
    public void deleteById(PK pk)
    {
        T u = this.getByID(pk);
        ht.delete(u);
    }

}
