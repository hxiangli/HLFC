package com.hlfc.db.mongodb.template.bean;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.*;
import org.apache.commons.lang.StringUtils;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MongoDb的工具类
 * @author yjianyou@linewell.com
 * @since  Nov 27, 2012
 */
public class MongoDbUtils {

	/**
	 * 转换为MongoDB的属性配置
	 *
	 * @param dbOptions 自定义的属性配置
	 * @return MongoDB的属性配置
	 */
	public static MongoClientOptions toMongoOptions(MongoDBOptions dbOptions) {
		MongoClientOptions.Builder optionsBuilder = new MongoClientOptions.Builder();
		optionsBuilder.socketTimeout(dbOptions.getConnectTimeout());
		optionsBuilder.socketKeepAlive(dbOptions.isSocketKeepAlive());
		optionsBuilder.connectionsPerHost(dbOptions.getConnectionsPerHost());
		optionsBuilder.description(dbOptions.getDescription());
		optionsBuilder.connectTimeout(dbOptions.getConnectTimeout());
		//add by jly 2017-07-26 增加副本集名称
		String requiredReplicaSetName = dbOptions.getRequiredReplicaSetName();
		if (StringUtils.isNotBlank(requiredReplicaSetName)) {//空字符串不能通过，否则未设置副本集启动会报错
			optionsBuilder.requiredReplicaSetName(requiredReplicaSetName);
		}

		// 读取类型
		String readPreference = dbOptions.getReadPreference();
		if (StringUtils.isEmpty(readPreference)) {
			readPreference = "";
		}

		readPreference = readPreference.toLowerCase();

		// 就近读取
		if ("nearest".equalsIgnoreCase(readPreference)) {
			optionsBuilder.readPreference(ReadPreference.nearest());
		} else if ("secondary".equals(readPreference)) {// 从从属服务器读取
			optionsBuilder.readPreference(ReadPreference.secondary());
		} else if ("primarypreferred".equals(readPreference)) {// 优先从主服务器读取
			optionsBuilder.readPreference(ReadPreference.primaryPreferred());
		} else if ("secondarypreferred".equals(readPreference)) {// 优先从从服务器读取
			optionsBuilder.readPreference(ReadPreference.secondaryPreferred());
		} else {// 从主服务器读取
			optionsBuilder.readPreference(ReadPreference.primary());
		}
		optionsBuilder.cursorFinalizerEnabled(dbOptions.isCursorFinalizerEnabled());
		optionsBuilder.maxWaitTime(dbOptions.getMaxWaitTime());
		optionsBuilder.threadsAllowedToBlockForConnectionMultiplier(dbOptions.getThreadsAllowedToBlockForConnectionMultiplier());
		return optionsBuilder.build();
//		options.setFsync(dbOptions.isFsync());
//		options.setJ(dbOptions.isJ());
//		options.setMaxAutoConnectRetryTime(dbOptions.getMaxAutoConnectRetryTime());
//		options.setMaxWaitTime(dbOptions.getMaxWaitTime());

//		options.setSafe(dbOptions.isSafe());
//		options.setSocketKeepAlive(dbOptions.isSocketKeepAlive());
//		options.setSocketTimeout(dbOptions.getSocketTimeout());
//		options.setWtimeout(dbOptions.getWtimeout());

//		return options;
	}

	/**
	 * 创建连接池
	 *
	 * @param mongoCfg 配置对象
	 * @return CcipMorphia
	 * @throws NumberFormatException
	 * @throws UnknownHostException
	 * @throws MongoException
	 * @throws
	 */
	public static MongoDBPool cretateMongodb(MongoDBConfig mongoCfg) throws NumberFormatException, UnknownHostException, MongoException {

		MongoDBPool ccipM = new MongoDBPool();

		// 2013-04-11 add by xhuatang
		// 添加集群的配置，可以设置多个IP地址多个端口号
		String[] addresses = mongoCfg.getAddress().split(",");
		String[] ports = mongoCfg.getPort().split(",");


		MongoClient mongoClient = null;
		MongoCredential credential = null;

		// 如果需要验证，添加库的验证信息
		if (mongoCfg.isNeedAuth()) {

			// 添加验证票据
			credential = MongoCredential.createMongoCRCredential(mongoCfg.getUsername(),
					mongoCfg.getDbname(), mongoCfg.getPassword().toCharArray());
		}

		MongoClientOptions options = toMongoOptions(mongoCfg.getOptions());
		if (addresses.length == 1) {
			ServerAddress mongoServerAddress = new ServerAddress(mongoCfg.getAddress(), Integer.parseInt(mongoCfg.getPort()));

			if (null == credential) {
				mongoClient = new MongoClient(mongoServerAddress, options);
			} else {
				mongoClient = new MongoClient(mongoServerAddress, Arrays.asList(credential), options);
			}
			// mongo = new Mongo(mongoServerAddress, options);
		} else {
			List<ServerAddress> listServerAddress = new ArrayList<ServerAddress>();
			for (int i = 0; i < addresses.length; i++) {
				listServerAddress.add(new ServerAddress(addresses[i], Integer.parseInt(ports[i])));
			}
			if (null == credential) {
				mongoClient = new MongoClient(listServerAddress, options);
			} else {
				mongoClient = new MongoClient(listServerAddress, Arrays.asList(credential), options);
			}
			mongoClient.setReadPreference(ReadPreference.secondary());
		}


		ccipM.setMongoDBConfig(mongoCfg);

		ccipM.setMongo(mongoClient);
		Morphia morphia = new Morphia();
		ccipM.setMorphia(morphia);

		//数据库不为空时，初始化
		if (StringUtils.isNotEmpty(mongoCfg.getDbname())) {
			setDatastore(ccipM);
		}

		return ccipM;
	}

	/**
	 * 根据Mongo，Morphia，创建Datastore
	 *
	 * @param mongo    Mongo
	 * @param morphia  Morphia
	 * @param dbName   数据库名称
	 * @param username 用户名称
	 * @param password 密码
	 * @return Datastore
	 * @throws
	 */
	public static Datastore createDatastore(Mongo mongo, Morphia morphia, String dbName,
											String username, String password) {
		Datastore da = null;
		da = morphia.createDatastore(mongo, dbName);
		return da;
	}


	/**
	 * 每次都重设置Datastore
	 *
	 * @param ccipM MongoDBPool
	 * @throws
	 */
	static void setDatastore(MongoDBPool ccipM) {
		MongoDBConfig mongoCfg = ccipM.getMongoDBConfig();
		Mongo mongo = ccipM.getMongo();
		Morphia morphia = ccipM.getMorphia();

		String username = mongoCfg.getUsername();
		String password = mongoCfg.getPassword();
		String dbName = mongoCfg.getDbname();
		Datastore da = createDatastore(mongo, morphia, dbName,
				username, password);
		ccipM.setDatastore(da);
	}
}