package com.hlfc.db.mongodb.dao;

import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;
import com.hlfc.db.mongodb.bean.Flow;
import com.hlfc.db.mongodb.template.WorkflowConfigTemplate;

import java.util.List;

/**
 * 流程数据操作类11
 * @Auther: HXL
 * @Date: 2019/3/15 15:47
 */
public class FlowDao extends WorkflowConfigTemplate {
    /**
     * 构造函数
     */
    public FlowDao(){
        this.init();
        this.setBeanClass(Flow.class);
    }


    /**
     * 新增
     * @param flow
     * @return
     */
    public boolean save(Flow flow){
       return this.commonSave(flow);
    }


    /**
     * 更新
     * @param flow 修改的对象
     * @return
     */
    public boolean update(Flow flow){
        return this.commonUpdate(flow, null, null);
    }


    /**
     * 更新（局部更新）
     * @param unid 修改的对象标识
     * @param name 修改的属性
     * @return
     */
    public boolean updateNameByUnid(String unid , String name){
        Query<Flow> query = this.getDatastore().createQuery(Flow.class);
        query.field(DEFAULT_FIELD_UNID).equal(unid);
        UpdateOperations<Flow> ops = this.getDatastore().createUpdateOperations(Flow.class);
        ops.set("name", name);
        return this.commonUpdate(query, ops);
    }

    /**
     * 根据id删除
     * @param unid
     * @return
     */
    public boolean deleteById(String unid){
         return    this.commonDelete(unid, Flow.class);
    }


    /**
     * 根据名称删除
     * @param name
     * @return
     */
    public boolean deleteByName(String name){
        Query<Flow> query = this.getDatastore().createQuery(Flow.class);
        query.field("name").equal(name);

        return this.commonDelete(query);
    }


    /**
     * 根据id查询
     * @param unid
     * @return
     */
    public Flow get(String unid){
        return this.commonGet(unid);

    }


    /**
     * 根据名称查询
     * @return
     */
    public List<Flow> getByQuery(String name){
        Query<Flow> query = this.getDatastore().createQuery(Flow.class);
        query.field("name").equal(name);
        return query.asList();
    }

}
