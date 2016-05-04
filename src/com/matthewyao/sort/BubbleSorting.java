package com.matthewyao.sort;

/**
 * Created by mosmovon on 16/2/4.
 */
public class BubbleSorting {
    /**
     * 冒泡排序,从[i..n]选择最小的与i交换,确保每次从队列后面选择最小的数放到队列最前面,
     * 就这样像冒泡一样,从最小到次小直到最大的数逐渐冒泡到队列最前面,此为冒泡排序
     * */
    public static int[] sort(int[] arr){
//        for (int i=0;i<arr.length;i++){
//            for (int j=i+1;j<arr.length;j++){
//                if (arr[j]<arr[i]){
//                    int temp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;
//                }
//            }
//        }
//        return arr;
        /** 方式一 */
        int[] a = {7,4,6,1,3,9,3,2,6,5,0,6,7,4,5};
        for (int i=0; i<a.length; i++){
            for (int j=i; j<a.length; j++){
                if (a[j+1] < a[j]){
                    int temp = a[j];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
}
