package com.matthewyao.concurrent;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by matthewyao on 2016/10/27.
 */
public class TestAtomicInteger {

    private static AtomicInteger race = new AtomicInteger();

    public static void increse(){
        //由于race++并不是原子操作，所以存在其他线程将脏数据写回主内存
        race.incrementAndGet();
    }

    private static final int THREAD_COUNT = 30;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i=0; i<THREAD_COUNT; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<9000000; i++){
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

        //正常情况下每个线程都加了10000次，结果理应为200000，但由于自增非原子性，结果总会比200000小
        System.out.println(race);
        System.out.println("cost: " + (System.currentTimeMillis() - start ) + " mills");
    }
}
