/**
 * memcache 配置11
 */

package com.hlfc.cache.memcache;

class MemCachedConfig {
    private String cachedName;
    private String[] servers;
    private Integer[] weights;
    private int initConn;
    private int minConn;
    private int maxConn;
    private int maxIdle;
    private int maintSleep;
    private boolean nagle;
    private int socketTO;
    private int socketConnectTO;
    private boolean debugFlag;
    private String userCachedKeyImplClassName;
    private String type;

    MemCachedConfig() {
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserCachedKeyImplClassName() {
        return this.userCachedKeyImplClassName;
    }

    public void setUserCachedKeyImplClassName(String userCachedKeyImplClassName) {
        this.userCachedKeyImplClassName = userCachedKeyImplClassName;
    }

    public String getCachedName() {
        return this.cachedName;
    }

    public void setCachedName(String cachedName) {
        this.cachedName = cachedName;
    }

    public String[] getServers() {
        return this.servers;
    }

    public void setServers(String[] servers) {
        this.servers = servers;
    }

    public Integer[] getWeights() {
        return this.weights;
    }

    public void setWeights(Integer[] weights) {
        this.weights = weights;
    }

    public int getInitConn() {
        return this.initConn;
    }

    public void setInitConn(int initConn) {
        this.initConn = initConn;
    }

    public int getMinConn() {
        return this.minConn;
    }

    public void setMinConn(int minConn) {
        this.minConn = minConn;
    }

    public int getMaxConn() {
        return this.maxConn;
    }

    public void setMaxConn(int maxConn) {
        this.maxConn = maxConn;
    }

    public int getMaxIdle() {
        return this.maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaintSleep() {
        return this.maintSleep;
    }

    public void setMaintSleep(int maintSleep) {
        this.maintSleep = maintSleep;
    }

    public boolean isNagle() {
        return this.nagle;
    }

    public void setNagle(boolean nagle) {
        this.nagle = nagle;
    }

    public int getSocketTO() {
        return this.socketTO;
    }

    public void setSocketTO(int socketTO) {
        this.socketTO = socketTO;
    }

    public int getSocketConnectTO() {
        return this.socketConnectTO;
    }

    public void setSocketConnectTO(int socketConnectTO) {
        this.socketConnectTO = socketConnectTO;
    }

    public boolean getDebugFlag() {
        return this.debugFlag;
    }

    public void setDebugFlag(boolean debugFlag) {
        this.debugFlag = debugFlag;
    }
}
