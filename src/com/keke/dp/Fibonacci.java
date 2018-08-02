package com.keke.dp;

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

    public static int fib3(int n){
        if (n<1)
            return 0;
        if (n==1||n==2)
            return 1;
        int[][] base = {{1,1},{1,0}};
        int[][] res = Util.matPow(base,n-2);
        return res[0][0]+res[1][0];
    }
}
