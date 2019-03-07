package com.hlfc.design.factory.fun;


/**
 * 具体实现产品
 * @Auther: HXL
 * @Date: 2018/11/19 11:03
 */
public class Broom implements Moveable {
    @Override
    public void run() {
        System.out.println("broom.....");
    }
}
