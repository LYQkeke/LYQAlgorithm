package com.keke.queue_stack;

import java.util.LinkedList;

/**
 * Created by KEKE on 2018/10/16
 *
 * 最大值减去最小值小于或等于 num 的子数组数量
 *
 * 给定数组arr和整数num，共返回有多少个子数组满足如下的情况：
 * max(arr[i...j]) - min(arr[i...j]) <= num
 * max(arr[i...j])表示子数组arr[i...j]中的最大值
 * min(arr[i...j])表示子数组arr[i...j]中的最小值
 *
 * 如果数组长度为n，请写出时间复杂度为O(n)的算法
 */
public class P031 {

    public static void main(String[] args){

        int[] arr = {3,3,5,5,6};
        System.out.println(getNum1(arr,0));// 7
        System.out.println(getNum1(arr,1));// 9
    }

    public static int getNum1(int[] arr, int num){

        if (arr==null||arr.length==0||num<0)
            return 0;
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int res = 0;
        int i = 0;
        int j = 0;
        int c = 0;
        while (i<arr.length){
            while (j<arr.length){
                // 将j所指向的位置加入队列中 min max 队列之中
                while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);// 实际上并不是只入队一次
                c++;
                while (!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                if ((arr[qmax.peekFirst()]-arr[qmin.peekFirst()])>num){
                    break;
                }
                j++;
            }
            res += j - i;
            if (qmin.peekFirst()==i)
                qmin.pollFirst();
            if (qmax.peekFirst()==i)
                qmax.pollFirst();
            i++;
        }
        System.out.println("count:"+c);
        return res;
    }
}
