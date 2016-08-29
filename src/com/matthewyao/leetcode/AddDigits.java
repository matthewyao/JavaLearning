package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2016/8/29.
 */
public class AddDigits {
    public int addDigits(int num) {
        int sum = sum(num);
        while (sum > 9){
            sum = sum(sum);
        }
        return sum;
    }

    public int sum(int num){
        int sum = 0;
        while (num > 0){
            sum += (num%10);
            num /= 10;
        }
        return sum;
    }
}
