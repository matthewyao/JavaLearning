package com.matthewyao.designpattern.visitor;

/**
 * Created by yaokuan on 2018/6/9.
 */
class ConcreteElement1 extends Element {
    public void doSomething(){
        System.out.println("这是元素1");
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}