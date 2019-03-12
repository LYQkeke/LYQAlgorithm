package com.keke.sort;

/**
 * Created by KEKE on 2019/3/6
 *
 * 堆排序
 * 堆排序在最坏、平均和最好情况下的时间复杂度都是O(nlogn)
 * 额外空间复杂度为O(1)
 */
public class HeapSort {

    public static void adjustMaxHeap(int[] arr, int pos, int ed){

        int temp, child;
        for (temp=arr[pos];2*pos+1<=ed;pos=child){
            child = 2*pos + 1;
            if (child<ed&&arr[child]<arr[child+1])
                child++;
            if (arr[child]>temp){
                arr[pos] = arr[child];
                arr[child] = temp;
            }else
                break;
        }
    }

    public static void maxHeapSort(int[] arr){

        int len = arr.length;
        // 建堆，向上调整，从第一个非叶节点开始向上调整
        for (int i = len/2-1;i>=0;i--)
            // 对于每一个节点，进行向下调整
            adjustMaxHeap(arr, i, len-1);
        // 逐一输出最大值，并调整堆
        for (int i = len-1;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustMaxHeap(arr, 0, i-1);
        }

    }
}
