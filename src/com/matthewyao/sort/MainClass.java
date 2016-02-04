package com.matthewyao.sort;

/**
 * Created by mosmovon on 16/2/4.
 */
public class MainClass {
    public static void main(String[] args) {
        int[] initArray = {3,2,7,1,8,3,9,2,54,24,67,34,22},sortArray;
        sortArray = InsertSorting.InsertSort(initArray);
        System.out.println(sortArray);
    }
}
