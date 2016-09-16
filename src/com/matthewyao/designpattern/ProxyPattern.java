package com.matthewyao.designpattern;

import java.lang.reflect.Proxy;

/**
 * Created by matthewyao on 2016/9/16.
 */
public class ProxyPattern {
    public static void execute() {
//        Hello hello = new HelloImpl();
//        Hello hello1 = (Hello) new HelloHandler().getProxy(hello);
//        hello1.sayHello();
        ((Hello) new HelloHandler().getProxy(new HelloImpl())).sayHello();
    }
}
