package com.matthewyao.designpattern.FactoryPattern.simpleFactory;

/**
 * Created by yaokuan on 2018/5/5.
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Draw a Rectangle");
    }
}
