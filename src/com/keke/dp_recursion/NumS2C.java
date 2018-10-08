package com.keke.dp_recursion;

/**
 * Created by KEKE on 2018/10/8
 *
 * 数字字符串转换为字母组合的种数
 *
 * 给定一个字符串str，str全部由数字字符组成，如果str总的某一个或者相邻两个
 * 字符组成的字符串的值在1-26之间，则这个字符串可以转换为一个字母，规定‘1’
 * 转换为‘A’，‘2’转换为‘B’...‘26’转换为‘Z’。写一个函数，求str有多
 * 少种不同的转换结果
 */
public class NumS2C {

    public static void main(String[] strs){

        String str = "1111";
        System.out.println(num1(str));
        System.out.println(num2(str));
        System.out.println(num1("01"));
        System.out.println(num2("01"));
    }

    public static int num1(String str){
        if (str==null||str.equals(""))
            return 0;
        char[] chs = str.toCharArray();
        return process(chs, 0);
    }

    private static int process(char[] chs, int n){

        if (n==chs.length)
            return 1;
        if (chs[n]=='0')
            return 0;
        int res = process(chs, n+1);
        if (n+2<=chs.length&&((chs[n]-'0')*10+(chs[n+1]-'0')<27))
            res += process(chs, n+2);
        return res;
    }

    public static int num2(String str){

        if (str==null||str.equals(""))
            return 0;
         char[] chs = str.toCharArray();
         int next = 1;
         int cur = chs[chs.length-1]=='0'?0:1;
         int temp = 0;
         for (int i=chs.length-2;i>=0;i--){
             if (chs[i]=='0'){
                 next = cur;
                 cur = 0;
             }else {
                 temp = cur;
                 if ((chs[i]-'0')*10+chs[i+1]-'0'<27){
                     cur += next;
                     next = temp;
                 }
             }
         }
        return cur;
    }
}
