package com.matthewyao.leetcode;

import java.util.Arrays;

/**
 * Created by matthewyao on 2016/12/14.
 */
public class L455_AssignCookies {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1,2},new int[]{1,2,3}));
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j=0; j < s.length && i < g.length; j++){
            if (s[j] >= g[i]){
                i++;
            }
        }
        return i;
    }
}
