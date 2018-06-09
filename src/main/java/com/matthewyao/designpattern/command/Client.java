package com.matthewyao.designpattern.command;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class Client {
    public static void main(String[] args) {
        TV myTv = new TV();

        Command commandOn = new CommandOn(myTv);
        Command commandOff = new CommandOff(myTv);
        CommandChangeChannel commandChangeChannel = new CommandChangeChannel(myTv);

        Control control = new Control(commandOn, commandOff, commandChangeChannel);
        control.turnOnTv();
        control.changeChannel(5);
        control.changeChannel(34);
        control.turnOffTv();
    }
}
