package com.hlfc.design.decorator;

/**
 * @Auther: HXL
 * @Date: 2018/11/19 15:21
 */
public class HTest {
    public static void main(String[] args) {
        System.out.println("Welcome to Andy.Chen Blog!" +"\n"
                +"Decorator Patterns." +"\n");

        Person mPerson = new Person("Andy");


        Jeans mJeans = new Jeans();
        Tshirt tshirt = new Tshirt();

        mJeans.decoratorObj(mPerson);
        tshirt.decoratorObj(mJeans);
        tshirt.show();
    }
}
