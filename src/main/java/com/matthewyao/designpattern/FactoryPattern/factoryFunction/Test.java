package com.matthewyao.designpattern.FactoryPattern.factoryFunction;

/**
 * Created by yaokuan on 2018/5/5.
 */
public class Test {
    public static void main(String[] args) {
        CircleFactory circleFactory = new CircleFactory();
        Circle circle = circleFactory.produce();
        circle.draw();

        RectangleFactory rectangleFactory = new RectangleFactory();
        Rectangle rectangle = rectangleFactory.produce();
        rectangle.draw();

        SquareFactory squareFactory = new SquareFactory();
        Square square = squareFactory.produce();
        square.draw();
    }
}
