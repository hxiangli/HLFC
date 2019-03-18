package com.hlfc.db.mongodb;

import com.hlfc.db.mongodb.bean.Flow;
import com.hlfc.db.mongodb.bean.FlowNode;
import com.hlfc.db.mongodb.dao.FlowDao;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: HXL
 * @Date: 2019/3/15 16:19
 */
public class HTest {

    @Test
    public void get(){
        FlowDao flowDao = new FlowDao();
        Flow flow = flowDao.get("66AD5FA55138DE2D3387EF7C5BAB546C");
        System.out.println(flow.getName());
    }

    @Test
    public void getByName(){
        FlowDao flowDao = new FlowDao();
        List<Flow> flows = flowDao.getByQuery("新建流程研发");
        System.out.println(flows.size());
    }

    @Test
    public void save(){
        Flow flow = new Flow();
        flow.setUnid("123123");
        flow.setName("流程测试001");
        FlowNode flowNode = new FlowNode();
        flowNode.setUnid("2323");
        flowNode.setName("节点001");
        List<FlowNode> flowNodes = new ArrayList<FlowNode>();
        flowNodes.add(flowNode);
        flow.setNodes(flowNodes);

        FlowDao flowDao = new FlowDao();
        flowDao.save(flow);
    }


    @Test
    public void updateName(){
        FlowDao flowDao = new FlowDao();
        flowDao.updateNameByUnid("123123", "流程测试003");
    }

    @Test
    public void update(){
        FlowDao flowDao = new FlowDao();
        Flow flow = new Flow();
        flow.setUnid("123123");
        flow.setName("流程测试002");

//        FlowNode flowNode = new FlowNode();
//        flowNode.setUnid("232323");
//        flowNode.setName("节点0003");
//        List<FlowNode> flowNodes = new ArrayList<FlowNode>();
//        flowNodes.add(flowNode);
        flow.setNodes(null);

        flowDao.update(flow);
    }

    @Test
    public void delete(){
        FlowDao flowDao = new FlowDao();
        flowDao.deleteById("123123");
    }



    @Test
    public void deleteByName(){
        FlowDao flowDao = new FlowDao();
        flowDao.deleteByName("流程测试002");
    }

}
