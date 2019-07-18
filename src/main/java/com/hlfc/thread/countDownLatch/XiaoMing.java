package com.hlfc.thread.countDownLatch;

import org.apache.log4j.Logger;

import java.util.concurrent.CountDownLatch;

public class XiaoMing extends Thread {

    Logger log = Logger.getLogger(XiaoHong.class);

    CountDownLatch cdl;
    XiaoMing(CountDownLatch cdl){
        this.cdl = cdl;
    }
    @Override
    public void run() {
        try {
            //处理具体业务逻辑
            log.info("小明开始处理：大虾");
            Thread.sleep(1000);
            log.info("小明将 大虾 处理完");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            cdl.countDown();
        }

        try {
            log.info("小明开始处理：里脊");
            Thread.sleep(1000);
            log.info("小明将 里脊 处理完");
            log.info("小明开始处理：西兰花");
            Thread.sleep(1000);
            log.info("小明将 西兰花 处理完");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}