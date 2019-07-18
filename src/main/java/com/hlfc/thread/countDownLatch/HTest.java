package com.hlfc.thread.countDownLatch;

/**
 * https://blog.csdn.net/sinat_20689109/article/details/80425721
 *  在开发过程中，可能会遇到这样一种情况。当要进行事件A，B。A的可执行前提是：B的某一部分必须先完成。
 * @Author hxl
 * @Date  2019/6/24
 **/
import org.apache.log4j.Logger;

import java.util.concurrent.CountDownLatch;

public class HTest {

    static  Logger  log = Logger.getLogger(HTest.class);

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch cdl = new CountDownLatch(1);
        XiaoMing xiaoMing = new XiaoMing(cdl);
        XiaoHong xiaoHong = new XiaoHong();

        log.info("做饭");
        xiaoMing.start();

        //线程阻塞，等待 cd1计数器值为 0 后执行
        cdl.await();
        xiaoHong.start();
    }
}
