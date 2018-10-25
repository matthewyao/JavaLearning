package com.matthewyao.concurrent.multipleThread;

import org.apache.tools.ant.util.DateUtils;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: yaokuan
 * @Date: 2018/7/7 下午5:49
 */
public class CycleBarrierTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    private static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s %s was finished", DateUtils.format(new Date(), "hh:mm:ss:SSS"), getName()));
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws BrokenBarrierException {
        System.out.println(String.format("%s I was main and I'm started", DateUtils.format(new Date(), "hh:mm:ss:SSS")));
        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cyclicBarrier.reset();
        System.out.println(String.format("%s I was main and I'm finished", DateUtils.format(new Date(), "hh:mm:ss:SSS")));
    }
}
