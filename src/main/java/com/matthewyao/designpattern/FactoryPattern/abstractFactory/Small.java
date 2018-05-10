package com.matthewyao.designpattern.FactoryPattern.abstractFactory;

/**
 * Created by yaokuan on 2018/5/5.
 */
public class Small implements Size {
    @Override
    public void show() {
        System.out.println("small size");
    }
}
