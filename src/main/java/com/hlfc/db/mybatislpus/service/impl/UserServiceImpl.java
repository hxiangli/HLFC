package com.hlfc.db.mybatislpus.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hlfc.db.mybatislpus.bean.User;
import com.hlfc.db.mybatislpus.dao.UserDao;
import com.hlfc.db.mybatislpus.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户服务实现层
 * Created by HXL on 2018/9/4.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User getById(String id) {
        return userDao.selectById(id);
    }

    @Override
    public boolean removeById(String id) {
        return userDao.deleteById(id)>0?true:false;
    }

    @Override
    public boolean updateById(User o) {
        return userDao.updateById(o)>0?true:false;
    }

    @Override
    public List<User> queryAll() {
        return null;
    }

    @Override
    public boolean save(User o) {
        return userDao.insert(o)>0?true:false;
    }

    @Override
    public List<User> getByName(String name) {
        name = "你好";
        EntityWrapper<User> query = new EntityWrapper<User>();
        if(StringUtils.isNotBlank(name)){
            query.eq("user_name", name);
        }
        List<User> users = userDao.selectList(query);

        return users;
    }

    @Override
    public Page<User> queryPageByNam(Page<User> rcPage,String name) {
        //分页查询
        EntityWrapper<User> entity = new EntityWrapper<User>();
        entity.eq("user_name",name);
        rcPage.setRecords(userDao.selectPage(rcPage,entity));
        return rcPage;
    }

    @Override
    public List<User> getUsersByDeptId(String deptId) {

        return userDao.getUsersByDeptId(deptId);
    }

    @Override
    public List<Map<String,Object>> getUsersAndDeptByDeptId(String deptId) {

        return userDao.getUsersAndDeptByDeptId(deptId);
    }

    @Override
    public List<User> getDeptUsersByDeptId(String deptId) {
        return userDao.getDeptUsersByDeptId(deptId);
    }
}
