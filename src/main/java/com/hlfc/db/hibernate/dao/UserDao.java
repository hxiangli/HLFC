package com.hlfc.db.hibernate.dao;

import com.hlfc.db.hibernate.bean.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Auther: HXL
 * @Date: 2018/11/5 16:41
 */
@Repository("HUserDao")
public  class UserDao extends BaseDao<User,String>{

    public List<User> findByUserName(String userName){

//        Query query =  this.ht.getSessionFactory().openSession().createQuery("from User");
//        List<User>  users =  query.list();

        return (List<User>) this.ht.find("from User where name=?",userName);
    }
}
