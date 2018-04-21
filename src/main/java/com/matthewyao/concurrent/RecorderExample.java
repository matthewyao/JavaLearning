package com.matthewyao.concurrent;

/**
 * Created by yaokuan on 2017/5/5.
 */
public class RecorderExample {

    static int a = 0;
    static boolean flag = false;

    public static void writer(){
        a = 1;
        flag = true;
    }

    public static void reader(){
        if (flag){
            int i = a * a;
            if (i == 0){
                System.out.println("i=" + i);
            }
        }
    }
}
