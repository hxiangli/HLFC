package com.hlfc.design.factory.fun;

/*
 *具体工厂
 */
public class BroomFactory extends VehicleFactory{
    public Moveable create() {
        return new Broom();
    }
}