package com.keke.sort;

/**
 * Created by KEKE on 2019/3/6
 *
 * 归并排序
 * 归并排序利用递归和分支的思想将待排序的数组划分为半子表
 * 然后将两个有序的半子表进行合并
 * 在最坏、最好和平均的情况下 算法的时间复杂度都是O(nlogn)
 * 额外空间复杂度为O(n)
 * 是一种稳定的排序算法
 */
public class MergeSort {

    public static void merge(int[] arr, int lhead, int rhead, int ed ){
        int[] arrl = new int[rhead-lhead];
        int[] arrr = new int[ed-rhead+1];
        int i,j;
        for (i = 0;i<arrl.length;i++)
            arrl[i] = arr[lhead+i];
        for (i=0;i<arrr.length;i++)
            arrr[i] = arr[rhead+i];
        i = 0;
        j = 0;
        int temp = lhead;
        while (i<arrl.length||j<arrr.length){
            if (i==arrl.length)
                arr[temp++] = arrr[j++];
            else if (j==arrr.length)
                arr[temp++] = arrl[i++];
            else {
                if (arrr[j]<arrl[i])
                    arr[temp++] = arrr[j++];
                else
                    arr[temp++] = arrl[i++];
            }
        }


    }

    public static void sort(int[] arr, int from, int to){
        if (from==to)
            return;
        int mid = (from+to)/2;
        sort(arr, from, mid);
        sort(arr, mid+1, to);
        merge(arr, from, mid+1, to);
    }
}
