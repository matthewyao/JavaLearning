package com.matthewyao.designpattern.template;

/**
 * Created by yaokuan on 2018/6/6.
 */
public class Client {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        System.out.println("老师如果度过上午：");
        teacher.spendAfternoon();

        Programmer programmer = new Programmer();
        System.out.println("程序员如果度过上午：");
        programmer.spendAfternoon();

        Children children = new Children();
        System.out.println("小孩如果度过上午：");
        children.spendAfternoon();
    }
}
