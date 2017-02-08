package com.matthewyao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by matthewyao on 2017/2/8.
 */
public class L500_KeyboardRow {
    public static void main(String[] args) {
        String[] strs = findWords(new String[]{"qwefasdbgwer"});
        for (String str : strs) {
            System.out.println(str);
        }
    }

    public static String[] findWords(String[] words) {
        Map<Character,Integer> charRowMap = new HashMap<>();
        charRowMap.put('Q',1);
        charRowMap.put('W',1);
        charRowMap.put('E',1);
        charRowMap.put('R',1);
        charRowMap.put('T',1);
        charRowMap.put('Y',1);
        charRowMap.put('U',1);
        charRowMap.put('I',1);
        charRowMap.put('O',1);
        charRowMap.put('P',1);
        charRowMap.put('A',2);
        charRowMap.put('S',2);
        charRowMap.put('D',2);
        charRowMap.put('F',2);
        charRowMap.put('G',2);
        charRowMap.put('H',2);
        charRowMap.put('J',2);
        charRowMap.put('K',2);
        charRowMap.put('L',2);
        charRowMap.put('Z',3);
        charRowMap.put('X',3);
        charRowMap.put('C',3);
        charRowMap.put('V',3);
        charRowMap.put('B',3);
        charRowMap.put('N',3);
        charRowMap.put('M',3);
        List<String> resList = new ArrayList<>();
        for (String word : words) {
            if (word.length() == 1){
                resList.add(word);
                continue;
            }
            int firstRow = charRowMap.get(Character.toUpperCase(word.charAt(0)));
            boolean flag = true;
            for (int i = 1; i < word.length(); i++) {
                if (charRowMap.get(Character.toUpperCase(word.charAt(i))) != firstRow){
                    flag = false;
                    break;
                }
            }
            if (flag){
                resList.add(word);
            }
        }
        return resList.toArray(new String[0]);
    }
}
