package com.matthewyao.concurrent;

/**
 * Created by yaokuan on 2017/5/5.
 */
public class ThreadMocker {

    public static void main(String[] args) {
        int i = 100;
        while (true){
            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    RecorderExample.reader();
                }
            });

            Thread t2 = new Thread(new Runnable() {
                public void run() {
                    RecorderExample.writer();
                }
            });

            t1.start();
            t2.start();
        }
    }

}
