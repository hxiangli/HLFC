package com.hlfc.design.factory.abstr;

/**
 * 在抽象工厂模式中，抽象产品 (AbstractProduct) 可能是一个或多个，从而构成一个或多个产品族(Product Family)。 在只有一个产品族的情况下，抽象工厂模式实际上退化到工厂方法模式。
 */

public abstract class AbstractFactory {
//    public abstract Vehicle createVehicle();
//    public abstract Weapon createWeapon();
//    public abstract Food createFood();
}

//具体工厂类，其中Food,Vehicle，Weapon是抽象类，
//public class DefaultFactory extends AbstractFactory {
//    @Override
//    public Food createFood() {
//        return new Apple();
//    }
//    @Override
//    public Vehicle createVehicle() {
//        return new Car();
//    }
//    @Override
//    public Weapon createWeapon() {
//        return new AK47();
//    }
//}

////测试类
//public class Test {
//    public static void main(String[] args) {
//        AbstractFactory f = new DefaultFactory();
//        Vehicle v = f.createVehicle();
//        v.run();
//        Weapon w = f.createWeapon();
//        w.shoot();
//        Food a = f.createFood();
//        a.printName();
//    }
//}