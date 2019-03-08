package com.keke.sort;

/**
 * Created by KEKE on 2019/3/6
 *
 * 选择排序在最坏、最好和平均情况下的时间复杂度都是O(n^2)
 * 额外空间复杂度O(1)
 * 并不是稳定的排序算法，在前几轮的选择过程中可能会将前面的元素放到后面
 * 在n比较小的时候使用比较好
 */
public class SelectSort {

    public static void sort(int[] arr){

        int n = arr.length;
        for (int i=0;i<n;i++){
            int flag = i;
            for (int j=i+1;j<n;j++){
                if (arr[j]<arr[flag])
                    flag = j;
            }
            if (flag!=i){
                int temp = arr[i];
                arr[i] = arr[flag];
                arr[flag] = temp;
            }
        }
    }
}
