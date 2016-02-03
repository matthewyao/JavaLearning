package com.matthewyao.threadpool;

/**
 * Created by matthewyao on 2016/2/3.
 */
public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is now running...");
    }
}
