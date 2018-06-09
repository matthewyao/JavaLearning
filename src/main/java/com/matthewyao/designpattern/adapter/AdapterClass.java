package com.matthewyao.designpattern.adapter;

/**
 * Created by yaokuan on 2018/5/25.
 */
public class AdapterClass extends UsbPlugin implements MicroUSB {
    //以继承的方式实现适配
    @Override
    public void isMicroUsb() {
        super.isUsb();
    }
}
