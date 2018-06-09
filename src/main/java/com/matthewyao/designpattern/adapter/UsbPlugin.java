package com.matthewyao.designpattern.adapter;

/**
 * Created by yaokuan on 2018/5/25.
 */
public class UsbPlugin implements USB {
    @Override
    public void isUsb() {
        System.out.println("USB口");
    }
}
