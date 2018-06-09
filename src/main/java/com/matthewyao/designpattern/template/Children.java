package com.matthewyao.designpattern.template;

/**
 * Created by yaokuan on 2018/6/6.
 */
public class Children extends AbstractPerson {
    @Override
    public void getUp() {
        System.out.println("被妈妈叫起来、换衣服");
    }

    @Override
    public void eatBreakfast() {
        System.out.println("吃妈妈做的爱心早餐");
    }

    @Override
    public void goToWork() {
        System.out.println("坐校车去上学");
    }
}
