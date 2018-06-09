package com.matthewyao.designpattern.bridge;

/**
 * Created by yaokuan on 2018/5/25.
 */
public class Red implements Color {
    @Override
    public void paint(String shape) {
        System.out.println("红色的" + shape);
    }
}
