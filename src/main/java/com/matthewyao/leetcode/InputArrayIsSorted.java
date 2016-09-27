package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2016/9/27.
 */
public class InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[]{0,0};
        for(int i=0;i<numbers.length;i++){
            int index = findNum(numbers,target - numbers[i]);
            if(index > 0){
                if(i == index){
                    index++;
                }
                arr[0] = i + 1;
                arr[1] = index + 1;
                break;
            }
        }
        return arr;
    }

    private int findNum(int[] numbers,int n){
        int start = 0,end = numbers.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(n == numbers[mid]){
                return mid;
            }else if(n > numbers[mid]){
                start = mid + 1;
            }else if(n < numbers[mid]){
                end = mid - 1;
            }
        }
        return -1;
    }
}
