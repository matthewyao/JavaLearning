package com.matthewyao.designpattern.composite;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class TextFile extends File {

    public TextFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Text file: " + getName());
    }
}
