package com.keke.dp_recursion;

/**
 * Created by KEKE on 2018/9/8
 */
public class HanoiTrack {

    /**
     * 汉诺塔问题
     *
     * 进阶要求，根据数组状态给出，状态序号
     * @param args
     */
    public static void main(String[] args){
        hanoi(2);
        int[] arr = {3,3,2,1};
        System.out.println(step1(arr));
        System.out.println(step2(arr));
    }

    public static void hanoi(int n){
        if (n>0)
            func(n,"left", "mid", "right");
    }

    private static void func(int n, String l, String m, String r){
        if (n==1)
            System.out.println("move from " + l + " to " + r);
        else {
            func(n-1,l,r,m);
            func(1,l,m,r);
            func(n-1,m,l,r);
        }
    }

    public static int step1(int[] arr){

        if (arr==null||arr.length==0)
            return -1;
        else
            return process(arr, arr.length-1, 1, 2, 3);
    }

    private static int process(int[] arr, int i, int from, int mid, int to){

        /**
         * 因为使用了递归，需要使用额外的函数栈，所以额外的空间复杂度为O(N)
         */
        if (i==-1)
            return 0;
        if (arr[i] != from && arr[i] != to)
            return -1;
        if (arr[i] == from)
            return process(arr, i-1, from, to, mid);
        else {
            int res = process(arr, i - 1, mid, from, to);
            if (res == -1)
                return -1;
            return (1 << i) + res;
        }
    }

    private static int step2(int[] arr){

        if (arr==null||arr.length==0)
            return -1;
        int from = 1;
        int mid = 2;
        int to = 3;
        int temp = 0;
        int res = 0;
        for (int i= arr.length-1;i>=0;i--){
            if (arr[i]!=from&&arr[i]!=to)
                return -1;
            if (arr[i]==from){
                temp = to;
                to = mid;
            }else {
                res += 1 << i;
                temp = from;
                from = mid;
            }
            mid = temp;
        }
        return res;
    }
}
