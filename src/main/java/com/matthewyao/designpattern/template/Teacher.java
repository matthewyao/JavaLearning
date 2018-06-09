package com.matthewyao.designpattern.template;

/**
 * Created by yaokuan on 2018/6/6.
 */
public class Teacher extends AbstractPerson {
    @Override
    public void getUp() {
        System.out.println("洗漱、换衣服");
    }

    @Override
    public void eatBreakfast() {
        System.out.println("吃了：面包+鸡蛋");
    }

    @Override
    public void goToWork() {
        System.out.println("开车去学校");
    }
}
