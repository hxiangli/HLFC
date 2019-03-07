package com.hlfc.cache.memcache;

/**
 * memcache缓存工具类
 * Created by HXL on 2018/8/9.
 */
import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import java.util.Date;

public class MemCachedManager {
    private static MemCachedClient mcc = null;
    protected static MemCachedManager memCachedManager = null;
//    public static final String PROPERTY_FILE_NAME = "memcached.properties";

    private MemCachedManager() {
//        CachedConfigFactory memCachedConfigFactory = new MemCachedConfigFactoryImpl();
//        MemCachedConfig memCachedConfig = (MemCachedConfig)memCachedConfigFactory.produce();
        SockIOPool pool = null;
//        name=memcache
//        servers=127.0.0.1\:11211
//        weights=1
//        initConn=5
//        minConn=5
//        maxConn=250
//#1000 * 60 * 60 * 6
//        maxIdle=21600000
//        maintSleep=30
//        nagle=false
//        socketTO=3000
//        socketConnectTO=0
//        debugFlag=false
        MemCachedConfig memCachedConfig = new  MemCachedConfig();
        memCachedConfig.setCachedName("memcache");
        String [] servers = new String[]{"127.0.0.1\\:11211"};
        memCachedConfig.setServers(servers);
        Integer [] weights = new Integer[]{1};
        memCachedConfig.setWeights(weights);
        memCachedConfig.setInitConn(5);
        memCachedConfig.setMinConn(5);
        memCachedConfig.setMaxConn(250);
        memCachedConfig.setMaxIdle(21600000);
        memCachedConfig.setMaintSleep(30);

        try {
            pool = SockIOPool.getInstance(memCachedConfig.getCachedName());
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        pool.setServers(memCachedConfig.getServers());
        pool.setWeights(memCachedConfig.getWeights());
        pool.setInitConn(memCachedConfig.getInitConn());
        pool.setMinConn(memCachedConfig.getMaxConn());
        pool.setMaxConn(memCachedConfig.getMaxConn());
        pool.setMaxIdle((long)memCachedConfig.getMaxIdle());
        pool.setMaintSleep((long)memCachedConfig.getMaintSleep());
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setSocketConnectTO(0);
        pool.initialize();
        mcc = new MemCachedClient(memCachedConfig.getCachedName());
    }

    public static MemCachedManager getInstance() {
        if(null == memCachedManager) {
            memCachedManager = new MemCachedManager();
        }

        return memCachedManager;
    }

    public boolean add(String key, Object value) {
        return null == key && null == value?false:(!mcc.keyExists(key)?mcc.add(key, value):mcc.replace(key, value));
    }

    public boolean add(String key, Object value, int expiry) {
        return null == key && null == value?false:(!mcc.keyExists(key)?mcc.add(key, value, Integer.valueOf(expiry)):mcc.replace(key, value, Integer.valueOf(expiry)));
    }

    public boolean replace(String key, Object value) {
        return mcc.keyExists(key)?mcc.replace(key, value):mcc.add(key, value);
    }

    public boolean replace(String key, Object value, Date expiry) {
        return mcc.keyExists(key)?mcc.replace(key, value, expiry):mcc.add(key, value, expiry);
    }

    public boolean remove(String key) {
        return mcc.delete(key);
    }

    public boolean removeAll() {
        return mcc.flushAll();
    }

    public boolean constainsKey(String key) {
        return mcc.keyExists(key);
    }

    public Object get(String key) {
        return key == null?null:mcc.get(key);
    }
}

