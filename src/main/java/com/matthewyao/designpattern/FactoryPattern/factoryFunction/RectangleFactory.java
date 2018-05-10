package com.matthewyao.designpattern.FactoryPattern.factoryFunction;

/**
 * Created by yaokuan on 2018/5/5.
 */
public class RectangleFactory implements Factory{

    public Rectangle produce() {
        return new Rectangle();
    }
}
