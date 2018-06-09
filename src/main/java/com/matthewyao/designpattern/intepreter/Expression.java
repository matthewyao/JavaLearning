package com.matthewyao.designpattern.intepreter;

/**
 * Created by yaokuan on 2018/6/9.
 */
public interface Expression {
    boolean interpret(String context);
}
