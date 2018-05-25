package com.matthewyao.designpattern.prototype;

/**
 * Created by yaokuan on 2018/5/13.
 */
public class Client {
    public static void main(String[] args) {
        ConcretePrototypeA cpa = new ConcretePrototypeA();
        ConcretePrototypeB cpb = new ConcretePrototypeB();
        for (int i=1; i<=5; i++) {
            ConcretePrototypeA cpac = (ConcretePrototypeA)cpa.clone();
            cpac.show();
            ConcretePrototypeB cpbc = (ConcretePrototypeB)cpb.clone();
            cpbc.show();
        }

    }
}
