package com.matthewyao.designpattern.FactoryPattern.abstractFactory;

/**
 * Created by yaokuan on 2018/5/10.
 */
public class BigCircleFactory implements Factory {
    @Override
    public Shape produceShape() {
        return new Circle();
    }

    @Override
    public Size produceSize() {
        return new Big();
    }
}
