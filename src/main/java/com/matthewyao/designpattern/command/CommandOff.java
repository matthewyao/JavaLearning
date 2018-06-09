package com.matthewyao.designpattern.command;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class CommandOff implements Command {

    private TV tv;

    public CommandOff(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}
