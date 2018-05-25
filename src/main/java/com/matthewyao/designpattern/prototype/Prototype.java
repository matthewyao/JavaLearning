package com.matthewyao.designpattern.prototype;

/**
 * Created by yaokuan on 2018/5/13.
 */
public abstract class Prototype implements Cloneable {

    public Prototype clone() {
        Prototype prototype = null;
        try {
            prototype = (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }

    public abstract void show();
}
