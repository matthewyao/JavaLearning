package com.matthewyao.designpattern.decorate;

/**
 * Created by yaokuan on 2018/5/1.
 */
public class EggDecorator extends SaladDecorator {

    private Salad salad;

    public EggDecorator(Salad salad) {
        this.salad = salad;
    }

    @Override
    protected String getName() {
        return salad.getName() + "加鸡蛋";
    }

    @Override
    protected double getPrice() {
        return salad.getPrice() + 3;
    }
}
