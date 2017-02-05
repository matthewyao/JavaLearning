package com.matthewyao.leetcode;

import java.util.Arrays;

/**
 * Created by matthewyao on 2017/1/24.
 */
public class L169_MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,5,6,3,2,3,4,3,3,3,2,1,2,3,4,3,3}));
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
