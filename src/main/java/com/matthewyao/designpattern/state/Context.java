package com.matthewyao.designpattern.state;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class Context {
    private State state;

    public Context() {
        state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
