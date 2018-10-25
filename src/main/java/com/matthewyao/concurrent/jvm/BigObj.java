package com.matthewyao.concurrent.jvm;

/**
 * @Author: yaokuan
 * @Date: 2018/8/25 下午7:01
 * -client
 * -verbose:gc
 * -XX:+PrintGCDetails
 * -XX:+UseSerialGC
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3m
 */
public class BigObj {

    private static final int _MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation = new byte[4 * _MB];
    }
}
