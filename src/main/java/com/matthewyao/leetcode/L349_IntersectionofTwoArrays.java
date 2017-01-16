package com.matthewyao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by matthewyao on 2016/12/15.
 */
public class L349_IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        set1.retainAll(set2);
        int[] nums3 = new int[set1.size()];
        int i = 0;
        for (Integer integer : set1) {
            nums3[i++] = integer;
        }
        return nums3;
    }
}
