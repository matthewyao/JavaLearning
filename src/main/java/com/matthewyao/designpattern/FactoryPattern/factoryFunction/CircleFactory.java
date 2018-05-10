package com.matthewyao.designpattern.FactoryPattern.factoryFunction;

/**
 * Created by yaokuan on 2018/5/5.
 */
public class CircleFactory implements Factory{

    public Circle produce() {
        return new Circle();
    }
}
