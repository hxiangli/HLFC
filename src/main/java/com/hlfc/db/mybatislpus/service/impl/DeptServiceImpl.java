package com.hlfc.db.mybatislpus.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hlfc.db.mybatislpus.bean.Dept;
import com.hlfc.db.mybatislpus.bean.User;
import com.hlfc.db.mybatislpus.dao.DeptDao;
import com.hlfc.db.mybatislpus.dao.UserDao;
import com.hlfc.db.mybatislpus.service.IDeptService;
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
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private DeptDao deptDao;


    @Override
    public User getById(String id) {
        return deptDao.selectById(id);
    }

    @Override
    public boolean removeById(String id) {
        return deptDao.deleteById(id)>0?true:false;
    }

    @Override
    public boolean updateById(User o) {
        return deptDao.updateById(o)>0?true:false;
    }

    @Override
    public List<User> queryAll() {
        return null;
    }

    @Override
    public boolean save(User o) {
        return deptDao.insert(o)>0?true:false;
    }

    @Override
    public List<Dept> getDeptUsersByName(String deptName) {
        return deptDao.getDeptUsersByName(deptName);
    }
}
