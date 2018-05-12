package com.matthewyao.designpattern.builder;

/**
 * Created by yaokuan on 2018/5/12.
 */
public class Test {
    /**
     * 将对象表示和对象创建分离，适用于对象组成类似，但又各自有不同的组装过程的场景
     */
    public static void main(String[] args) {
        Builder builder = new FruitSaladBuilder();
        Director director = new Director(builder);
        Salad fruitSalad = director.getSalad();
        System.out.println(fruitSalad);

        builder = new CaesarSaladBuilder();
        director = new Director(builder);
        Salad caesarSalad = director.getSalad();
        System.out.println(caesarSalad);
    }
}
