package com.matthewyao.java8;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by matthewyao on 2017/1/16.
 */
public class TestLambda {
    public static void main(String[] args) {
        BinaryOperator<Integer> add = (x, y) -> x+y;

        Runnable task = () -> {
            while (true){
                System.out.println("1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t = new Thread(task);
        t.start();
        while (true){
            System.out.println("2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
