package com.matthewyao.sikuli.sort;

/**
 * Created by mosmovon on 16/2/4.
 */
public class SelectSorting {
    /***
     * 选择排序的基本思想是遍历数组的过程中，以 i 代表当前需要排序的序号，
     * 则需要在剩余的 [i…n-1] 中找出其中的最小值，然后将找到的最小值与 i 指向的值进行交换。
     * 因为每一趟确定元素的过程中都会有一个选择最大值的子流程，所以人们形象地称之为选择排序。
     * 选择排序的时间复杂度和空间复杂度分别为 O(n2 ) 和 O(1) 。
     */

    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int miniPost = i;
            for (int m = i + 1; m < arr.length; m++) {
                if (arr[m] < arr[miniPost]) {
                    miniPost = m;
                }
                if (arr[i] > arr[miniPost]) {
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[miniPost];
                    arr[miniPost] = temp;
                }
            }
        }
        return arr;
    }
}
