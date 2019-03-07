package com.hlfc.design.decorator;

/**
 * 分别创建具体的装饰类：Jeans.java , Pelisse.java, Sandal.java ...等等，分别继承 Decorator.java 类
 * 牛仔裤 */
public class Jeans extends Decorator {
    @Override
    public void show(){
        System.out.println("穿牛仔裤");
        super.show();
    }
    
}