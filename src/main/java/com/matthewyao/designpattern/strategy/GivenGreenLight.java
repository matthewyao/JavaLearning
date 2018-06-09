package com.matthewyao.designpattern.strategy;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class GivenGreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("求吴国太开个绿灯，放行");
    }
}
