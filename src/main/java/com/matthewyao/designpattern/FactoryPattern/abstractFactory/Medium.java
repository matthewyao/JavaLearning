package com.matthewyao.designpattern.FactoryPattern.abstractFactory;

/**
 * Created by yaokuan on 2018/5/10.
 */
public class Medium implements Size {
    @Override
    public void show() {
        System.out.println("medium size");
    }
}
