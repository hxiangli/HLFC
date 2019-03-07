package com.hlfc.design.singleton;
/**
 * https://www.cnblogs.com/cr330326/p/5627658.html
 * 单例模式（懒汉式）
 * @author HXL
 * @since 2018-11-16
 * 优点：延迟加载（需要的时候才去加载）,适合单线程操作
 * 缺点： 线程不安全，在多线程中很容易出现不同步的情况，如在数据库对象进行的频繁读写操作时。
 */
public class SingletonThread {
    private static volatile SingletonThread sInst = null;  // <<< 这里添加了 volatile
  
    /** 
     * 私有的构造函数 
     */  
    private SingletonThread() {}  
  
    public static SingletonThread getInstance() {
        SingletonThread inst = sInst;  // <<< 在这里创建临时变量
        if (inst == null) {
            synchronized (SingletonThread.class) {
                inst = sInst;
                if (inst == null) {
                    inst = new SingletonThread();
                    sInst = inst;
                }
            }
        }
        return inst;  // <<< 注意这里返回的是临时变量
    }
  
    protected void method() {  
        System.out.println("SingletonThread");  
    }  
}  