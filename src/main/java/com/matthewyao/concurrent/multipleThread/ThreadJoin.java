package com.matthewyao.concurrent.multipleThread;

import org.apache.tools.ant.util.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: yaokuan
 * @Date: 2018/7/7 下午4:22
 */
public class ThreadJoin {

    private static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s %s was finished", DateUtils.format(new Date(), "hh:mm:ss:SSS"), getName()));
        }
    }

    public static void main(String[] args) {
        System.out.println(String.format("%s I was main and I'm started", DateUtils.format(new Date(), "hh:mm:ss:SSS")));
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
            threads.add(myThread);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("%s I was main and I'm finished", DateUtils.format(new Date(), "hh:mm:ss:SSS")));
    }
}
