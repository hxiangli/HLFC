package com.hlfc.db.mybatislpus.service;

import java.util.List;

/**
 * 通用接口服务层
 * Created by HXL on 2018/9/4.
 */
public interface IBaseService<T> {

    /**
     * 根据主键Id查询
     * @param id 主键Id
     * @return T
     * @date 2018年7月13日10:31:55
     * @author ChenMingsen
     */
    public T getById(String id);

    /**
     * 根据Id 删除
     * @param id
     * @date 2018年7月13日10:32:36
     * @author ChenMingsen
     */
    public boolean removeById(String id);

    /**
     * 更新整个对象
     * @param o
     * @date 2018年7月13日10:33:06
     * @author ChenMingsen
     */
    public boolean updateById(T o);

    /**
     * 查询全部
     * @return List<T>
     * @date 2018年7月13日10:33:28
     * @author ChenMingsen
     */
    public List<T> queryAll();

    /**
     * 保存
     * @param o
     * @date 2018年7月13日10:33:42
     * @author ChenMingsen
     */
    public boolean save(T o);
}
