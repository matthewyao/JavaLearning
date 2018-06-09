package com.matthewyao.designpattern.bridge;

/**
 * Created by yaokuan on 2018/5/25.
 */
public class Circle extends Shape {
    @Override
    public void draw() {
        color.paint("圆形");
    }
}
