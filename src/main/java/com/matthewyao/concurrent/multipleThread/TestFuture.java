package com.matthewyao.concurrent.multipleThread;


import javafx.concurrent.Task;

import java.util.concurrent.*;

/**
 * @Author: yaokuan
 * @Date: 2018/8/11 下午9:50
 */
public class TestFuture {

    private static final int CORE_POOL_SIZE = 1;
    private static final int MAX_POOL_SIZE = 1;
    private static final long KEEP_ALIVE_TIME = 1000;

    public static void main(String[] args) {
        TestFuture testFuture = new TestFuture();
        try {
            testFuture.test();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void test() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new ThreadPoolExecutor.CallerRunsPolicy());//调用者运行

        Future future = threadPoolExecutor.submit(new MyTask());

        System.out.println(System.currentTimeMillis() + ", waiting for task begin...");
        System.out.println(future.get());
        System.out.println(System.currentTimeMillis() + ", waiting for task done...");
    }

    private class MyTask implements Callable{
        @Override
        public Object call() throws Exception {
            //Do a lot of stuff
            Thread.sleep(5000);
            return "The Callable is Done";
        }
    }

    private class RunTask implements Runnable{
        @Override
        public void run() {
            //Returns nothing
        }
    }
}
