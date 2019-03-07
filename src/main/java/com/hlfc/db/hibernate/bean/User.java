package com.hlfc.db.hibernate.bean;

import javax.persistence.*;

/**
 * 用户实体类
 * Created by HXL on 2018/7/25.
 */

@Entity
@Table(name = "t_user")
public class User {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue
    private String unid;

    @Column(name = "user_name")
    private String name;

    @Column
    private String password;

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
