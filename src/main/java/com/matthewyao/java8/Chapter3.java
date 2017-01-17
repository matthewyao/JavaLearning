package com.matthewyao.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by matthewyao on 2017/1/17.
 */
public class Chapter3 {
    public static void main(String[] args) {
        List<Integer> nums = IntStream.rangeClosed(1,9).boxed().collect(Collectors.toList());
        long numSmallThanFive = nums.stream().filter(n -> n < 5).count();
        System.out.println("number smaller than five has " + numSmallThanFive);
    }
}
