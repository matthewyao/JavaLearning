package com.matthewyao.test;

/**
 * Created by matthewyao on 2016/9/22.
 */
public class TestMultiThread {
    public static boolean execute(String username,String password){
        long beginTime = System.currentTimeMillis();
        //1.先登录
        if (username.equalsIgnoreCase("yk") && password.equalsIgnoreCase("123")){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //2.登录成功查询所有数据
            Thread one = new Thread(){
                public void run(){
                    queryPageAll();
                }
            };
            one.start();
            Thread two = new Thread
            System.out.println(System.currentTimeMillis() - beginTime);
            return true;
        }else {
            return false;
        }
    }

    private static void queryPageAll(){
        try {
            Thread.sleep(10000);
            System.out.println("success query!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

