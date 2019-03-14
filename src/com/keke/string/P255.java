package com.keke.string;

/**
 * Created by KEKE on 2019/3/5
 *
 * 判断字符数组中是否所有的字符都只出现过一次
 *
 * 要求：
 *  1.实现时间复杂度O(n)的算法
 *  2.实现额外空间复杂度O(1)的算法，同时要求时间复杂度尽量小
 */
public class P255 {

    /**
     * 时间复杂度O(n)
     * @param chs
     * @return
     */
    public static boolean isUnique1(char[] chs){

        boolean[] map = new boolean[256];
        for (int i=0;i<chs.length;i++){
            if (map[chs[i]])
                return false;
            else
                map[chs[i]] = true;
        }
        return true;
    }

    /**
     * 额外空间复杂度为O(1)
     * 时间复杂度O(nlogn)
     * @param chs
     * @return
     */
    public static boolean isUnique2(char[] chs){

        maxHeapSort(chs);
        for (int i=1;i<chs.length;i++)
            if (chs[i]==chs[i-1])
                return false;
        return true;
    }

    public static void maxHeapSort(char[] arr){
        int len = arr.length;
        for (int i=len/2-1;i>=0;i--)
            adjustMaxHeap(arr, i, len-1);
        for (int i=len-1;i>0;i--){
            char temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustMaxHeap(arr, 0, i-1);
        }
    }

    public static void adjustMaxHeap(char[] arr, int pos, int ed){

        int child = 0 ;
        for (char temp; 2*pos+1<=ed; pos = child){
            child = 2 * pos + 1;
            temp = arr[pos];
            if (child<ed&&arr[child]<arr[child+1])
                child++;
            if (arr[child]>arr[pos]){
                arr[pos] = arr[child];
                arr[child] = temp;
            }else
                break;
        }
    }

    public static void main(String[] args){
        char[] chs1 = "abc".toCharArray();
        char[] chs2 = "abcb".toCharArray();
        char[] chs3 = "abcfgebsb".toCharArray();
        char[] chs4 = "abcfges".toCharArray();
        System.out.println(isUnique1(chs1));
        System.out.println(isUnique1(chs2));
        System.out.println(isUnique2(chs3));
        System.out.println(isUnique2(chs4));
    }
}
