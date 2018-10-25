package com.matthewyao.concurrent.jvm;

import java.util.ArrayList;

/**
 * @Author: yaokuan
 * @Date: 2018/8/25 下午5:46
 */
public class PermGenOOM {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        int i = 0;
        while (true) {
            strList.add(String.valueOf(i++).intern());
            System.out.println(i);
        }
    }
}
