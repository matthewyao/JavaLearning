package com.matthewyao.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by matthewyao on 2016/9/16.
 */
public class HelloHandler implements InvocationHandler {

    private Object target;

    public Object getProxy(Object target){
        this.target = target;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
//        System.out.println(proxy.getClass());
//        System.out.println(proxy.getClass().getMethods()[3]);
//        System.out.println(proxy.getClass().getInterfaces()[0]);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //首先直接调用原对象方法
        System.out.println("begin proxy..");
        System.out.println("method name: " + method.getName());
//        System.out.println(proxy.getClass().getName());
        Object rvt = method.invoke(target,args);
        System.out.println("end proxy..");
        return rvt;
    }
}
