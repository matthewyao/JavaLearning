package com.matthewyao.concurrent.jvm;

import java.util.ArrayList;

/**
 * @Author: yaokuan
 * @Date: 2018/8/18 上午9:20
 * -verbose:gc
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}

