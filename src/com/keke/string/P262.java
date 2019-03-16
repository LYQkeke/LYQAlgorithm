package com.keke.string;

/**
 * Created by KEKE on 2019/3/14
 *
 * 给定一个字符型的数组chas，请在单词间做逆序调整。只要做到单词逆序即可，对空格的位置没有特别的要求。
 *
 * “dog loves pig” --》 “pig loves dog”
 *
 * 补充：给定一个字符型的数组chas和一整整数size，请把大小为size的左半区整体移到右半区，右半区整体移到左侧。
 *
 * 如果把chas看作字符串为"ABCDE"，size=3，调整成"DEABC".
 *
 * 如果chas长度为N，两道题都要求时间复杂度为O(n)，额外空间复杂度为O(1)。
 */
public class P262 {

    public static void reverse(char[] arr, int l, int r){
        if (l>=r)
            return;
        while (l<r){
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

    public static void rotate(char[] arr){
        reverse(arr, 0, arr.length-1);
        int l = 0;
        int r = 0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]!=' ')
                r = i;
            else {
                reverse(arr, l, r);
                l = i+1;
            }
        }
        reverse(arr, l, r);
    }

    public static void rotate(char[] arr, int size){
        if (size<0)
            return;
        int len = arr.length;
        reverse(arr,0, len-1);
        reverse(arr, 0, len-size-1);
        reverse(arr, len-size, len-1);
    }

    public static void main(String[] args){
        char[] chars1 = "dog loves pig".toCharArray();
        char[] chars2 = "ABCDE".toCharArray();
        rotate(chars1);
        rotate(chars2,0);
        System.out.println(String.valueOf(chars1));
        System.out.println(String.valueOf(chars2));
    }
}
