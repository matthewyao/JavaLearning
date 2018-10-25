package com.matthewyao.concurrent.jvm;

/**
 * @Author: yaokuan
 * @Date: 2018/8/20 上午9:06
 * VM Args: -Xss5M
 */
public class StackOOM {
    private void dontStop() {
        while (true) {
            //Do nothing
        }
    }

    public void stackLeakByThread() {
        int threadCount = 1;
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();//不让GC回收
                }
            });
            thread.start();
            System.out.println("thread start: " + threadCount++);
        }
    }

    public static void main(String[] args) {
        StackOOM stackOOM = new StackOOM();
        stackOOM.stackLeakByThread();
    }
}
