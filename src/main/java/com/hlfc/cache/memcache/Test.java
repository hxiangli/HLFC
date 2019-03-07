package com.hlfc.cache.memcache;

/**
 * Created by HXL on 2018/8/9.
 */
public class Test {

    public static void main(String[] args) {

        MemCachedManager mcc = MemCachedManager.getInstance();

        //新增缓存
        mcc.add("123","234");

        //查询缓存
        String obj = (String)mcc.get("123");

        System.out.println("args = [" + obj + "]");

        //修改缓存
        mcc.add("123","234");

        //查询缓存
        obj = (String)mcc.get("123");

        System.out.println("args = [" + obj + "]");

        //删除缓存
        mcc.remove("123");
    }
}
