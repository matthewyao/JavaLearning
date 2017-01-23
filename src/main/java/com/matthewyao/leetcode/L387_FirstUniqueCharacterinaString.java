package com.matthewyao.leetcode;

import java.util.HashSet;

/**
 * Created by matthewyao on 2017/1/23.
 */
public class L387_FirstUniqueCharacterinaString {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        int[] cTimes = new int[26];
        for (char c : s.toCharArray()) {
            cTimes[c-'a']++;
        }
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            char c = chars[i];
            if (cTimes[c-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
