package com.keke.dp_recursion;

/**
 * Longest Common String
 * 最长公共子串
 *
 * 给定两个字符串str1和str2，返回两个字符串的最长公共子串
 *
 * 举例：
 * str1 = 1AB2345CD str2 = 12345EF 返回2345
 * 额外要求： 实现时间复杂度O(M*N)，额外空间复杂度为O(1)的方法
 *
 * Created by KEKE on 2018/9/12
 */
public class LCSt {

    public static void main(String[] args){

        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        System.out.println(lcst1(str1, str2));
        System.out.println(lcst2(str1, str2));
    }

    /**
     * 这一部分使用了一个 m*n 的dp数组， 所以额外的空间复杂度为 O(m*n)
     * @param str1
     * @param str2
     * @return
     */
    public static String lcst1(String str1, String str2){

        if (str1==null||str2==null||str1.length()==0||str2.length()==0)
            return "";
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int m = chs1.length;
        int n = chs2.length;
        int[][] dp = getdp(chs1, chs2);
        int end = 0;
        int max = 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (dp[i][j]>max){
                    max = dp[i][j];
                    end = i;
                }
            }
        }
        return str1.substring(end-max+1, end+1);
    }

    private static int[][] getdp(char[] chs1, char[] chs2){

        int m = chs1.length;
        int n = chs2.length;
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++)
            dp[i][0] = chs1[i]==chs2[0]?1:0;
        for (int i=0;i<n;i++)
            dp[0][i] = chs2[i]==chs1[0]?1:0;
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (chs1[i]!=chs2[j])
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j-1] + 1;
            }
        }
        return dp;
    }

    /**
     * 在动态规划中每次只记录左上角的dp值 不需要再使用dp数组
     * 所以额外空间复杂度为O(1)
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String lcst2(String str1, String str2){

        if (str1==null||str2==null||str1.length()==0|| str2.length()==0)
            return "";
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int max = 0;
        int end = 0;
        int row = 0;
        int col = chs2.length-1;
        while (row<chs1.length){
            int len = 0;
            int i = row;
            int j = col;
            while (i<chs1.length&&j<chs2.length){
                len = chs1[i]==chs2[j]?len+1:0;
                if (len>max){
                    max = len;
                    end = i;
                }
                i++;
                j++;
            }
            if (col>0)
                col--;
            else
                row++;
        }

        return str1.substring(end-max+1,end+1);
    }
}
