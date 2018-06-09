package com.matthewyao.designpattern.visitor;

import java.util.List;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class Client {
    public static void main(String[] args){
        List<Element> list = ObjectStruture.getList();
        for(Element e: list){
            e.accept(new Visitor());
        }
    }
}