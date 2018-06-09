package com.matthewyao.designpattern.flyweight;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class ConcreteFlyweight extends Flyweight {

    private String str;//假设这里的享元是一个字符串

    public ConcreteFlyweight(String str) {
        this.str = str;
    }

    @Override
    public void operation() {
        System.out.println("Concrete flyweight: " + str);
    }
}
