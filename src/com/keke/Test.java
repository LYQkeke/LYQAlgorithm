package com.keke;

import com.keke.dp.Fibonacci;

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
    }

    public static void main(String[] args){

        runFibnacci();

    }
}
