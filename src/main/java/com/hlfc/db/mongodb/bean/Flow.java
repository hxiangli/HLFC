package com.hlfc.db.mongodb.bean;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.hlfc.db.mongodb.template.bean.BeanEntity;

import java.util.List;

/**
 * 流程信息类
 * @Auther: HXL
 * @Date: 2019/3/15 15:33
 */
@Entity(noClassnameStored = true)
public class Flow extends BeanEntity {

    //流程名称
    private String name;

    @Embedded
    private List<FlowNode> nodes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlowNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<FlowNode> nodes) {
        this.nodes = nodes;
    }
}
