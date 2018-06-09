package com.matthewyao.designpattern.flyweight;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class Client {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight fw1, fw2, fw3, fw4, fw5, fw6;

        fw1 = factory.getFlyweight("Google");
        fw2 = factory.getFlyweight("google");
        fw3 = factory.getFlyweight("Google");
        fw4 = factory.getFlyweight("Gooogle");
        fw5 = factory.getFlyweight("Google");
        fw6 = factory.getFlyweight("google");

        fw1.operation();
        fw2.operation();
        fw3.operation();
        fw4.operation();
        fw5.operation();
        fw6.operation();
        System.out.println("Total flyweight size: " + factory.getFlyweightSize());
    }
}
