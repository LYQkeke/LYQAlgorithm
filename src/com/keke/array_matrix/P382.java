package com.keke.array_matrix;

import java.util.Arrays;

/**
 * Created by KEKE on 2019/2/23
 *
 * 数组的partition调整
 *
 * 给定一个有序数组arr，调整arr使得这个数组的左半部没有重复的元素且升序，而不用保证右边的部分是否有序。
 * 例如：arr=[1,2,2,2,3,3,4,5,6,6,7,7,8,8,8,9]，调整之后arr=[1,2,3,4,5,6,7,8,9.....]
 *
 * 补充：
 * 给定一个数组arr，其中只能含有0,1,2 个值，请实现arr的排序。
 * 有一个数组，其中只有红球、黄球和篮球，请实现所有红球放在数组的左边，黄球放中间，蓝球放在最右边。
 * 有一个数组，在给定一个k值，请事先所有比k小的数都放在数组的左边，等于k的值放在中间，大于k的数放在右边。
 *
 * 要求： 时间复杂度O(n) 空间复杂度O(1)
 */
public class P382 {

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void leftUnique(int[] arr){

        if (arr==null||arr.length<2)
            return;
        int a = 0;
        int b = 1;
        while (b!=arr.length){
            if (arr[b++]!=arr[a]){
                swap(arr, ++a, b-1);
            }
        }
    }

    private static void sort(int[] arr){
        if (arr==null||arr.length<2)
            return;
        int left = -1;
        int right = arr.length;
        int index = 0;
        // 如果index==right说明左右两个分区成功连接
        while (index<right){
            if (arr[index]==1){
                swap(arr, ++left, index++);
            }else if (arr[index]==3){
                swap(arr, index, --right);
            }else {
                index++;
            }
        }
    }

    public static void main(String[] args){

        int[] arr = {1,2,2,2,3,3,4,5,6,6,7,7,8,8,8,9};
        leftUnique(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {1,2,3,1,2,3,1,2,2,2,1};
        sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
