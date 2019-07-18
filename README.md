# 说明
>HLFC基础项目工具框架。


## 后台代码分层说明：
### com.hlfc
+ cache (缓存)
   + memcache
   + redis
+ controller (控制层)
   + spring 
   + struts
   + util
+ db (数据库操作)
   + hibernate
   + mongodb
   + mybatislpus
+ design(设计模式)
   + adapter(适配器模式)
   + decorator(装饰类)
   + factory(工厂模式)
   + singleton(单例模式)
   + subscribe(观察者模式)
+ exception(异常)
+ file(文件流操作)
   + dir(文件夹)
   + excel
   + image(图片)
   + io（流读取）
   + zip（压缩包）
+ http (http)
   + client（http客户端请求）
   + service（http 服务端）
      + resultful(rest服务)
   + HttpWebDownloadTest (web http请求文件下载)
+ log(日志：log4j)
+ mq(消息通知)
   + rabbitmq
      + simple(简单队列模式:一对一) 
      + confirm(事务模式：异步)
      + ps (订阅模式:多个队列，通过交换机绑定)
      + routing (routing)
      + spring （集成spring）
      + topic(主题模式，支持正则表达适配比如 #)
      + work(工作队列)
      + tx (事务机制的消息发送)
+ nio (非阻塞流)
   + netty
   + nettyAddWebSocket（netty+websocket）
+ other （其他）
   + LambdaTest（lambda）
+ queue(队列)
   + delayed（延时队列）
   + LinkedBlockingQueueDemo（队列）
+ rsa（加密算法）
+ set (集合set)
   + tree (treeSet 排序方式)
      + obj (引用类型排序)
         + comparator (比较器排序法)
         + compare (自然排序法)
+ thread（线程）
    + callable（有返回值的线程）
    + countDownLatch（计数器）
    + synch（同步锁）
    + AnonymousThread（匿名内部类的方式）
    + RunnableDemo（implements Runnable 的线程写法）
    + ThreadDeom （extends Thread  的线程写法）
    + ThreadPool （线程池）
+ ueditor (百度富文本)
+ util （工具类）
+ xml （xml操作）  
### 前端功能清单
+ 富文本框
+ 基本数据操作(struts)
+ 基本数据操作(springMVC)
+ 视频播放(ckplayer)
+ nettySocket  
    
   
   

