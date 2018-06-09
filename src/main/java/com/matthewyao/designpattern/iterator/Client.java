package com.matthewyao.designpattern.iterator;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class Client {
    public static void main(String[] args) {
        Object[] objects = new Object[]{"Hello", "world", "I", "am", "Java"};
        MyCollection myCollection = new MyCollection(objects);
        Iterator its = myCollection.iterator();
        while (its.hasNext()) {
            Object next = its.next();
            System.out.print(next);
            System.out.print(" ");
        }
        System.out.println();

        System.out.println(its.first());
        System.out.println(its.last());
    }
}
