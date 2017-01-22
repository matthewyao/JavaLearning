package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2017/1/22.
 */
public class L476_NumberComplement {
    public static void main(String[] args) {
        System.out.println(findComplement(1));
    }

    public static int findComplement(int num) {
        if (num == 0) return 1;
        int x = ~num;
        int xx = x,index = 0,y = 1;
        while (num > 0){
            index++;
            num = num >> 1;
        }
        while (index-- > 0){
            y = y << 1;
        }
        y--;
        return x & y;
    }
}
