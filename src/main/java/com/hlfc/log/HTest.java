package com.hlfc.log;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @Auther: HXL
 * @Date: 2018/11/7 18:02
 */
public class HTest {
    //获取日志记录器Logger，名字为本类类名
    private static Logger log = Logger.getLogger(Test.class);

    @Test
    public void test1(){
        for(int i=0;i<10;i++){
            log.info("HellWord");
        }

    }

}
