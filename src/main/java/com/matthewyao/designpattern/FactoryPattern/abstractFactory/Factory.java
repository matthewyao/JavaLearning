package com.matthewyao.designpattern.FactoryPattern.abstractFactory;

/**
 * Created by yaokuan on 2018/5/5.
 */
public interface Factory {
    Shape produceShape();

    Size produceSize();
}
