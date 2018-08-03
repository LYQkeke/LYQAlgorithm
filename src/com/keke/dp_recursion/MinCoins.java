package com.keke.dp_recursion;

/**
 * Created by KEKE on 2018/8/3
 */
public class MinCoins {

    /**
     * 给定数组arr，arr中的值都为正数且不重复。每个值代表一个面值的货币，
     * 每种货币可以使用任意张，再给定一个整数aim代表想要找的钱数，求组成
     * aim的最小货币数。
     */

    /**
     * 经典方法，构建一个n*aim+1的辅助数组
     * @param arr
     * @param aim
     * @return
     */
    public static int minCoins1(int[] arr, int aim){
        if (arr==null || arr.length==0 || aim<0)
            return -1;
        int max = Integer.MAX_VALUE;
        int n = arr.length;
        int[][] dp = new int[n][aim+1];
        for (int i=1;i<=aim;i++) {
            dp[0][i] = max;
            if (i - arr[0] >= 0 && dp[0][i-arr[0]]!=max)
                dp[0][i] = dp[0][i-arr[0]]+1;
        }
        for (int i=1;i<n;i++){
            for (int j=1;j<=aim;j++){
                int currentMax = max;
                if (j-arr[i]>=0&&dp[i][j-arr[i]]!=max)
                    currentMax = dp[i][j-arr[i]] + 1;
                dp[i][j] = Math.min(currentMax,dp[i-1][j]);
            }
        }
        return dp[n-1][aim]==max?-1:dp[n-1][aim];
    }

    /**
     * 对空间进行了压缩，只使用一个aim大小的一维数组
     * @param arr
     * @param aim
     * @return
     */
    public static int minCoins2(int[] arr,int aim){
        if (arr==null || arr.length==0 || aim<0)
            return -1;
        int max = Integer.MAX_VALUE;
        int n = arr.length;
        int[] dp = new int[aim+1];
        for (int i=1;i<=aim;i++){
            dp[i] = max;
            if (i-arr[0]>=0&&dp[i-arr[0]]!=max)
                dp[i] = dp[i-arr[0]]+1;
        }
        for (int i=1;i<n;i++){
            for (int j=1;j<=aim;j++){
                int currentMax = max;
                if (j-arr[i]>=0&&dp[j-arr[i]]!=max)
                    currentMax = dp[j-arr[i]]+1;
                dp[j] = Math.min(currentMax,dp[j]);
            }
        }
        return dp[aim]==max?-1:dp[aim];
    }

    /**
     * 给定数组arr，arr中所有的值都为正数。每个值仅代表一张钱的面值，
     * 再给定一个整数aim代表所要找的钱数，求组成aim的最小货币数。
     */
    public static int minCoins3(int[] arr, int aim){
        if (arr==null||arr.length==0||aim<0)
            return -1;
        int max = Integer.MAX_VALUE;
        int n = arr.length;
        int[][] dp = new int[n][aim+1];
        for (int i=1;i<=aim;i++)
            dp[0][i] = max;
        if (arr[0]<=aim)
            dp[0][arr[0]]=1;
        for (int i=1;i<n;i++){
            for (int j=1;j<=aim;j++){
                int currentMax = max;
                if (j-arr[i]>=0&&dp[i-1][j-arr[i]]!=max)
                    currentMax = dp[i-1][j-arr[i]]+1;
                dp[i][j] = Math.min(currentMax,dp[i-1][j]);
            }
        }
        return dp[n-1][aim]==max?-1:dp[n-1][aim];
    }

    /**
     * 空间压缩
     * @param arr
     * @param aim
     * @return
     */
    public static int minCoins4(int[] arr, int aim){

        if (arr==null||arr.length==0||aim<0)
            return -1;
        int max = Integer.MAX_VALUE;
        int n = arr.length;
        int[] dp = new int[aim+1];
        for (int i=1;i<=aim;i++)
            dp[i] = max;
        if (arr[0]<=aim)
            dp[arr[0]] = 1;
        for (int i=1;i<n;i++){
            for (int j=aim;j>0;j--){//注意这里啊，为了避免从前向后扫描可能会改变dp数组，这里从后向前扫描
                int currentMax = max;
                if (j-arr[i]>=0&&dp[j-arr[i]]!=max)
                    currentMax = dp[j-arr[i]]+1;
                dp[j] = Math.min(currentMax,dp[j]);
            }
        }
        return dp[aim]==max?-1:dp[aim];
    }
}
