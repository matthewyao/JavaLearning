package com.matthewyao.sikuli.threadpool;

/**
 * Created by matthewyao on 2016/2/3.
 */
public class MainClass {
    public static void main(String[] args) {
        //Single thread pool test
        NewSingleThreadExecutor.start();
        //Fixed thread pool test
//        NewFixedThreadPool.start();
        //Cached thread pool test
//        NewCachedThreadPool.start();
        //Scheduled thread pool test
//        NewScheduledThreadPool.start();
    }
}
