package com.keke;

import com.keke.dp_recursion.*;

import java.util.Arrays;

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

    private static void runCoins(){
        int[] arr = {5,10,25,1};
        System.out.println(Coins.coins1(arr,15));
        System.out.println(Coins.coins2(arr,15));
        System.out.println(Coins.coins3(arr,15));
        System.out.println(Coins.coins4(arr,15));
    }

    private static void runLIS(){

        int[] arr = {2,1,5,3,6,4,8,9,7};
        System.out.println(Arrays.toString(LIS.lis1(arr)));
        System.out.println(Arrays.toString(LIS.lis2(arr)));
    }

    public static void main(String[] args){

//        runFibnacci();
//        runMinPath();
//        runMinCoins();
//        runCoins();
        runLIS();
        Integer i;

    }
}
