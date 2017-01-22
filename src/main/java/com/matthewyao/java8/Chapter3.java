package com.matthewyao.java8;

import org.apache.commons.httpclient.util.DateUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by matthewyao on 2017/1/17.
 */
public class Chapter3 {
    public static void main(String[] args) {
//        List<Integer> nums = IntStream.rangeClosed(1,9).boxed().collect(Collectors.toList());
//        long numSmallThanFive = nums.stream().filter(n -> n < 5).count();
//        System.out.println("number smaller than five has " + numSmallThanFive);
        addUp(Stream.of(1,2,5,6,4,2,2,4));
    }

    public static void addUp(Stream<Integer> numbers){
        int sum = numbers.reduce(0,(acc,i) -> acc + i);
        System.out.println(sum);
    }
}
