package com.matthewyao.leetcode;

import java.util.Arrays;

/**
 * Created by matthewyao on 2016/12/18.
 */
public class L453_MinimumMovestoEqualArrayElements {
    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1,4,7,8,4,3,6,8,3}));
    }
    public static int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0],res = 0;
        for (int num : nums) {
            min = Math.min(min,num);
        }
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }
}
