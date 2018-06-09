package com.matthewyao.designpattern.state;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString() {
        return "Stop State";
    }
}
