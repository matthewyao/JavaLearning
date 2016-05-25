package com.matthewyao.sikuli.practice.spider;

/**
 * Created by matthewyao on 2016/1/22.
 */
public interface LinkFilter {
    public boolean accept(String url);
}