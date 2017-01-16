package com.matthewyao.test;

/**
 * Created by matthewyao on 2016/12/19.
 */
public class TestDefaultValue {
    public static void main(String[] args) {
        String[] a = new String[10];
        int[] b = new int[10];
        for (String s : a) {
            System.out.print(s);
        }
        System.out.println();
        for (int i : b) {
            System.out.print(i);
        }
    }
}
