package com.matthewyao.designpattern.decorate;

/**
 * Created by yaokuan on 2018/5/1.
 */
public abstract class Salad {

    private int scale;//1-小份，2-中份（加3元），3-大份（加5元）

    protected int getScale() {
        return scale;
    }

    public Salad setScale(int scale) {
        this.scale = scale;
        return this;
    }

    protected abstract String getName();//获取名称

    protected abstract double getPrice();//获取价格

    //抽象类相比接口可以实现具体的方法，避免逐个修改
    protected String getDesc() {
        return "直接吃也是可以的哦";
    }
}
