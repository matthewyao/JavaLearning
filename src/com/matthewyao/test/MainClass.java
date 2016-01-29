package com.matthewyao.test;

/**
 * Created by matthewyao on 2016/1/29.
 */
public class MainClass {
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new TestMultipleThread().run();
        }
//        TestMultipleThread thread = new TestMultipleThread();
//        thread.run();
//        TestJavaURL.curl("http://www.baidu.com");
    }
}
