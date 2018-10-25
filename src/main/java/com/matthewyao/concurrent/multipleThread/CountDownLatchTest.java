package com.matthewyao.concurrent.multipleThread;

import org.apache.tools.ant.util.DateUtils;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: yaokuan
 * @Date: 2018/7/7 下午5:22
 */
public class CountDownLatchTest {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s %s was finished", DateUtils.format(new Date(), "hh:mm:ss:SSS"), getName()));
            latch.countDown();
        }
    }
    private static CountDownLatch latch = new CountDownLatch(10);

    public static void main(String[] args) {
        System.out.println(String.format("%s I was main and I'm started", DateUtils.format(new Date(), "hh:mm:ss:SSS")));
        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%s I was main and I'm finished", DateUtils.format(new Date(), "hh:mm:ss:SSS")));
    }
}
