package com.hlfc.thread.countDownLatch;


import org.apache.log4j.Logger;

public class XiaoHong extends Thread {
    Logger log = Logger.getLogger(XiaoHong.class);

    @Override
    public void run() {
        log.info("小红开始做菜");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("小红做菜结束");
        log.info("开饭");
    }
}
