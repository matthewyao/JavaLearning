package com.matthewyao.designpattern.FactoryPattern.abstractFactory;

/**
 * Created by yaokuan on 2018/5/10.
 */
public class Test {
    public static void main(String[] args) {
        BigCircleFactory bigCircleFactory = new BigCircleFactory();
        Shape circle = bigCircleFactory.produceShape();
        Size big = bigCircleFactory.produceSize();
        big.show();
        circle.draw();

        SmallSquareFactory smallSquareFactory = new SmallSquareFactory();
        Shape square = smallSquareFactory.produceShape();
        Size small = smallSquareFactory.produceSize();
        small.show();
        square.draw();
    }
}
