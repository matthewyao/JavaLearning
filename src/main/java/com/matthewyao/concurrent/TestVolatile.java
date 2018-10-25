package com.matthewyao.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by matthewyao on 2016/10/27.
 */
public class TestVolatile {

    public static volatile int race = 0;

    public static void increse(){
        race++;
    }

    private static final int THREAD_COUNT = 30;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i=0; i<THREAD_COUNT; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<10000; i++){
                        increse();
                    }
                }
            });
            threads[i].start();
        }

        //每次当主线程执行到这里的时候，主线程让出CPU资源，让所有线程（包括主线程）竞争CPU资源
        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        //正常情况下每个线程都加了10000次，结果理应为300000，但由于自增非原子性，结果总会比300000小
        System.out.println(race);
        System.out.println("cost: " + (System.currentTimeMillis() - start ) + " mills");
    }
}
