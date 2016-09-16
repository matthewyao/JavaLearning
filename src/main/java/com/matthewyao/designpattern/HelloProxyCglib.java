package com.matthewyao.designpattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by matthewyao on 2016/9/16.
 */
public class HelloProxyCglib implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        Object proxy = enhancer.create();
        System.out.println(proxy.getClass());
        System.out.println(proxy.getClass().getMethods()[3]);
        System.out.println(proxy.getClass().getInterfaces()[0]);
        return proxy;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin cglib...");
        Object evt = methodProxy.invoke(target,objects);
        System.out.println("end cglib...");
        return evt;
    }
}
