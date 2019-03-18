package com.hlfc.db.mongodb.template;

import com.hlfc.db.mongodb.template.bean.MongoDBConfig;
import com.hlfc.db.mongodb.template.bean.MongoDBOptions;
import com.hlfc.db.mongodb.template.bean.MongoDBPool;
import com.hlfc.db.mongodb.template.bean.MongoDbUtils;
import com.hlfc.util.EnvironmentUtil;
import com.hlfc.util.PropertyUtil;

import java.net.UnknownHostException;

/**
 * 对外提供的MongoDb管理
 * @author yjianyou@linewell.com
 * @since  Jul 20, 2012
 */
class WorkflowMongoDBPoolManager {
	
	// MongoDB连接池对象
	private static MongoDBPool mongoDBPool = null;
	
	// 工作流默认配置别名
	private static final String WORKFLOW_CONFIG_ALIAS = "workflowConfig"; 
	
	/**
	 * 构造私有
	 */
	private WorkflowMongoDBPoolManager(){
		
	}
	
	/**
	 * 获取MongoDB连接池对象
	 * @return MongoDB连接池对象
	 */
	public static MongoDBPool getMongoDBPool() {
		if(mongoDBPool==null){
			init();
		}
		return mongoDBPool;
	}

    /**
     * 获取mongodb配置
	 * @return
     */
	private static MongoDBConfig getConfig(){
		MongoDBConfig mongodbConfig = new MongoDBConfig();

		//构造mongodb配置
		PropertyUtil pb =  PropertyUtil.getInstance(EnvironmentUtil.getInstance().getWebInfPath()+"/properties/db.properties");
		mongodbConfig.setAlias(pb.getValue("mongo.alias"));
		mongodbConfig.setAddress(pb.getValue("mongo.address"));
		mongodbConfig.setPort(pb.getValue("mongo.port"));
		mongodbConfig.setDbname(pb.getValue("mongo.dbname"));
		mongodbConfig.setNeedAuth(Boolean.parseBoolean(pb.getValue("mongo.needAuth")));
		mongodbConfig.setReplicaSetSeeds(pb.getValue("mongo.replicaSetSeeds"));
		mongodbConfig.setUsername(pb.getValue("mongo.username"));
		mongodbConfig.setPassword(pb.getValue("mongo.password"));

		MongoDBOptions options = new MongoDBOptions();
		options.setConnectionsPerHost(Integer.parseInt(pb.getValue("mongo.connectionsPerHost")));
		options.setThreadsAllowedToBlockForConnectionMultiplier(Integer.parseInt(pb.getValue("mongo.threadsAllowedToBlockForConnectionMultiplier")));
		options.setMaxWaitTime(Integer.parseInt(pb.getValue("mongo.maxWaitTime")));
		options.setSocketTimeout(Integer.parseInt(pb.getValue("mongo.socketTimeout")));
		options.setConnectTimeout(Integer.parseInt(pb.getValue("mongo.connectTimeout")));
		options.setAutoConnectRetry(Boolean.parseBoolean(pb.getValue("mongo.autoConnectRetry")));
		options.setSocketKeepAlive(Boolean.parseBoolean(pb.getValue("mongo.socketKeepAlive")));

		options.setRequiredReplicaSetName(mongodbConfig.getReplicaSetSeeds());
		mongodbConfig.setOptions(options);
		return mongodbConfig;
	}



	/**
	 * 初始化
	 */
	private  static void init() {
		MongoDBConfig mongoDBConfig = getConfig();
		if(null!= mongoDBConfig){
			setMongoDBPool(mongoDBConfig);
		}
	}
	
	/**
	 * 获取MongoDB
	 * @return
	 */
	private static void setMongoDBPool(MongoDBConfig  mongodbConfig) {
			try {
				mongoDBPool = MongoDbUtils.cretateMongodb(mongodbConfig);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
	}
}