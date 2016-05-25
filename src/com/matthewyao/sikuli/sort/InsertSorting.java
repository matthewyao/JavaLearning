package com.matthewyao.sikuli.sort;

/**
 * Created by mosmovon on 16/2/4.
 */
public class InsertSorting {
    /**
     * 插入排序的基本思想是在遍历数组的过程中，假设在序号 i 之前的元素即 [0..i-1] 都已经排好序，
     * 本趟需要找到 i 对应的元素 x 的正确位置 k ， 并且在寻找这个位置 k 的过程中逐个将比较过的元素往后移一位，
     * 为元素 x “腾位置”，最后将 k 对应的元素值赋为 x ， 一般情况下，插入排序的时间复杂度和空间复杂度分别为 O(n2 ) 和 O(1)。
     * */
    public static int[] sort(int[] array){
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
