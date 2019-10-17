package com.hlfc.thread.callable;

/**
 * https://www.cnblogs.com/wanqieddy/p/3853863.html
 *  使用  ExecutorService 进行线程调用callback
 *   多线程计算 1-10 累计相加
 * @Auther: hxl
 * @Date: 2019/10/17 09:17
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestExecutorCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<Future<String>>();

        //创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            int result = i;
            Future<String> future = executorService.submit(() ->{
                int allResult = 0;
                System.out.println("多线程开始计算0到"+result+"累加");
                for (int j = result; j > 0; j--){
                    allResult += j;
                }
                return "==0到"+result+"累加的结果是：" + allResult + " " + Thread.currentThread().getName();
            });
            //将任务执行结果存储到List中
            resultList.add(future);
        }

        //遍历任务的结果

        for (Future<String> fs : resultList) {
            try {
                System.out.println(fs.get());     //打印各个线程（任务）执行的结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务。如果已经关闭，则调用没有其他作用。
                executorService.shutdown();
            }
        }

        System.out.println("===========结束任务===================");


    }
}