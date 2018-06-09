package com.matthewyao.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class Folder extends File {

    private List<File> files;

    public Folder(String name) {
        super(name);
        //新创建的文件夹应该是“空”的
        this.files = new ArrayList<File>();
    }

    @Override
    public void display() {
        System.out.println(getName());
        for (File file : files) {
            file.display();
        }
    }

    public void addFile(File file){
        files.add(file);
    }

    public void removeFile(File file) {
        files.remove(file);
    }
}
