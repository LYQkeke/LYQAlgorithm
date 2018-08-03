package com.keke;

import com.keke.dp_recursion.Fibonacci;
import com.keke.dp_recursion.MinCoins;
import com.keke.dp_recursion.MinPath;

/**
 * Created by KEKE on 2018/8/2
 */
public class Test {

    /**
     * Fibonacci 测试 n^2 n logn
     * 矩阵乘法加速
     */
    private static void runFibnacci(){
        System.out.println("f1 "+Fibonacci.fib1(20));
        System.out.println("f2 "+Fibonacci.fib2(20));
        System.out.println("f3 "+Fibonacci.fib3(20));
        System.out.println(Fibonacci.farmNainiu(6));
    }

    /**
     * 矩阵的最小路径和，压缩空间，降低空间复杂度
     */
    private static void runMinPath(){
        int[][] path = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        System.out.println(MinPath.minPathSum1(path));
        System.out.println(MinPath.minPathSum2(path));
    }

    private static void runMinCoins(){
        int[] arr = {2,3,5};
        System.out.println(MinCoins.minCoins1(arr,18));
        System.out.println(MinCoins.minCoins1(arr,27));
        System.out.println(MinCoins.minCoins2(arr,18));
        System.out.println(MinCoins.minCoins2(arr,27));
        System.out.println("===========================");
        System.out.println(MinCoins.minCoins3(arr,10));
        System.out.println(MinCoins.minCoins4(arr,10));
    }

    public static void main(String[] args){

//        runFibnacci();
//        runMinPath();
        runMinCoins();
    }
}
