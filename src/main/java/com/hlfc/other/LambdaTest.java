package com.hlfc.other;

/**
 * Lambda的测试
 * @Auther: hxl
 * @Date: 2019/4/28 14:34
 */
public class LambdaTest {


    public static void main(String[] args) {
        LambdaTest test  = new LambdaTest();
        test.Lambda();

       Thread thread = new Thread(()->{
            System.out.println("开始跑线程");
        });
        thread.start();
    }

    /**
     *   -> 符号的使用。Lambda 表达式
     *    允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
     */
    public void Lambda(){
        this.Lambda1(1,2,(param)->{
                return 2+3+param;
        });

    }

    public void Lambda1(int a,int b,ILambda  c){
        int f = a+b+c.a(4);
        System.out.println("执行结果是"+f);
    }

    interface ILambda{
        public int a(int d);

        //只能有一个抽象方法
//        public String b(String d);
    }




}
