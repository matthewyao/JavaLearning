package com.matthewyao.designpattern.Facade;

/**
 * Created by yaokuan on 2018/5/27.
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        //用户需要打开电脑
        computer.startComputer();
        //用户需要关闭电脑
        computer.shutdownComputer();
    }
}
