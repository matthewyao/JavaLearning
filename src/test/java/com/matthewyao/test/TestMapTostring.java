package com.matthewyao.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by matthewyao on 2016/11/1.
 */
public class TestMapTostring {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("test1",1);
        map.put("test2",2);
        map.put("test3",3);
        map.put("test4",4);
        System.out.println(map.toString().replace("{","[").replace("}","]"));
    }
}
