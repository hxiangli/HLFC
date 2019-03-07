package com.hlfc.db.hibernate.service;

import com.hlfc.db.hibernate.bean.User;

import java.util.List;

/**
 * @Auther: HXL
 * @Date: 2018/11/5 16:11
 */
public interface IUserService extends IBaseService<User> {

    public List<User> findByUserName(String userName);
}
