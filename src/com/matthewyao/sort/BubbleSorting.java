package com.matthewyao.sort;

/**
 * Created by mosmovon on 16/2/4.
 */
public class BubbleSorting {
    public static int[] sort(int[] arr){
        for (int i=0;i<=arr.length;i++){
            for (int j=i+1;j<=arr.length;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
