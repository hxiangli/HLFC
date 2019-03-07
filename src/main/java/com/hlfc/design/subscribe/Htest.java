package com.hlfc.design.subscribe;

import java.util.Vector;

/**
 * 观察者(Observer)模式测试类
 *
 * 老师（通知者）的电话号码变化，通知到各个学生（观察者）
 */  
public class Htest {
    public static void main(String[] args) {  
       Vector students = new Vector();
       Teacher t = new Teacher();  
       for(int i= 0;i<10;i++){  
           Student st = new Student("Andy.Chen"+i,t);  
           students.add(st);  
           t.attach(st);  
       }  
         
       System.out.println("Welcome to Andy.Chen Blog!" +"\n"   
                   +"Observer Patterns." +"\n"  
                   +"-------------------------------");  
         
       t.setPhone("12345678");  
       for(int i=0;i<3;i++)  
           ((Student)students.get(i)).show();  
         
       t.setPhone("87654321");  
       for(int i=0;i<3;i++)  
           ((Student)students.get(i)).show();  
    }  
} 