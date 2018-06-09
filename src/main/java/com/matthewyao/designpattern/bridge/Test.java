package com.matthewyao.designpattern.bridge;

/**
 * Created by yaokuan on 2018/5/25.
 */
public class Test {
    public static void main(String[] args) {
        Color white = new White();
        Color red = new Red();
        Shape rectangle = new Rectangle();
        rectangle.setColor(white);
        rectangle.draw();
        rectangle.setColor(red);
        rectangle.draw();

        Shape circle = new Circle();
        circle.setColor(white);
        circle.draw();
        circle.setColor(red);
        circle.draw();
    }
}
