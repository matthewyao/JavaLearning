package com.matthewyao.leetcode;

import java.util.*;

/**
 * Created by matthewyao on 2016/9/26.
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                return p1[0]!=p2[0]?Integer.compare(p2[0],p1[0]): Integer.compare(p1[1],p2[1]);
            }
        });
        List<int[]> list = new LinkedList();
        for (int[] ints : people) {
            list.add(ints[1],ints);
        }
        return list.toArray(new int[people.length][]);
    }
}
