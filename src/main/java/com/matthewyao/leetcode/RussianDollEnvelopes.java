package com.matthewyao.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by matthewyao on 2016/12/10.
 */
public class RussianDollEnvelopes {

    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{{1,2},{2,3},{3,4},{3,5},{4,5},{5,5},{5,6},{6,7},{7,8}}));
//        System.out.println(maxEnvelopes(new int[][]{{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}}));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        print(envelopes,envelopes.length);
        int[] l = new int[envelopes.length];
        int index = 0;
        l[index] = envelopes[0][1];
        print(l,index + 1);
        for (int i = 1; i < envelopes.length; i++){
            if (envelopes[i][1] > l[index]){
                l[++index] = envelopes[i][1];
            }else {
                int firstMaxPos = findFirstLargerIndex(l,index,envelopes[i][1]);
                l[firstMaxPos] = envelopes[i][1];
            }
            print(l,index + 1);
        }
        return ++index;
    }

    private static int findFirstLargerIndex(int[] arr, int high, int target){
        int low = 0,middle,aHigh = high;
        while (low <= high){
            middle = (low + high) >> 1;
            if (arr[middle] > target){
                high = middle - 1;
            }else if (arr[middle] < target){
                low = middle + 1;
            }else {
                return middle;
            }
        }
        return Math.min(low,aHigh);
    }

    private static void print(int[][] arr,int length){
        for (int i = 0; i < length; i++){
            System.out.print("("+arr[i][0] + "," + arr[i][1]+"),");
        }
        System.out.println();
    }

    private static void print(int[] arr,int length){
        for (int i = 0; i < length; i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }
}
