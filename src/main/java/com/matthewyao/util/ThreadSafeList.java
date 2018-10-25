package com.matthewyao.util;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Author: yaokuan
 * @Date: 2018/10/24 下午3:35
 */
public class ThreadSafeList {

    private static List<Integer> arr = new ArrayList<>();
//    private static Vector<Integer> arr = new Vector<>();
//    private static List<Integer> arr = Collections.synchronizedList(new ArrayList<Integer>());
//    private static List<Integer> arr = new CopyOnWriteArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 20, 1, TimeUnit.HOURS, new LinkedBlockingQueue<Runnable>());
        for (int i = 1; i <= 100000; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    synchronized (ThreadSafeList.class) {
                        arr.add(random.nextInt(Integer.MAX_VALUE));
                    }
                }
            });
        }
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("arr size: " + arr.size() + ", cost: " + (System.currentTimeMillis() - start) + " mills");
    }
}

