package com.matthewyao.designpattern.command;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class Control {
    private Command commandOn, commandOff;
    private CommandChangeChannel commandChangeChannel;

    public Control(Command commandOn, Command commandOff, CommandChangeChannel commandChangeChannel) {
        this.commandOn = commandOn;
        this.commandOff = commandOff;
        this.commandChangeChannel = commandChangeChannel;
    }

    public void turnOnTv() {
        commandOn.execute();
    }

    public void turnOffTv() {
        commandOff.execute();
    }

    public void changeChannel(int channel) {
        commandChangeChannel.setChannel(channel);
        commandChangeChannel.execute();
    }
}
