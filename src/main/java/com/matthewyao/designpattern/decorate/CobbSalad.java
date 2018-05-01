package com.matthewyao.designpattern.decorate;

/**
 * Created by yaokuan on 2018/5/1.
 */
public class CobbSalad extends Salad {

    @Override
    protected String getName() {
        return "考伯沙拉";
    }

    @Override
    protected double getPrice() {
        return 17;
    }
}
