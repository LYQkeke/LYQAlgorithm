package com.keke.dp_recursion;

/**
 * Created by KEKE on 2018/9/20
 *
 * MinEditCost
 *
 * 给定两个字符串str1和str2，再给定三个整数ic、dc、rc，分别代表插入代价，
 * 删除代价和替换一个字符的代价，返回将str1编辑成str2的最小代价。
 */
public class MinEditCost {

    public static void main(String[] args){

        String str1 = "abc";
        String str2 = "adc";
        System.out.println(mec1(str1, str2, 5, 3, 2));
        System.out.println(mec1(str1, str2, 5, 3, 100));
    }

    public static int mec1(String str1, String str2, int ic, int dc, int rc){

        // 没有经过压缩的算法，空间复杂度为 O(m*n)
        if (str1==null||str2==null||str1.length()==0||str2.length()==0)
            return 0;
        char[] cha1 = str1.toCharArray();
        char[] cha2 = str2.toCharArray();
        int row = cha1.length+1;
        int col = cha2.length+1;
        int[][] dp = new int[row][col];
        for (int i=1;i<row;i++)
            dp[i][0] = dc*i;
        for (int i=1;i<col;i++)
            dp[0][i] = ic*i;
        for (int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                if (cha1[i-1]==cha2[j-1])//因为在dp数组中加入了表示字符长度为0的表示，所以需要 -1 啊
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j-1] + rc;
                dp[i][j] = Math.min(dp[i][j-1]+ic, dp[i][j]);
                dp[i][j] = Math.min(dp[i-1][j]+dc, dp[i][j]);
            }
        }
        return dp[row-1][col-1];
    }
}
