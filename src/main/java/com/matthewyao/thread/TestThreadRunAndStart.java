package com.matthewyao.thread;

/**
 * Created by matthewyao on 2016/5/3.
 */
public class TestThreadRunAndStart {
    /**
     * start()是启动线程执行，所以结果不一定谁先谁后
     * 但run()是直接的方法调用，所以会先输出子线程的pong后输出ping
     * */
    public static void main(String[] args) {
        Thread t = new Thread(){
            public void run(){
                pong();
            }
        };
        t.start();
        for (int i=0; i<10; i++) {
            System.out.println("ping");
        }
    }
    static void pong(){
        for (int i=0; i<10; i++) {
            System.out.println("pong");
        }
    }
}
