package com.matthewyao.designpattern.proxyPattern;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class Client {
    public static void main(String[] args) {
        People me = new People();
        Proxy proxy = new Proxy(me);
        System.out.println("One day");
        proxy.buyBMW();
        System.out.println();
        System.out.println("After a few days");
        proxy.buyBenz();
    }
}
