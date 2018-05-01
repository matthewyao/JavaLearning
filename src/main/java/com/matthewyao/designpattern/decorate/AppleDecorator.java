package com.matthewyao.designpattern.decorate;

/**
 * Created by yaokuan on 2018/5/1.
 */
public class AppleDecorator extends SaladDecorator {

    private Salad salad;

    public AppleDecorator(Salad salad) {
        this.salad = salad;
    }

    @Override
    protected String getName() {
        return salad.getName() + "加苹果";
    }

    @Override
    protected double getPrice() {
        return salad.getPrice() + 5;
    }
}
