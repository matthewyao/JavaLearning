package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2017/2/8.
 */
public class L506_RelativeRanks {
    public static void main(String[] args) {
        System.out.println(findRelativeRanks(new int[]{7,2,3,1,9,8,5,4,6}));
    }

    public static String[] findRelativeRanks(int[] nums) {
        quickSort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.print(num+" ");
        }
        return null;
    }

    public static void quickSort(int[] arr,int lo,int hi){
        if (lo >= hi) return;
        int idx = sort(arr,lo,hi);
        quickSort(arr,lo,idx-1);
        quickSort(arr,idx+1,hi);
    }

    public static int sort(int[] arr,int lo, int hi){
        int base = arr[lo];
        while (lo < hi){
            while (arr[hi]>=base && hi>lo){
                hi--;
            }
            arr[lo] = arr[hi];
            while (arr[lo]<=base && lo<hi){
                lo++;
            }
            arr[hi] = arr[lo];
        }
        arr[hi] = base;
        return hi;
    }
}
