package com.matthewyao.designpattern.strategy;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class Zhaoyun {
    public static void main(String[] args) {
        Context liubeiMarry = new Context();

        System.out.println("----------刚到吴国使用第一个锦囊---------------");
        liubeiMarry.setStrategy(new BackDoor());
        liubeiMarry.operate();
        System.out.println();

        System.out.println("----------刘备乐不思蜀使用第二个锦囊---------------");
        liubeiMarry.setStrategy(new GivenGreenLight());
        liubeiMarry.operate();
        System.out.println();


        System.out.println("----------孙权的追兵来了，使用第三个锦囊---------------");
        liubeiMarry.setStrategy(new BlockEnemy());
        liubeiMarry.operate();
        System.out.println();
    }
}
