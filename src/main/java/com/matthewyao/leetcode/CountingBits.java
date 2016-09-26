package com.matthewyao.leetcode;

/**
 * Created by mosmovon on 16/9/26.
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] arr = new int[num+1];
        for(int i=0;i<=num;i++){
            arr[i] = getBits(i);
        }
        return arr;
    }

    private int getBits(int n){
        int sum = 0;
        while(n>0){
            if((n - (n >> 1) * 2) > 0){
                sum++;
            }
            n = n >> 1;
        }
        return sum;
    }
}
