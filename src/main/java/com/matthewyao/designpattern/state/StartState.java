package com.matthewyao.designpattern.state;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString() {
        return "Start State";
    }
}
