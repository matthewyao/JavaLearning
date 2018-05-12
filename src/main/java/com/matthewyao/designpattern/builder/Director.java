package com.matthewyao.designpattern.builder;

/**
 * Created by yaokuan on 2018/5/12.
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Salad getSalad() {
        return builder.buildSalad();
    }
}
