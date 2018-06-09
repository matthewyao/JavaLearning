package com.matthewyao.designpattern.composite;

/**
 * Created by yaokuan on 2018/6/2.
 */
public abstract class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void display();
}
