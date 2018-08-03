package com.keke.dp_recursion;

/**
 * Created by KEKE on 2018/8/3
 */
public class MinPath {

    /**
     * 给定一个矩阵m,从左上角开始每次只能向右或者向下走，最后达到右下角的位置，
     * 路径上的所有的数字累加起来就是路径和，返回所有路径中最小的路径和。
     */

    /**
     * 这是一个时间复杂度为O（mn）空间复杂度也为O(mn)的动态规划算法
     * @param m
     * @return
     */
    public static int minPathSum1(int[][] m){
        if (m==null || m.length==0 || m[0]==null || m[0].length==0)
            return 0;
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i=1;i<row;i++)
            dp[0][i] = dp[0][i-1] + m[0][i];
        for (int i=1;i<col;i++)
            dp[i][0] = dp[i-1][0] + m[i][0];
        for (int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + m[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    /**
     * 可以对算法的空间进行压缩，从而使空间复杂度变为O（MIN（m,n））
     * @param m
     * @return
     */
    public static int minPathSum2(int[][] m){
        if (m==null || m.length==0 || m[0]==null || m[0].length==0)
            return 0;
        int more = Math.max(m.length,m[0].length);
        int less = Math.min(m.length,m[0].length);
        boolean rowmore = more==m.length;
        int[] dp = new int[less];
        dp[0] = m[0][0];
        for (int i=1;i<less;i++)
            dp[i] = dp[i-1] + (rowmore?m[0][i]:m[i][0]);
        for (int i=1;i<more;i++){
            dp[0] += rowmore?m[i][0]:m[0][i];
            for (int j=1;j<less;j++){
                dp[j] = Math.min(dp[j],dp[j-1]) + (rowmore?m[i][j]:m[j][i]);
            }
        }
        return dp[less-1];
    }
}
