package com.matthewyao.sikuli.threadpool;

/**
 * Created by matthewyao on 2016/2/3.
 */
public class MyThread extends Thread{
    @Override
    public void run(){
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(Thread.currentThread().getName() + " is now running...");
    }
}
