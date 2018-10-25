package com.matthewyao.concurrent.multipleThread;

/**
 * @Author: yaokuan
 * @Date: 2018/8/11 下午10:51
 */
public class PossibleReordering {

    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        PossibleReordering possibleReordering = new PossibleReordering();
        possibleReordering.test();
    }

    private void test() throws InterruptedException {
        while (true) {
            Thread threadOne = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });
            Thread threadTwo = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            threadOne.start();
            threadTwo.start();
            threadOne.join();
            threadTwo.join();
            if (x == 0 && y == 0) {
                System.out.println("x: " + x + ", y:" + y);
            }
        }
    }
}
