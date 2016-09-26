package com.matthewyao.threadpool;


import java.util.concurrent.*;

/**
 * Created by matthewyao on 2016/2/3.
 */
public class NewSingleThreadExecutor {
    public static void start() {
        //����һ�����̵߳��̳߳�
//        ExecutorService pool = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10,
                5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());

        for (int i=0;i<1000;i++){
            Thread t1 = new MyThread();
            pool.execute(t1);
            print(pool);
        }

        pool.shutdown();
    }

    private static void print(ThreadPoolExecutor pool){
        System.out.println(
                " Active:" + pool.getActiveCount() +
                " Core:" + pool.getCorePoolSize() +
                " Pool size:" + pool.getPoolSize() + //Current pool size
                " Complete:" + pool.getCompletedTaskCount() +
                " Largest:" + pool.getLargestPoolSize() +
                " Max:" + pool.getMaximumPoolSize() +
                " Queue:" + pool.getQueue().size() +
                " Task Count:" + pool.getTaskCount()
        );
    }
}
