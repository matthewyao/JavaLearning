package com.matthewyao.designpattern.FactoryPattern.simpleFactory;

/**
 * Created by yaokuan on 2018/5/5.
 */
public class Factory {

    /**
     * 简单工厂模式，又称静态工厂模式，常采用静态方法生成对象，
     * 若对象簇扩充，需要修改工厂代码，不符合开闭原则
     */
    public static Shape produce(String shape) {
        if (shape.equalsIgnoreCase("square")) {
            return new Square();
        } else if (shape.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (shape.equalsIgnoreCase("circle")) {
            return new Circle();
        }
        return null;
    }
}
