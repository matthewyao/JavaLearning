package com.matthewyao.designpattern.strategy;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class BlockEnemy implements IStrategy {
    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}
