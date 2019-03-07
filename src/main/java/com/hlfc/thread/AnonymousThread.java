package com.hlfc.thread;

/**
 * 匿名内部类的方式
 * @Auther: HXL
 * @Date: 2018/11/8 15:29
 */
public class AnonymousThread {

    public static void main(String[] args) {

       new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 4; i > 0; i--) {
                    System.out.println("Thread: " + i);
                    // 让线程睡眠一会
                }
            }
        }).start();
    }
}
