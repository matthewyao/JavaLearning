package com.matthewyao.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by matthewyao on 2016/9/28.
 */
public class SingleNumberThree {

    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        int[] arr = new int[set.size()];
        int index = 0;
        for (Integer val : set){
            arr[index++] = val;
        }
        return arr;
    }

}
