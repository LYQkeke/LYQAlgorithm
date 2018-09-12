package com.keke.dp_recursion;

/**
 * Longest Common Sequence
 * 最长公共子序列
 *
 * 给定两个字符串str1和str2，返回两个字符串的最长公共子序列。
 *
 * 举例：
 * str1 = 1A2C3D4B56  str2 = B1D23CA45B6A
 *  123456 或者 12C4B6 都是最长公共子序列，返回哪一个都行。
 *
 * Created by KEKE on 2018/9/10
 */
public class LCSe {

    public static void main(String[] args){

        String str1 = "1A2C3D4B56";
        String str2 = "B1D23CA45B6A";
        System.out.println(lcse(str1, str2));
    }

    public static String lcse(String str1, String str2){

        if (str1==null||str2==null||str1.length()==0||str2.length()==0)
            return "";
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1, chs2);
        int m = str1.length()-1;
        int n = str2.length()-1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index>=0){
            if (m>0 && dp[m][n]==dp[m-1][n]){
                m--;
            }else if (n>0 && dp[m][n]==dp[m][n-1]){
                n--;
            }else {
                res[index--] = chs1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }

    private static int[][] getdp(char[] str1, char[] str2){

        int[][] dp = new int[str1.length][str2.length];
        if (str1[0]==str2[0])
            dp[0][0] = 1;
        for (int i=1;i<str2.length;i++){
            dp[0][i] = str1[0]==str2[i]?1:dp[0][i-1];
        }
        for (int i=1;i<str1.length;i++){
            dp[i][0] = str1[i]==str2[0]?1:dp[i-1][0];
        }
        for (int i=1;i<str1.length;i++){
            for (int j=1;j<str2.length;j++){
                int temp = Math.max(dp[i-1][j],dp[i][j-1]);
                if (str1[i]==str2[j])
                    temp = Math.max(dp[i-1][j-1]+1,temp);
                dp[i][j] = temp;
            }
        }
        return dp;
    }
}
