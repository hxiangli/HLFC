package com.hlfc.db.mybatislpus.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 用户实体类
 * Created by HXL on 2018/7/25.
 */

@TableName(value = "t_user")
public class User{

    /**
     * 主键ID
     */
    @TableId(value = "unid", type = IdType.ID_WORKER_STR)
    private String unid;

    @TableField("user_name")
    private String name;

    private String password;

    @TableField(exist = false)
    private String deptName;

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
