package com.matthewyao.designpattern.bridge;

/**
 * Created by yaokuan on 2018/5/25.
 */
public class Blue implements Color {
    @Override
    public void paint(String shape) {
        System.out.println("蓝色的" + shape);
    }
}
