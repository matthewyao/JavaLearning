package com.matthewyao.designpattern.iterator;

/**
 * Created by yaokuan on 2018/6/9.
 */
public interface Iterator {
    Object first();

    Object last();

    Object next();

    boolean hasNext();
}
