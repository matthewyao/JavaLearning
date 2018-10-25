package com.matthewyao.concurrent.jvm;

/**
 * @Author: yaokuan
 * @Date: 2018/8/25 下午7:14
 * -client
 * -verbose:gc
 * -XX:+PrintGCDetails
 * -XX:+UseSerialGC
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=15
 * -XX:PretenureSizeThreshold=10m
 * -XX:+PrintTenuringDistribution
 */
public class ObjectAge {

    private static final int _MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[2 * _MB];
        allocation2 = new byte[4 * _MB];
        allocation2 = null;
        allocation2 = new byte[4 * _MB];
    }
}
