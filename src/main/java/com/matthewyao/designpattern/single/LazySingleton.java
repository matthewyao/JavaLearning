package com.matthewyao.designpattern.single;

/**
 * Created by yaokuan on 2018/5/5.
 */
public class LazySingleton {

    public LazySingleton() {
        System.out.println("init LazySingleton");
    }

    private static class LazyHolder {
        public static final LazySingleton SINGLETON = new LazySingleton();
    }

    public static LazySingleton getSingleton() {
        System.out.println("getSingleton");
        return LazyHolder.SINGLETON;
    }

    public static void main(String[] args) {
        LazySingleton.getSingleton();
    }
}
