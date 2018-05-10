package com.matthewyao.designpattern.FactoryPattern.abstractFactory;

/**
 * Created by yaokuan on 2018/5/10.
 */
public class SmallSquareFactory implements Factory {
    @Override
    public Shape produceShape() {
        return new Square();
    }

    @Override
    public Size produceSize() {
        return new Small();
    }
}
