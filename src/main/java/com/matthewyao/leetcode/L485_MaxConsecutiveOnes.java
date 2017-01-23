package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2017/1/23.
 */
public class L485_MaxConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,0,1,0,1,1,1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0,maxSum = 0;
        for (int num : nums) {
            if (num == 1){
                sum++;
            }else {
                maxSum = Math.max(maxSum,sum);
                sum = 0;
            }
        }
        return Math.max(maxSum,sum);
    }
}
