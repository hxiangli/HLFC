package com.hlfc.design.decorator;

/** T-Shirt*/
public class Tshirt extends Decorator {
    @Override
    public void show(){
        System.out.println("穿T-Shirt");
        super.show();
    }
    
}