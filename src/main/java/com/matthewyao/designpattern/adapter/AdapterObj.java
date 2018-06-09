package com.matthewyao.designpattern.adapter;

/**
 * Created by yaokuan on 2018/5/25.
 */
public class AdapterObj implements MicroUSB {
    //以聚合的方式实现适配
    private USB usb;

    public AdapterObj(USB usb) {
        this.usb = usb;
    }

    @Override
    public void isMicroUsb() {
        usb.isUsb();
    }
}
