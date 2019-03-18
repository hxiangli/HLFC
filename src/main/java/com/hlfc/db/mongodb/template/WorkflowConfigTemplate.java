package com.hlfc.db.mongodb.template;

import com.google.code.morphia.Datastore;
import com.hlfc.db.mongodb.template.bean.MongoDBPool;

/**
 * 流程配置的mongodb的基本模板
 * @author xhuatang
 * @since 2014年10月9日
 */
public abstract class WorkflowConfigTemplate extends MongoDbBaseTemplate {

	/**
	 * 共享数据库的初始化 CcipConfigDB
	 */
	protected void init() {
		MongoDBPool manageCcip = WorkflowMongoDBPoolManager.getMongoDBPool();
		Datastore datastore = manageCcip.getDatastore();
		this.setDatastore(datastore);
	}
	
	/**
	 * 重连
	 */
	protected void reConnect() {
		init();
	}
}
