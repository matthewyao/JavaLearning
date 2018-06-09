package com.matthewyao.designpattern.visitor;

/**
 * Created by yaokuan on 2018/6/9.
 */
abstract class Element {
    public abstract void accept(IVisitor visitor);
    public abstract void doSomething();
}
