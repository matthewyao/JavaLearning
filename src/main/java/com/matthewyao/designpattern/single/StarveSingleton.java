package com.matthewyao.designpattern.single;

/**
 * Created by yaokuan on 2018/5/5.
 */
public class StarveSingleton {

    private static StarveSingleton singleton = new StarveSingleton();

    public static StarveSingleton getSingleton() {
        return singleton;
    }
}
