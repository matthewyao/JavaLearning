package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2017/1/23.
 */
public class L492_ConstructTheRectangle {

    public static void main(String[] args) {
        int[] ints = constructRectangle(1);
        for (int anInt : ints) {
            System.out.println(anInt + " ");
        }
    }

    public static int[] constructRectangle(int area) {
        int minDiff = area,minW = 0,minH = 0;
        for (int w = 1; w <= area; w++){
            if (area % w == 0){
                int h = area / w;
                if (w > h){
                    break;
                }else {
                    if(h - w < minDiff){
                        minDiff = h - w;
                        minW = w;
                        minH = h;
                    }
                }
            }
        }
        return new int[]{minH,minW};
    }
}
