package com.hlfc.thread;

import org.junit.Test;

/**
 * @Auther: HXL
 * @Date: 2018/11/8 10:33
 */
public class HTest {

    @Test
    public void test1(){
        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo( "Thread-2");
        R2.start();

    }
}
