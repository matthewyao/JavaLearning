package com.matthewyao.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by matthewyao on 2017/2/8.
 */
public class L496_NextGreaterElement_I {
    public static void main(String[] args) {
        int[] res = nextGreaterElement2(new int[]{4,7,3,6,8,9},new int[]{5,3,1,2,8,9,6,4,12,7});
        for (int i : res) {
            System.out.print(i+" ");
        }
    }

    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != findNums[i]){
                    continue;
                }else {
                    int n = -1;
                    for (int k = j+1; k < nums.length; k++) {
                        if (nums[k] > nums[j]){
                            n = nums[k];
                            break;
                        }
                    }
                    res[i] = n;
                }
            }
        }
        return res;
    }

    public static int[] nextGreaterElement2(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
}
