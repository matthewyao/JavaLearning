package com.matthewyao.sort;

/**
 * Created by mosmovon on 16/2/4.
 */
public class ShellSorting {

    /**
     * 希尔排序的诞生是由于插入排序在处理大规模数组的时候会遇到需要移动太多元素的问题。希尔排序的思想是将一个大的数组“分而治之”，划分为若干个小的数组。
     * 以 gap 来划分，比如数组 [1, 2, 3, 4, 5, 6, 7, 8] ，如果以 gap = 2 来划分，可以分为 [1, 3, 5, 7] 和 [2, 4, 6, 8] 两个数组
     *（对应的，如 gap = 3 ， 则划分的数组为： [1, 4, 7] 、 [2, 5, 8] 、 [3, 6] ）然后分别对划分出来的数组进行插入排序，
     * 待各个子数组排序完毕之后再减小 gap 值重复进行之前的步骤，直至 gap = 1 ，即对整个数组进行插入排序。
     * 此时的数组已经基本上快排好序了，所以需要移动的元素会很小很小，解决了插入排序在处理大规模数组时较多移动次数的问题，希尔排序是插入排序的改进版，
     * 在数据量大的时候对效率的提升帮助很大，数据量小的时候建议直接使用插入排序就好了。
     * */

    /**
     * @param int 未排序数组
     * @return int 排完序数组
     */

    public static int[] sort(int[] array) {
        // 取增量
        int step = array.length / 2;
        while (step >= 1) {
            for (int i = step; i < array.length; i++) {
                int temp = array[i];
                int j = 0;
                // 跟插入排序的区别就在这里
                for (j = i - step; j >= 0 && temp < array[j]; j -= step) {
                    array[j + step] = array[j];
                }
                array[j + step] = temp;
            }
            step /= 2;
        }
        return array;
    }
}
