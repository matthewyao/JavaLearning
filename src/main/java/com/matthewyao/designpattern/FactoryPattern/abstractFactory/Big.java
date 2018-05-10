package com.matthewyao.designpattern.FactoryPattern.abstractFactory;

/**
 * Created by yaokuan on 2018/5/5.
 */
public class Big implements Size {
    @Override
    public void show() {
        System.out.println("big size");
    }
}
