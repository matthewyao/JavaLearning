package com.matthewyao.work;

/**
 * Created by yaokuan on 2017/12/1.
 */
public class TestContains {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i=10000000; i< 20000000; i++){
            sb.append(i).append(",");
        }
        String str = sb.toString();
        long start = System.currentTimeMillis();
        boolean b = str.contains("19000001");
        long end = System.currentTimeMillis();
//        System.out.println(str);
        System.out.println("start:" + start + ", end:" + end + ", cost:" + (end - start) + ", res:" + b);
    }
}
