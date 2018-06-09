package com.matthewyao.designpattern.observer;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class Security implements Watcher {
    @Override
    public void update() {
        System.out.println("运输车有行动，保安贴身保护");
    }
}
