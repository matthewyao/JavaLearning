package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2016/8/27.

 344. Reverse String  QuestionEditorial Solution  My Submissions
 Total Accepted: 76567
 Total Submissions: 131207
 Difficulty: Easy
 Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".

 */
public class ReverseString {
    public String reverseString(String s) {
        String rs = new StringBuffer(s).reverse().toString();
        System.out.println(rs);
        return "";
    }
}
