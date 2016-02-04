package com.matthewyao.sort;

/**
 * Created by mosmovon on 16/2/4.
 */
public class HeapSorting {

    /**
     * 本质就是先构造一个大顶堆,parent比children大,root节点就是最大的节点 把最大的节点(root)与尾节点(最后一个节点,比较小)位置互换，
     * 剩下最后的尾节点,现在最大,其余的,从第一个元素开始到尾节点前一位,构造大顶堆递归。
     * 111111111111111111
     * */

    /**
     * @param int 未排序数组
     * @return int 排完序数组
     */
    public static int[] sort(int[] array) {
        buildHeap(array);// 构建堆s
        int n = array.length;
        int i = 0;
        for (i = n - 1; i >= 1; i--) {
            swap(array, 0, i);
            heapify(array, 0, i);
        }

        return array;
    }
    private static void buildHeap(int[] array) {
        int n = array.length;// 数组中元素的个数
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, i, n);
    }

    private static void heapify(int[] A, int idx, int max) {
        int left = 2 * idx + 1;// 左孩子的下标（如果存在的话）
        int right = 2 * idx + 2;// 左孩子的下标（如果存在的话）
        int largest = 0;// 寻找3个节点中最大值节点的下标
        if (left < max && A[left] > A[idx])
            largest = left;
        else
            largest = idx;
        if (right < max && A[right] > A[largest])
            largest = right;
        if (largest != idx) {
            swap(A, largest, idx);
            heapify(A, largest, max);
        }
    }

    // 建堆函数，认为【s，m】中只有 s
// 对应的关键字未满足大顶堆定义，通过调整使【s，m】成为大顶堆=====================================================
    public static void swap(int[] array, int s, int m) {
// 用0下标元素作为暂存单元
        array[0] = array[s];
        // 沿孩子较大的结点向下筛选
        for (int j = 2 * s; j <= m; j *= 2) {
// 保证j为较大孩子结点的下标，j < m 保证 j+1 <= m ，不越界
            if (j < m && array[j] < array[j + 1]) {
                j++;
            }
            if (!(array[0] < array[j])) {
                break;
            }
// 若S位较小，应将较大孩子上移
            array[s] = array[j];
// 较大孩子的值变成S位的较小值，可能引起顶堆的不平衡，故对其所在的堆进行筛选
            s = j;
        }
// 若S位较大，则值不变；否则，S位向下移动至2*s、4*s、。。。
        array[s] = array[0];
    }
}
