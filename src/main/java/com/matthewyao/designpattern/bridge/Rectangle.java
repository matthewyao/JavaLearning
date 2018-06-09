package com.matthewyao.designpattern.bridge;

/**
 * Created by yaokuan on 2018/5/25.
 */
public class Rectangle extends Shape {
    @Override
    public void draw() {
        color.paint("长方形");
    }
}
