package com.matthewyao.designpattern.visitor;

/**
 * Created by yaokuan on 2018/6/9.
 */
class ConcreteElement2 extends Element {
    public void doSomething(){
        System.out.println("这是元素2");
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}