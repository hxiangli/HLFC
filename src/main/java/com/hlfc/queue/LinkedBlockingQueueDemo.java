package com.hlfc.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 参考： http://www.cnblogs.com/WangHaiMing/p/8798709.html
 * 队列使用（使用线程取队列）
 * @Auther: HXL
 * @Date: 2018/11/13 09:54
 */
public class LinkedBlockingQueueDemo {

    private static LinkedBlockingQueueDemo queueDemo = null;

    public static synchronized LinkedBlockingQueueDemo getInstance()
    {
        if (queueDemo == null){

            queueDemo = new LinkedBlockingQueueDemo();
        }
        return queueDemo;
    }

    /**
     * 阻塞队列
     */
    private BlockingQueue<Integer> queue =new LinkedBlockingQueue<Integer>();

    //消费线程(取队列信息)
    private Command comsumer=new Command();

    public LinkedBlockingQueueDemo(){
        comsumer.start();
    }


    //添加队列
    public void putValue(Integer i){
        try {
            System.out.println("添加队列值i:"+i);
            queue.put(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 消费线程任务定义
     *
     */
    private class Command extends Thread {


        // 循环跑任务执行线程任务
        public void run() {
            while(true){
                int   i ;
                try {
                    i=queue.take();
                    Thread.sleep(1000);
                    System.out.println("获取到队列值i:"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        LinkedBlockingQueueDemo linkedBlockingQueueDemo = LinkedBlockingQueueDemo.getInstance();
        for (int i=0;i<10;i++){
            linkedBlockingQueueDemo.putValue(i);
        }
    }
}
