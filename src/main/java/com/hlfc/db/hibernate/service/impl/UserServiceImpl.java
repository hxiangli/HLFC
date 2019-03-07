package com.hlfc.db.hibernate.service.impl;

import com.hlfc.db.hibernate.bean.User;
import com.hlfc.db.hibernate.dao.UserDao;
import com.hlfc.db.hibernate.service.IUserService;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: HXL
 * @Date: 2018/11/5 16:13
 */
@Service("HService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getById(String id) {
        return userDao.getByID(id);
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    @Override
    public boolean updateById(User o) {
        return false;
    }

    @Override
    public List<User> queryAll() {
        return null;
    }

    @Override
    public boolean save(User o) {
        return false;
    }

    @Override
    public List<User> findByUserName(String userName) {
        return  userDao.findByUserName(userName);
    }
}
