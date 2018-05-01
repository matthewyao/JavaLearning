package com.matthewyao.designpattern.decorate;

/**
 * Created by yaokuan on 2018/5/1.
 */
public class CaesarSalad extends Salad{

    @Override
    protected String getName() {
        return "凯撒沙拉";
    }

    @Override
    protected double getPrice() {
        return 18;
    }
}
