package com.keke.string;

/**
 * Created by KEKE on 2019/3/4
 *
 * 给定三个字符串str、from、to，已知from字符串中无重复字符，把str中的from字符，替换成to字符串
 * 对于重复出现的from串，只替换成一个to字符串
 */
public class P251 {

    public static String replace(String str, String from, String to){
        if (str.length()<from.length())
            return str;
        char[] chars = str.toCharArray();
        char[] chars1 = from.toCharArray();
        int match = 0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]==chars1[match]){
                if (match==from.length()-1){
                    // 替换成 0
                    while (match>=0){
                        chars[i-match] = 0;
                        match--;
                    }
                    match=0;
                }else
                    match++;
            }else {
                match = 0;
            }
        }
        String ans = "";
        for (int i=0;i<chars.length;i++){
            if (chars[i]!=0)
                ans = ans + String.valueOf(chars[i]);
            else {
                ans = ans + to;
                while (i<chars.length&&chars[i]==0)
                    i++;
                i--;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        String str = "abc12abc3abcabc";
        String from = "abc";
        String to = "X";
        System.out.println(replace(str, from, to));
    }
}
