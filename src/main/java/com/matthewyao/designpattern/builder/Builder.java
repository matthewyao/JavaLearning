package com.matthewyao.designpattern.builder;

/**
 * Created by yaokuan on 2018/5/12.
 */
public interface Builder {

    void addVegetables();

    void addAmaranth();

    void addSauce();

    Salad buildSalad();
}
