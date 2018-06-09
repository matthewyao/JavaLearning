package com.matthewyao.designpattern.bridge;

/**
 * Created by yaokuan on 2018/5/25.
 */
public class White implements Color {
    @Override
    public void paint(String shape) {
        System.out.println("白色的" + shape);
    }
}
