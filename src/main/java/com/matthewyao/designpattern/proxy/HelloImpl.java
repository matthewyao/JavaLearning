package com.matthewyao.designpattern.proxy;

/**
 * Created by matthewyao on 2016/9/16.
 */
public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("hello!");
    }
}
