package com.matthewyao.sort;

/**
 * Created by mosmovon on 16/2/4.
 */
public class InsertSorting {
    public static int[] InsertSort(int[] array){
        for (int i=1;i<array.length;i++){
            int temp = array[i],j;
            for (j = i - 1;j >= 0 && temp<array[j];j--){
                array[j+1] = array[j];
            }
            array[j+1] = temp;
        }
        return array;
    }
}
