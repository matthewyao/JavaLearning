package com.matthewyao.designpattern.memento;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemen() {
        return new Memento(state);
    }

    public void restoreStateFromMemto(Memento memento) {
        state = memento.getState();
    }
}
