package com.matthewyao.designpattern.decorate;

/**
 * Created by yaokuan on 2018/5/1.
 */
public class FishDecorator extends SaladDecorator {

    private Salad salad;

    public FishDecorator(Salad salad) {
        this.salad = salad;
    }

    @Override
    protected String getName() {
        return salad.getName() + "加龙利鱼";
    }

    @Override
    protected double getPrice() {
        return salad.getPrice() + 8;
    }
}
