package com.matthewyao.concurrent.jvm;

/**
 * @Author: yaokuan
 * @Date: 2018/8/25 下午6:24
 * -client
 * -verbose:gc
 * -XX:+PrintGCDetails
 * -XX:+UseSerialGC
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:SurvivorRatio=8
 */
public class EdenFirst {

    private static final int _MB = 1024 * 1024;

    private static void testEdenFirst() {
        byte[] allocate1, allocate2, allocate3, allocate4;
        allocate1 = new byte[2 * _MB];
        allocate2 = new byte[2 * _MB];
        allocate3 = new byte[2 * _MB];
        allocate4 = new byte[4 * _MB];
    }

    public static void main(String[] args) {
        testEdenFirst();
    }
}
