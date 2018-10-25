package com.matthewyao.concurrent.jvm;

/**
 * @Author: yaokuan
 * @Date: 2018/8/20 上午8:54
 */
public class StackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackSOF stackSOF = new StackSOF();
        try {
            stackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + stackSOF.stackLength);
            throw e;
        }
    }
}
