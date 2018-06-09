package com.matthewyao.designpattern.proxyPattern;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class People implements BuySomething {
    @Override
    public void buyBMW() {
        System.out.println("I want to buy a BMW, but I don't know how, so I find the proxy");
    }

    @Override
    public void buyBenz() {
        System.out.println("I want to buy a Benz, I find the proxy again");
    }
}
