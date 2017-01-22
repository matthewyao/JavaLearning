package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2017/1/22.
 */
public class L461_HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(0,5));
    }

    public static int hammingDistance(int x, int y){
        //XOR -- 异或
        int xor = (~x & y) | (x & ~y);
        int oneCount = 0;
        while (xor > 0){
            if ((xor & 1) > 0){
                oneCount++;
            }
            xor = xor >> 1;
        }
        return oneCount;
    }
}
