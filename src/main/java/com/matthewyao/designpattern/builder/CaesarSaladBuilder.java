package com.matthewyao.designpattern.builder;

/**
 * Created by yaokuan on 2018/5/12.
 */
public class CaesarSaladBuilder implements Builder {
    private Salad salad;

    public CaesarSaladBuilder() {
        this.salad = new CaesarSalad();
    }

    @Override
    public void addVegetables() {
        salad.setVegetables("tomato");//西红柿
    }

    @Override
    public void addAmaranth() {
        salad.setAmaranth("roast chicken");//烤鸡肉
    }

    @Override
    public void addSauce() {
        salad.setSauce("yogurt");//酸奶
    }

    @Override
    public Salad buildSalad() {
        addAmaranth();
        addVegetables();
        addSauce();
        return salad;
    }
}
