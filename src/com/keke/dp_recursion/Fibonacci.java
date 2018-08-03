package com.keke.dp_recursion;

import com.keke.toolbox.Util;

/**
 * Created by KEKE on 2018/8/2
 */
public class Fibonacci {

    /**
     * Fibonacci O(2^n)
     * @param n
     * @return
     */
    public static int fib1(int n){
        if (n<1)
            return 0;
        if (n==1 || n==2)
            return 1;
        return fib1(n-1)+fib1(n-2);
    }

    /**
     * Fibnacci O(n)
     * @param n
     * @return
     */
    public static int fib2(int n){
        if (n<1)
            return 0;
        if (n==1 || n==2)
            return 1;
        int res = 1;
        int pre = 1;
        for (int i=3;i<=n;i++){
            int temp = res;
            res += pre;
            pre = temp;
        }
        return res;
    }

    /**
     * Fibonacci O(logn)
     * @param n
     * @return
     */
    public static int fib3(int n){
        if (n<1)
            return 0;
        if (n==1||n==2)
            return 1;
        int[][] base = {{1,1},{1,0}};
        int[][] res = Util.matPow(base,n-2);
        return res[0][0]+res[1][0];
    }

    /**
     * 假设农场中的成熟的母牛每年会生一只小母牛，而且永远不会死。第一年农场有一只成熟的母牛，从第二年开始母牛开始生小母牛。
     * 每只小母牛三年之后成熟又可以生小母牛。给定整数N，求N年后牛的数量。
     * @param n
     * @return
     */
    public static int farmNainiu(int n){
        if (n<1)
            return 0;
        if (n<=3)
            return n;
        int[][] base = {{1,1,0},{0,0,1},{1,0,0}};
        int[][] res = Util.matPow(base,n-3);
        return 3*res[0][0]+2*res[1][0]+res[2][0];
    }
}
