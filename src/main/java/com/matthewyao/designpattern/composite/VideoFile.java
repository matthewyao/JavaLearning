package com.matthewyao.designpattern.composite;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class VideoFile extends File {
    public VideoFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Video file: " + getName());
    }
}
