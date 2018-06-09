package com.matthewyao.designpattern.adapter;

/**
 * Created by yaokuan on 2018/5/25.
 */
public class Test {
    public static void main(String[] args) {
        UsbPlugin up = new UsbPlugin();
        AdapterObj adapter = new AdapterObj(up);
        System.out.print("通过对象适配器：");
        adapter.isMicroUsb();

        AdapterClass adapterClass = new AdapterClass();
        System.out.print("通过类适配器：");
        adapterClass.isMicroUsb();
    }
}
