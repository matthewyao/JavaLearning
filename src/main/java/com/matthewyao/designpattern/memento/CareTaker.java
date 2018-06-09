package com.matthewyao.designpattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void saveState(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
