package com.hlfc.jdk8.stream;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: hxl111
 * @Date: 2020/5/26 15:11
 */
public class HTest {

    private static List<String> aaa = new ArrayList<>();
    static {
        aaa = new ArrayList<>();
        aaa.add("123");
        aaa.add("456");
        aaa.add("456");
    }

    @Test
    public void map(){

    }

    @Test
    public void foreach(){

        String a = new String();
        boolean dd = true;

        List<String> vvv= new ArrayList<>();
        String[] aa = new String[] {};
        aaa.stream().forEach(i->{

//            a = "123";//编译报错，
            vvv.add(i);//使用list包裹，可以修改外部遍历
            aa[0] = "23";//使用数组
        });
    }
}
