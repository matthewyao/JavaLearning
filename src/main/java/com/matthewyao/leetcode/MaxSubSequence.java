package com.matthewyao.leetcode;

import com.matthewyao.designpattern.HelloImpl;

/**
 * Created by matthewyao on 2016/12/10.
 */
public class MaxSubSequence {
    public static void main(String[] args) {
        //2 1 6 4 5 2 7 4  =>  1 2 5 7
        int[] inputs = new int[]{1,9,9,2,10000,3,4,2,5,6,7,11,12,3,1,1,2,2,2,4,5,7,8,10,12,17};
//        int[] inputs = new int[]{12,1,2,3,4,23,34,35,54,6,7,2,32};
//        int[] inputs = new int[]{2,1,6,4,5,2,7,4};
//        int res = subSequence(inputs);
//        int res = findFirstLargerIndex(inputs,7,9);
        int res = subseq1(inputs);
        System.out.println(res);
    }

    //O(n2)
    public static int subSequence(int[] inputArray){
        //endMaxArray记录以每一个元素结尾的最长子序列长度
        int[] endMaxArray = new int[inputArray.length];
        int i,j,indexMax,globalMax = 0;
        for (i = 0; i < inputArray.length; i++){
            indexMax = 1;
            for (j = 0; j < i; j++){
                if (inputArray[i] > inputArray[j]){
                    indexMax = Math.max(indexMax, endMaxArray[j] + 1);
                }
            }
            endMaxArray[i] = indexMax;
            globalMax = Math.max(globalMax,indexMax);
        }
        return globalMax;
    }

    //O(nlogN)
    public static int subseq1(int[] arr){
        //endMaxArray记录以每一个元素结尾的最长子序列长度
        int[] l = new int[arr.length];
        int i,j,indexMax,globalMax = 0;
        int index = 0;
        l[0] = arr[0];
        for (i = 1; i < arr.length; i++){
            if (arr[i] > l[index]){
                //1,11,1,2,9,1,2,4,5,7,8,10,12,17
                l[++index] = arr[i];
            }else {
                int firstMaxPos = findFirstLargerIndex(l,index,arr[i]);
                l[firstMaxPos] = arr[i];
            }
        }
        return index + 1;
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
}
