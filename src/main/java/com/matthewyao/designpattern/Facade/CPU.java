package com.matthewyao.designpattern.Facade;

/**
 * Created by yaokuan on 2018/5/27.
 */
public class CPU {
    public void startCPU() {
        System.out.println("CPU is started");
    }

    public void shutdownCPU() {
        System.out.println("CPU is shutdown");
    }
}
