package com.matthewyao.sort;

/**
 * Created by mosmovon on 16/2/4.
 */
public class QuickSorting {

    /**  快速排序
     * 通过一趟排序将待排记录分割成独立的两部分,其中一部分记录的关键字均比另一部分的关键字小,
     * 则可以分别对这两部分记录继续进行排序,已达到整个序列有序的目的，本质就是,找一个基位(枢轴,分水岭,作用是左边的都比它小,右边的都比它大。
     * 可随机,取名base，首先从序列最右边开始找比base小的,如果小,换位置,从而base移到刚才右边(比较时比base小)的位置(记为临时的high位),这样base右边的都比base大。
     * 然后,从序列的最左边开始找比base大的，如果大,换位置,从而base移动到刚才左边(比较时比base大)的位置(记为临时的low位),这样base左边的都比base小，
     * 循环以上两步,直到 low == heigh, 这使才真正的找到了枢轴,分水岭. 返回这个位置,分水岭左边和右边的序列,分别再来递归。
     * */

    public static int[] sort(int[] array){
        return quickSort(array, 0, array.length-1);
    }

    private static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int division = partition(arr, low, high);
            quickSort(arr, low, division - 1);
            quickSort(arr, division + 1, high);
        }
        return arr;
    }

    // 分水岭,基位,左边的都比这个位置小,右边的都大
    private static int partition(int[] arr, int low, int high) {
        int base = arr[low]; //用子表的第一个记录做枢轴(分水岭)记录
        while (low < high) { //从表的两端交替向中间扫描
            while (low < high && arr[high] >= base) {
                high--;
            }
            // base 赋值给 当前 high 位,base 挪到(互换)到了这里,heigh位右边的都比base大
            swap(arr, high, low);
            while (low < high && arr[low] <= base) {
                low++;
            }
        // 遇到左边比base值大的了,换位置
            swap(arr, high, low);
        }
        // now low = high;
        return low;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
