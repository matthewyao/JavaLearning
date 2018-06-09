package com.matthewyao.designpattern.template;

/**
 * Created by yaokuan on 2018/6/6.
 */
public class Programmer extends AbstractPerson {
    @Override
    public void getUp() {
        System.out.println("玩手机、刷牙");
    }

    @Override
    public void eatBreakfast() {
        System.out.println("随便吃一点");
    }

    @Override
    public void goToWork() {
        System.out.println("肯定是挤地铁去上班啊");
    }
}
