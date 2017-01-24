package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2017/1/23.
 */
public class L171_ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }

    public static int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            sum = (sum * 26 + (c - 'A' + 1));
        }
        return sum;
    }
}
