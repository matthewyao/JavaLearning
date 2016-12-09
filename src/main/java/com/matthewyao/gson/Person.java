package com.matthewyao.gson;

/**
 * Created by matthewyao on 2016/11/24.
 */
public class Person {
    private String name;
    private int age;
    private String sex;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("My name is ").append(name).append(",I am ").append(age).append(" years old.");
        return sb.toString();
    }
}
