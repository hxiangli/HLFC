package com.hlfc.db.mybatislpus.service;

import com.hlfc.db.mybatislpus.bean.Dept;
import com.hlfc.db.mybatislpus.bean.User;

import java.util.List;
import java.util.Map;

/**
 * 用户服务层接口
 * Created by HXL on 2018/9/4.
 */
public interface IDeptService extends IBaseService<User>{

    //根据部门名称获取部门与用户数据
    // Param
    List<Dept> getDeptUsersByName(String deptName);

}
