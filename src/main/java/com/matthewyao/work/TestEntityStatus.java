package com.matthewyao.work;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yaokuan on 2017/6/2.
 */
public class TestEntityStatus {
    public static void main(String[] args) {
        List<Integer> newList = Arrays.asList(20239136, 20499074, 20563700, 20610526, 22001282, 22023653, 22034826, 22059092, 22143808, 22222260, 22226198, 22232555, 22233529, 22234286, 22250522, 22254077, 22252690, 22252731);
        List<Integer> oldList = Arrays.asList(20440017, 20497666, 20530095, 20562131, 22033932, 22034826, 22041220, 22041331, 22056615, 22059092, 22076219, 22142432, 22142475, 22149648, 22151438, 22186080, 22202819, 22202568, 22205666, 22215673, 22222260, 22231315, 22242016, 22254164);
        List<Integer> nullList = Arrays.asList(
                152707867, 76666259, 56567637, 67994649, 81168845, 22723143, 13791436, 67651095, 5880952, 27336579, 24063563, 13423339, 24502082, 69939996, 69798675, 24670275, 19142680, 56930138, 45306252, 32300975, 32600503, 21582594, 99580580, 23956513, 69939558, 22297627, 6179855, 5384242, 59291372, 73501445, 38068258, 91896092, 90027828, 67068810, 68069237, 3134893, 113411142, 58463738, 2334379, 18205340, 69215408, 23988735, 27139340, 65282419, 69189255, 6606332, 21641425, 57470193, 58613475, 32344399, 69809037, 57193166, 77353267, 21066993, 76949028, 21988091, 90394071, 44354335, 18294700, 67432377, 12758652, 48540192, 58658490, 63049988, 38068109, 5470104, 66331711, 16722482, 43623241, 6229642, 67791825, 27004482, 6121346, 45323351, 78017346, 50722029, 24512412, 67676387, 45343327, 27375439, 18078972, 23893916, 32773381, 65873951, 69282260, 5386410, 58214273, 59052923, 79602497);

        System.out.println("intersect:" + newList.retainAll(oldList));
        System.out.println("inter is null:" + newList.retainAll(oldList));
    }
}