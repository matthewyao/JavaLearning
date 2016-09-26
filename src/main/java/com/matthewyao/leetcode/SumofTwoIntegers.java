package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2016/8/27.
 */
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        int sum = a;
        if (b == 0) return a;
        while (b != 0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return a;
    }
}
