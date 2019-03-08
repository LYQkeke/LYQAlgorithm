package com.keke.sort;

/**
 * Created by KEKE on 2019/3/6
 *
 * 插入排序
 * 在每一躺排序开始之前都保证开始位置之前保持有序
 * 然后将该元素插入到它应该处于的位置
 * 在最好的情况下，该方法的时间复杂度为O(n)
 * 最坏和平均情况下，该方法的时间复杂度为O(n^2)
 * 额外空间复杂度为O(1)
 * 是一种稳定的排序算法
 * 在待排序元素相对有序的情况下比较好
 */
public class InsertSort {

    public static void sort(int[] arr){

        if (arr!=null){
            for (int i=1;i<arr.length;i++){
                int temp = arr[i];
                int j = i;
                while (j>=1&&arr[j-1]>temp){
                    arr[j] = arr[j-1];
                    j--;
                }
                arr[j] = temp;
            }
        }
    }
}
