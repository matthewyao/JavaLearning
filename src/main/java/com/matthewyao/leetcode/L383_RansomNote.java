package com.matthewyao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by matthewyao on 2016/12/14.
 */
public class L383_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] t = new int[26];
        for (char m : magazine.toCharArray()){
            t[m - 97]++;
        }
        for (char n : ransomNote.toCharArray()) {
            t[n - 97]--;
            if (t[n - 97] < 0){
                return false;
            }
        }
        return true;
    }
}
