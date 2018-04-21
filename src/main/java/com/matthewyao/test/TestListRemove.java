package com.matthewyao.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by matthewyao on 2017/2/10.
 */
public class TestListRemove {
    public static void main(String[] args) {
        /**一种新的list remove方法*/
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8));
        System.out.println("before | "+list);
        for(int i=0;i<list.size();i++){
            if (list.get(i) % 3 == 0){
                list.remove(i--);
            }
        }
        System.out.println("after | "+list);
        System.out.println(list.size());
    }
}
