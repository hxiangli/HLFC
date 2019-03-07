package com.hlfc.design.decorator;

/**
 * 创建装饰类 Decorator 实现 Component 接口
 */
public class Decorator implements Component{
    private Component mComponent;
    public void decoratorObj(Component component){
        mComponent = component;
    }

    @Override
    public void show() {
        if(mComponent != null){
            mComponent.show();
        }
    }
}