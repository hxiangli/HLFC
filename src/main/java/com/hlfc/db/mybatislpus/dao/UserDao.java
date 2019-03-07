package com.hlfc.db.mybatislpus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hlfc.db.mybatislpus.bean.User;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

/**
 * 数据操作层
 * Created by HXL on 2018/9/4.
 */
@MapperScan
public interface UserDao extends BaseMapper<User> {

    List<User> getUsersByDeptId(@Param("deptId") String deptId);

    //根据部门Id获取用户列表
    // Param
    List<Map<String,Object>> getUsersAndDeptByDeptId(@Param("deptId") String deptId);

    //根据部门Id获取用户列表
    // Param
    List<User> getDeptUsersByDeptId(@Param("deptId") String deptId);
}
