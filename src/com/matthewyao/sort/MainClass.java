package com.matthewyao.sort;

/**
 * Created by mosmovon on 16/2/4.
 */
public class MainClass {
    public static void main(String[] args) {
        int[] initArray = {3,2,7,1,8,3,9,2,54,24,67,34,22},sortArray;
        System.out.print("Before sort:");
        for (int a:initArray) {
            System.out.print(a + " ");
        }
        System.out.println();
//        sortArray = InsertSorting.sort(initArray);
//        sortArray = SelectSorting.sort(initArray);
//        sortArray = BubbleSorting.sort(initArray);
//        sortArray = QuickSorting.sort(initArray);
//        sortArray = MergeSorting.sort(initArray);
//        sortArray = ShellSorting.sort(initArray);
        sortArray = HeapSorting.sort(initArray);
        System.out.print("After sort:");
        for (int a: sortArray) {
            System.out.print(a + " ");
        }
    }
}
