package com.matthewyao.concurrent;


/**
 * Created by matthewyao on 2016/10/27.
 */
public class TestConstructor {

    private static int x;

    static {
        System.out.println("static field..." + System.currentTimeMillis());
    }

    {
        System.out.println("before construct..." + System.currentTimeMillis());
    }

    public TestConstructor(){
        System.out.println("Constructor..." + System.currentTimeMillis());
    }

    public static void main(String[] args) {
        TestConstructor testConstructor = new TestConstructor();
    }
}
