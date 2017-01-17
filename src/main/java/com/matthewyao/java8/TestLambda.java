package com.matthewyao.java8;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by matthewyao on 2017/1/16.
 */
public class TestLambda {
    public static void main(String[] args) {
        BinaryOperator<Integer> add = (x, y) -> x+y;

        ThreadLocal<List<String>> strings = ThreadLocal.withInitial(ArrayList::new);
        strings.get();

        ThreadLocal<DateFormatter> threadSafeFormatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("yyyy-MM-dd")));

        Runnable helloworld = () -> System.out.println("hello world");

        JButton button = new JButton();
        button.addActionListener(event -> System.out.println(event.getActionCommand()));

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
