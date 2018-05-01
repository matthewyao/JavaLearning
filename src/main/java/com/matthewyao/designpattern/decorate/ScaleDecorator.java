package com.matthewyao.designpattern.decorate;

/**
 * Created by yaokuan on 2018/5/1.
 */
public class ScaleDecorator extends SaladDecorator {

    private Salad salad;

    public ScaleDecorator(Salad salad) {
        this.salad = salad;
    }

    @Override
    protected String getName() {
        String scale = "";
        switch (salad.getScale()) {
            case 1:
                scale = "小份";
                break;
            case 2:
                scale = "中份";
                break;
            case 3:
                scale = "大份";
                break;
        }
        return salad.getName() + scale;
    }

    @Override
    protected double getPrice() {
        double price = 0;
        switch (salad.getScale()) {
            case 1:
                price = 0;
                break;
            case 2:
                price = 3;
                break;
            case 3:
                price = 5;
                break;
        }
        return salad.getPrice() + price;
    }
}
