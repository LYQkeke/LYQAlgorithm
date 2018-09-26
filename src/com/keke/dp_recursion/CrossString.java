package com.keke.dp_recursion;

import java.util.Arrays;

/**
 * Created by KEKE on 2018/9/25
 *
 * CrossString
 *
 * 给定三个字符产str1、str2和aim，如果aim包含且仅包含来自str1和str2的所有字符，而且
 * 在aim中属于str1的字符之间保持原来在str1中的顺序，属于str2中的字符保持原来在str2中的
 * 顺序，那么称aim是str1和str2的交错组成。实现一个函数，判断aim是否是str1和str2的交错
 * 组成。
 */
public class CrossString {

    public static void main(String[] args){
        String str1 = "AB";
        String str2 = "12";
        String str3 = "abcdefghjk";
        System.out.println(isCross1(str1, str2, "AB12"));
        System.out.println(isCross2(str1, str2, "AB12"));
        System.out.println(isCross3(str1, str2, "AB12"));
        System.out.println(isCross1("AAA", "AB", "AABAA"));
        System.out.println(isCross2("AAA", "AB", "AABAA"));
        System.out.println(isCross3("AAA", "AB", "AABAA"));
//        System.out.println(isCross1(str2, str3, "abcdef1ghjk2"));
    }

    /**
     * 非动态规划方法
     * 这种方法好像也很简单
     * 不对，好像有问题，哈哈哈，很是尴尬
     * 对不起，打扰了
     * 对于一些简单的排列，这种方法是适用的，但是对于一些可能
     * 存在的复杂情况就不行了
     * @param str1
     * @param str2
     * @param aim
     * @return
     */
    public static boolean isCross1(String str1, String str2, String aim){

        if (str1==null||str2==null||aim==null)
            return false;
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        char[] chs3 = aim.toCharArray();
        int len1 = chs1.length;
        int len2 = chs2.length;
        int len3 = chs3.length;
        if (len3!=len2+len1)
            return false;
        int idx1 = 0;
        int idx2 = 0;
        for (int i=0;i<chs3.length;i++){

            if (idx1<chs1.length&&chs3[i]==chs1[idx1]){
                len1--;
                len3--;
                idx1++;
            }else if (idx2<chs2.length&&chs3[i]==chs2[idx2]){
                len2--;
                len3--;
                idx2++;
            }else {
                return false;
            }
            if (len1<0||len2<0)
                return false;
        }
        if (len1==0&&len2==0&&len3==0)
            return true;
        else
            return false;
    }

    /**
     * 没有进行矩阵压缩，空间复杂度是O(m*n)
     * @param str1
     * @param str2
     * @param aim
     * @return
     */
    public static boolean isCross2(String str1, String str2, String aim){
        if (str1==null||str2==null||aim==null)
            return false;
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        char[] chsaim = aim.toCharArray();
        if (chs1.length+chs2.length!=chsaim.length)
            return false;
        boolean[][] dp = new boolean[chs1.length+1][chs2.length+1];
        dp[0][0] = true;
        for (int i=1;i<=chs1.length;i++)
            if (dp[i-1][0]&&chsaim[i-1]==chs1[i-1])
                dp[i][0] = true;
        for (int i=1;i<=chs2.length;i++)
            if (dp[0][i-1]&&chsaim[i-1]==chs2[i-1])
                dp[0][i] = true;
        for (int i=1;i<=chs1.length;i++){
            for (int j=1;j<=chs2.length;j++){
                if ((dp[i-1][j]&&chs1[i-1]==chsaim[i+j-1])||(dp[i][j-1]&&chs2[j-1]==chsaim[i+j-1]))
                    dp[i][j] = true;
            }
        }
        return dp[chs1.length][chs2.length];
    }

    /**
     * 对dp矩阵进行了压缩，空间复杂度可以达到O(min(m,n))
     * @param str1
     * @param str2
     * @param aim
     * @return
     */
    public static boolean isCross3(String str1, String str2, String aim){
        if (str1==null||str2==null||aim==null)
            return false;
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        char[] chsaim = aim.toCharArray();
        if (chsaim.length!=chs1.length+chs2.length)
            return false;
        char[] longs = chs1.length>=chs2.length?chs1:chs2;
        char[] shorts = chs1.length<chs2.length?chs1:chs2;
        boolean[] dp = new boolean[shorts.length+1];
        dp[0] = true;
        for (int i=1;i<=shorts.length;i++){
            if (shorts[i-1]!=chsaim[i-1])
                break;
            dp[i] = true;
        }
        for (int i=1;i<=longs.length;i++){
            if (dp[0]&&longs[i-1]==chsaim[i-1])
                dp[0] = true;
            for (int j=1;j<=shorts.length;j++){
                if((dp[j-1]&&shorts[j-1]==chsaim[i+j-1])||(dp[j]&&longs[i-1]==chsaim[i+j-1]))
                    dp[j] = true;
            }
        }
        return dp[shorts.length];
    }
}
