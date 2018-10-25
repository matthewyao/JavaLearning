package com.matthewyao.concurrent.multipleThread;

import java.util.concurrent.*;

/**
 * @Author: yaokuan
 * @Date: 2018/10/25 上午10:34
 */
public class SyncMultiThread {

    private static ThreadPoolExecutor threadPoolExecutor;
    private static final int SLEEP_MILLS = 5;

    static {
        threadPoolExecutor = new ThreadPoolExecutor(5, 20, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Begin to count");
        final CountDownLatch latch = new CountDownLatch(1000);
        for (int i = 1; i <= 1000; i++) {
            final int num = i;
            multiCount(latch, num);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("phase one end, cost: " + (System.currentTimeMillis() - start) + " mills");

        start = System.currentTimeMillis();
        final CountDownLatch latch2 = new CountDownLatch(1000);
        for (int i = 1001; i <= 2000; i++) {
            final int num = i;
            multiCount(latch2, num);
        }
        try {
            latch2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("phase two end, cost: " + (System.currentTimeMillis() - start) + " mills");
    }

    private static void multiCount(final CountDownLatch latch, final int num) {
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(num);
                try {
                    Thread.sleep(SLEEP_MILLS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        });
    }
}
