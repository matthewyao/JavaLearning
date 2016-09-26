package com.matthewyao.leetcode;

/**
 * Created by mosmovon on 16/9/26.
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] arr = new int[num];
        for(int i=0;i<=num;i++){
            arr[i] = getBits(i);
        }
        return arr;
    }

    private int getBits(int n){
        int sum = 0;
        while(n>0){
            if(n%2 == 1){
                sum++;
            }
            n = n - n%2;
        }
        return sum;
    }
}
