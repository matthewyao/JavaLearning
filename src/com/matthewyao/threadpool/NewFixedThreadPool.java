package com.matthewyao.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by matthewyao on 2016/2/3.
 */
public class NewFixedThreadPool {
    public static void start(){
        //创建一个单线程的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        pool.shutdown();
    }
}
