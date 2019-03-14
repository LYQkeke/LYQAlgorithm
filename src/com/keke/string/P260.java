package com.keke.string;

import java.util.Arrays;

/**
 * Created by KEKE on 2019/3/14
 *
 * 给定一个字符类型数组chas[]，其中只含有数字字符和"*"字符。现在想把所有的"*"移到chas的左边
 * 数字移到chas的右边，请完成调整函数
 *
 * 倒着复制...
 */
public class P260 {

    public static void adjust(char[] chars){
        if (chars==null|chars.length==0)
            return;
        int i = chars.length-1;
        int j = chars.length-1;
        for (;i>=0;i--){
            if (chars[i]!='*')
                chars[j--] = chars[i];
        }
        while (j>-1){
            chars[j--] = '*';
        }
    }

    public static void main(String[] args){

         char[] chars = "12**345".toCharArray();
         adjust(chars);
         System.out.println(Arrays.toString(chars));
    }
}
