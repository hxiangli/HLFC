package com.hlfc.db.mongodb.bean;

import java.io.Serializable;

/**
 * 流程节点信息
 * @Auther: HXL
 * @Date: 2019/3/15 15:40
 */
public class FlowNode  implements Serializable {
    // 节点标识
    private String unid;

    /**
     * 节点名称
     */
    private String name;


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
}
