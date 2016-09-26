package com.matthewyao.sort;

/**
 * Created by mosmovon on 16/2/4.
 */
public class MergeSorting {

    /**
     * 归并排序采用的是递归来实现，属于“分而治之”，将目标数组从中间一分为二，之后分别对这两个数组进行排序，
     * 排序完毕之后再将排好序的两个数组“归并”到一起，归并排序最重要的也就是这个“归并”的过程，
     * 归并的过程中需要额外的跟需要归并的两个数组长度一致的空间
     * */

    /**
     * @param int 未排序数组
     * @return int 排完序数组
     */
    private static int[] sortMerge(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            sortMerge(nums, low, mid);
            // 右边
            sortMerge(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
        return nums;
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }

    public static int[] sort(int[] array) {
        return sortMerge(array, 0, array.length - 1);
    }
}
