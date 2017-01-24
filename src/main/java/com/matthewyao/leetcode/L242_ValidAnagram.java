package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2017/1/24.
 */
public class L242_ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("rat","car"));
    }

    public static boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        int[] charArr = new int[26];
        for (char c : chars) {
            charArr[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            charArr[c-'a']--;
        }
        for (int i : charArr) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
