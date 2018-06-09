package com.matthewyao.designpattern.composite;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class ImageFile extends File {

    public ImageFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Image file: " + getName());
    }
}
