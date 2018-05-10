package com.matthewyao.designpattern.FactoryPattern.factoryFunction;

/**
 * Created by yaokuan on 2018/5/5.
 */
public class SquareFactory implements Factory{

    public Square produce() {
        return new Square();
    }
}
