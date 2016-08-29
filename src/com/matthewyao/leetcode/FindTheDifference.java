package com.matthewyao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by matthewyao on 2016/8/29.
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char res = 'a';
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Map<Character,Integer> sm = new HashMap<Character, Integer>();
        Map<Character,Integer> tm = new HashMap<Character, Integer>();
        for (char c : sc){
            if (sm.containsKey(c)){
                sm.put(c,sm.get(c) + 1);
            }else {
                sm.put(c,1);
            }
        }
        for (char c : tc){
            if (tm.containsKey(c)){
                tm.put(c,tm.get(c) + 1);
            }else {
                tm.put(c,1);
            }
        }
        for (Map.Entry<Character, Integer> entry : tm.entrySet()) {
            if (sm.containsKey(entry.getKey())){
                if (entry.getValue() == sm.get(entry.getKey()) + 1){
                    res = entry.getKey();
                }
            }else {
                res = entry.getKey();
            }
        }
        return res;
    }
}
