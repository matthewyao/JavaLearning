package com.matthewyao.threadpool;


import java.util.concurrent.*;

/**
 * Created by matthewyao on 2016/2/3.
 */
public class NewSingleThreadExecutor {
    public static void start() {
        //创建一个单线程的线程池
//        ExecutorService pool = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        pool.execute(t1);print(pool);
        pool.execute(t2);print(pool);
        pool.execute(t3);print(pool);
        pool.execute(t4);print(pool);
        pool.execute(t5);print(pool);

        pool.shutdown();
    }

    private static void print(ThreadPoolExecutor pool){
        System.out.println("Active:" + pool.getActiveCount() + ",Complete" + pool.getCompletedTaskCount());
    }
}
