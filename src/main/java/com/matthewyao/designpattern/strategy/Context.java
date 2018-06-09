package com.matthewyao.designpattern.strategy;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class Context {
    private IStrategy strategy;

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void operate() {
        strategy.operate();
    }
}
