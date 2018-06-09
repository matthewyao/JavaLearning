package com.matthewyao.designpattern.command;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class TV {
    private int channel = 0;

    public void trunOn() {
        System.out.println("Turn on the tv.");
    }

    public void turnOff() {
        System.out.println("Turn off the tv.");
    }

    public void changeChannel(int channel) {
        this.channel = channel;
        System.out.println("Now the channel is: " + channel);
    }
}
