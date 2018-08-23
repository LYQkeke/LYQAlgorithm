package com.keke.dp_recursion;

/**
 * Created by KEKE on 2018/8/4
 */
public class Coins {
    /**
     * 给定数组arr，arr中所有的值都为正数且不重复。每个值代表一种面值的货币，
     * 每种面值的货币可以使用任意张，再给定一个整数aim代表要找的钱数，求换钱的
     * 方法有多少种。
     *
     * 暴力递归 记忆搜索 动态规划
     */

    /**
     * 暴力递归
     * @param arr
     * @param aim
     * @return
     */
    public static int coins1(int[] arr, int aim){
        if (arr==null||arr.length==0||aim<0)
            return 0;
        return process1(arr, 0, aim);
    }

    private static int process1(int[] arr, int index, int aim){

        int res = 0;
        if (index==arr.length)
            return aim==0?1:0;
        else {
            for (int i=0;aim-arr[index]*i>=0;i++)
                res += process1(arr, index+1, aim-arr[index]*i);
        }
        return res;
    }

    /**
     * 记忆搜索
     * @param arr
     * @param aim
     * @return
     */
    public static int coins2(int[] arr, int aim){
        if (arr==null || arr.length==0 || aim<0)
            return 0;
        int[][] map = new int[arr.length+1][aim+1];
        return process2(arr, 0, aim, map);
    }

    private static int process2(int[] arr, int index, int aim, int[][] map){

        int res = 0;
        if (index==arr.length)
            res =  aim==0?1:0;
        else {
            int mapValue = 0;
            for (int i=0;aim - arr[index]*i >=0;i++){
                mapValue = map[index+1][aim-arr[index]*i];
                if (mapValue!=0){
                    res += mapValue==-1?0:mapValue;
                }else
                    res += process2(arr, index+1, aim-arr[index]*i, map);
            }
        }
        map[index][aim] = res==0?-1:res;
        return res;
    }

    /**
     * 动态规划 O(N*aim^2)
     * @param arr
     * @param aim
     * @return
     */
    public static int coins3(int[] arr, int aim){

        if (arr==null || arr.length==0 || aim<0)
            return 0;
        int[][] dp = new int[arr.length][aim+1];
        for (int i=0;i<arr.length;i++)
            dp[i][0] = 1;
        for (int i=1;arr[0]*i<=aim;i++)
            dp[0][arr[0]*i] = 1;
        for (int i=1;i<arr.length;i++){
            for (int j=1;j<=aim;j++){
                for (int k=0;arr[i]*k<=j;k++)
                    dp[i][j] += dp[i-1][j-arr[i]*k];
            }
        }
        return dp[arr.length-1][aim];
    }

    /**
     * O(n*aim) 同时对dp矩阵进行了压缩
     * @param arr
     * @param aim
     * @return
     */
    public static int coins4(int[] arr, int aim){

        if (arr==null || arr.length==0 || aim<0)
            return 0;
        int[] dp = new int[aim+1];
        for (int i=0;arr[0]*i<=aim;i++)
            dp[arr[0]*i] = 1;
        for (int i=1;i<arr.length;i++){
            for (int j=1;j<=aim;j++){
                dp[j] += j-arr[i]>=0?dp[j-arr[i]]:0;
            }
        }
        return dp[aim];
    }
}
