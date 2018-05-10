package com.matthewyao.designpattern.FactoryPattern.simpleFactory;

/**
 * Created by yaokuan on 2018/5/10.
 */
public class Test {
    public static void main(String[] args) {
        Shape rectangle = Factory.produce("rectangle");
        rectangle.draw();
    }
}
