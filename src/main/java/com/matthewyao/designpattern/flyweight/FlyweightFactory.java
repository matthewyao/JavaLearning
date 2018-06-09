package com.matthewyao.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<String, Flyweight>();

    public FlyweightFactory() {
    }

    public Flyweight getFlyweight(String str) {
        Flyweight flyweight = flyweights.get(str);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(str);
            flyweights.put(str, flyweight);
        }
        return flyweight;
    }

    public int getFlyweightSize() {
        return flyweights.size();
    }
}
