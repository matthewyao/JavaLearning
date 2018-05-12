package com.matthewyao.designpattern.builder;

/**
 * Created by yaokuan on 2018/5/12.
 */
public class FruitSaladBuilder implements Builder {

    private Salad salad;

    public FruitSaladBuilder() {
        this.salad = new FruitSalad();
    }

    @Override
    public void addVegetables() {
        salad.setVegetables("broccoli");//西兰花
    }

    @Override
    public void addAmaranth() {
        salad.setAmaranth("sole file");//龙利鱼
    }

    @Override
    public void addSauce() {
        salad.setSauce("sesame soy");//芝麻酱
    }

    @Override
    public Salad buildSalad() {
        addAmaranth();
        addVegetables();
        addSauce();
        return salad;
    }
}
