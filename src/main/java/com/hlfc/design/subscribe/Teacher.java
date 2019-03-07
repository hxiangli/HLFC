package com.hlfc.design.subscribe;

import java.util.Vector;

/**
 * ConcreteSubject(具体目标，Teacher)  
 * 将有关状态存入各ConcreteObserve对象。  
 * 当他的状态发生改变时，向他的各个观察者发出通知。   
 */  
public class Teacher implements Subject{  
     
    private String phone;

    //观察者
    private Vector<Observer> students;
    
    public Teacher(){  
        phone = "";  
        students = new Vector();
    }  
  
    @Override  
    public void attach(Observer mObserver) {  
        students.add(mObserver);  
    }  
  
    @Override  
    public void detach(Observer mObserver) {  
        students.remove(mObserver);  
    }  


    //通知操作
    @Override  
    public void notice() {  
        for(int i=0;i<students.size();i++){  
            ((Observer)students.get(i)).update();  
        }  
    }  
  
    public String getPhone() {  
        return phone;  
    }  
  
    public void setPhone(String phone) {  
        this.phone = phone;  
        notice();  
    }  
}