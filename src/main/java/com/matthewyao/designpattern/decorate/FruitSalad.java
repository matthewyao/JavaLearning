package com.matthewyao.designpattern.decorate;

/**
 * Created by yaokuan on 2018/5/1.
 */
public class FruitSalad extends Salad {

    @Override
    protected String getName() {
        return "水果沙拉";
    }

    @Override
    protected double getPrice() {
        return 20;
    }
}
