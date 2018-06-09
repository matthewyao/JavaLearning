package com.matthewyao.designpattern.template;

/**
 * Created by yaokuan on 2018/6/6.
 */
public abstract class AbstractPerson {
    //final修饰防止被修改
    public final void spendAfternoon() {
        getUp();
        eatBreakfast();
        goToWork();
        System.out.println();
    }

    public abstract void getUp();

    public abstract void eatBreakfast();

    public abstract void goToWork();

}
