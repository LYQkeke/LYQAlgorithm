package com.keke.sort;

/**
 * Created by KEKE on 2019/3/6
 *
 * 冒泡排序
 * 冒泡排序顾名思义，利用类似冒泡的过程在每一趟排序的过程中，将最大或者最小的元素放到最后
 * 最好的情况下时间复杂度为O(n)，最坏和平均的情况下平均时间复杂度为O(n^2)、
 * 额外空间复杂度为O(1)
 * 是一种稳定的排序算法
 */
public class BubbleSort {

    public static void sort(int[] arr){

        int temp;
        boolean flag = false;
        for (int i = arr.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                return;
            else
                flag = false;
        }
    }
}
