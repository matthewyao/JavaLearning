package com.matthewyao.designpattern.memento;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
