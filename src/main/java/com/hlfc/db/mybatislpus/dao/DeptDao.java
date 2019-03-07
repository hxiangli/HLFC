package com.hlfc.db.mybatislpus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hlfc.db.mybatislpus.bean.Dept;
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
public interface DeptDao extends BaseMapper<User> {


    //根据部门名称获取部门与用户数据
    // Param
    List<Dept> getDeptUsersByName(@Param("deptName") String deptName);
}
