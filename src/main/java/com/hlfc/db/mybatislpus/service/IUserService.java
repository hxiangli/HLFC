package com.hlfc.db.mybatislpus.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.hlfc.db.mybatislpus.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户服务层接口
 * Created by HXL on 2018/9/4.
 */
public interface IUserService extends IBaseService<User>{

    //根据用户名查询
     List<User> getByName(String name);

     //分页查询用户名
    Page<User> queryPageByNam(Page<User> rcPage,String name);

    //根据部门Id获取用户列表
    List<User> getUsersByDeptId(String deptId);

    //根据部门Id获取用户列表
    List<Map<String,Object>> getUsersAndDeptByDeptId(String deptId);

    //根据部门Id获取用户列表
    List<User> getDeptUsersByDeptId(String deptId);

}
