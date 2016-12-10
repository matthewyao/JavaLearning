package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2016/12/10.
 */
public class MaxSubSequence {
    public static void main(String[] args) {
        //2 1 6 4 5 2 7 4  =>  1 2 5 7
        int[] inputs = new int[]{1,2,3,4,5,6,5,4,7,8,9,4,5,6,7,8,9,1,2,3,4,5,6,9,8,7,6,5,4};
//        int[] inputs = new int[]{12,1,2,4,23,34,35,54,6,7,2,32};
        int res = subSequence(inputs);
        System.out.println(res);
    }

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
}
