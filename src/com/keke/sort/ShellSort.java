package com.keke.sort;

/**
 * Created by KEKE on 2019/3/6
 *
 * 希尔排序（缩小增量排序）
 * 使用希尔排序进行排序，需要选择一个步长序列
 * 平均时间复杂度为O(nlogn)
 */
public class ShellSort {

    public static void sort(int[] arr){

        int i,j;
        // 增量 h
        for (int h = arr.length/2; h>0; h /= 2){
            for (i = h; i<arr.length;i++){
                int temp = arr[i];
                for (j=i-h;j>=0;j-=h){
                    if (arr[j]>=temp)
                        arr[j+h] = arr[j];
                    else
                        break;
                }
                arr[j+h] = temp;
            }
        }
    }
}
