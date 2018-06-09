package com.matthewyao.designpattern.strategy;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力，使孙权不能杀刘备");
    }
}
