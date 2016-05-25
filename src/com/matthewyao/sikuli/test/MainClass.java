package com.matthewyao.sikuli.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by matthewyao on 2016/1/29.
 */
public class MainClass {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        for (int i=0;i<10;i++){
            pool.execute(new TestMultipleThread());
        }
        pool.shutdown();
        TestMultipleThread thread = new TestMultipleThread();
        thread.run();
//        TestJavaURL.curl("http://www.baidu.com");
    }
}
