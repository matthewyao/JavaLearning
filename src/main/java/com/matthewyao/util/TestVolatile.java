package com.matthewyao.util;

/**
 * Created by matthewyao on 2016/5/4.
 */
public class TestVolatile {

    public static void main(String[] args) throws InterruptedException {

        while (true){
            final VolatileUtil v = new VolatileUtil();
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    v.a= 1;
                    v.x = v.b;
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    v.b = 1;
                    v.y = v.a;
                }
            });
            t2.start();
            t1.start();
            t1.join();
            t2.join();
//            System.out.println(v.a + "" + v.b + "" + v.x + "" + v.y);
            if (v.x == 0 && v.y == 0){
                System.out.println("x and y both are zero!");
            }
        }
    }

}

