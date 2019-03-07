package com.hlfc.cache.redis;

import java.util.ArrayList;
import java.util.List;

import com.hlfc.util.EnvironmentUtil;
import com.hlfc.util.PropertyUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * redis 操作客户端
 */

public class RedisClient {

    private Jedis jedis;//非切片额客户端连接
    private JedisPool jedisPool;//非切片连接池
    private ShardedJedis shardedJedis;//切片额客户端连接
    private ShardedJedisPool shardedJedisPool;//切片连接池

    // ip、port、AUTH属性都定义在了config.properties文件中
    private static String host;
    private static int port;

    //访问密码
    private static String AUTH;

    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE;

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE ;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT ;

    private static int TIMEOUT ;

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW ;


    /**
     *  //从配置文件中获取
     */
    private void initialConfig() {
        PropertyUtil pb =  PropertyUtil.getInstance(EnvironmentUtil.getInstance().getWebInfPath()+"/properties/redis.properties");
        host = pb.getValue("redis.host");
        port = Integer.parseInt(pb.getValue("redis.port"));
        AUTH = pb.getValue("redis.auth");
        MAX_ACTIVE = Integer.parseInt(pb.getValue("redis.maxActive"));
        MAX_IDLE = Integer.parseInt(pb.getValue("redis.maxIdle"));
        MAX_WAIT = Integer.parseInt(pb.getValue("redis.maxWait"));
        TIMEOUT = Integer.parseInt(pb.getValue("redis.timeOut"));
        TEST_ON_BORROW = Boolean.parseBoolean(pb.getValue("redis.testOnBorrow"));
    }



    public RedisClient()
    {
        initialConfig();
        initialPool();
        initialShardedPool();
        shardedJedis = shardedJedisPool.getResource();
        jedis = jedisPool.getResource();


    }

    /**
     * 初始化非切片池
     */
    private void initialPool()
    {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxActive(MAX_ACTIVE);
        config.setMaxIdle(MAX_IDLE);
        config.setMaxWait(MAX_WAIT);
        config.setTestOnBorrow(TEST_ON_BORROW);

        jedisPool = new JedisPool(config,host,port);
    }

    /**
     * 初始化切片池
     */
    private void initialShardedPool()
    {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxActive(MAX_ACTIVE);
        config.setMaxIdle(MAX_IDLE);
        config.setMaxWait(MAX_WAIT);
        config.setTestOnBorrow(TEST_ON_BORROW);
        // slave链接
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo(host, port, "master"));

        // 构造池
        shardedJedisPool = new ShardedJedisPool(config, shards);
    }

    public void closePool(){
        jedisPool.returnResource(jedis);
        shardedJedisPool.returnResource(shardedJedis);
    }



    public Jedis getJedis() {
        return jedis;
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }

    public ShardedJedis getShardedJedis() {
        return shardedJedis;
    }

    public void setShardedJedis(ShardedJedis shardedJedis) {
        this.shardedJedis = shardedJedis;
    }
}