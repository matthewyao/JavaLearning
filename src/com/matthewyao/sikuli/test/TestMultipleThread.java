package com.matthewyao.sikuli.test;

/**
 * Created by mosmovon on 16/1/30.
 */
public class TestMultipleThread extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName()+" is running!");
    }
}
