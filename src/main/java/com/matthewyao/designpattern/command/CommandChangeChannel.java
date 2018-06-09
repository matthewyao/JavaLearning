package com.matthewyao.designpattern.command;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class CommandChangeChannel implements Command {

    private TV tv;
    private int channel;

    public CommandChangeChannel(TV tv) {
        this.tv = tv;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void execute() {
        tv.changeChannel(channel);
    }
}
