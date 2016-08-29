package com.matthewyao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by matthewyao on 2016/8/29.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> intSet = new HashSet<Integer>();
        for (int num : nums) {
            if (intSet.contains(num)){
                intSet.remove(num);
            }else {
                intSet.add(num);
            }
        }
        return intSet.iterator().next();
    }
}
