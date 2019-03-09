package com.keke.sort;

/**
 * Created by KEKE on 2019/3/6
 *
 * 快速排序
 *
 * 快速排序和归并排序类似，都是采用分而治之的思想，但是划分的方法不同
 * 在最坏情况下快速排序的时间复杂度为O(n^2)
 * 在最好和平均情况的时间复杂度为O(nlogn)
 * 由于使用了递归方法，所以需要使用递归栈
 * 是一种不稳定的排序算法
 */

public class QuickSort {

    public static void partition(int[] arr, int low, int high){
        if (low>=high)
            return;
        int temp = arr[low];
        int i = low;
        int j = high;
        while (i<j){
            while (i<j&&arr[j]>=temp)
                j--;
            if (i<j)
                arr[i++] = arr[j];
            while (i<j&&arr[i]<temp)
                i++;
            if (i<j)
                arr[j--] = arr[i];
        }
        arr[i] = temp;
        partition(arr,low, i-1);
        partition(arr, i+1, high);

    }

    public static void sort(int[] arr){
        partition(arr, 0, arr.length-1);
    }
}
