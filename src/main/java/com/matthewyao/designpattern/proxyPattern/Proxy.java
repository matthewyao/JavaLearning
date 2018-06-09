package com.matthewyao.designpattern.proxyPattern;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class Proxy implements BuySomething {

    private People people;

    public Proxy(People people) {
        this.people = people;
    }

    @Override
    public void buyBMW() {
        people.buyBMW();
        doProxy("BMW");
    }

    @Override
    public void buyBenz() {
        people.buyBenz();
        doProxy("Benz");
    }

    private void doProxy(String carName) {
        System.out.println("Proxy booking a "+ carName +"...");
        System.out.println("Proxy Receive the car");
        System.out.println("Proxy send the car to my place...");
        System.out.println("I received my car!");
    }
}
