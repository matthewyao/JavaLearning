package com.matthewyao.designpattern.visitor;

/**
 * Created by yaokuan on 2018/6/9.
 */
interface IVisitor {
    public void visit(ConcreteElement1 el1);
    public void visit(ConcreteElement2 el2);
}