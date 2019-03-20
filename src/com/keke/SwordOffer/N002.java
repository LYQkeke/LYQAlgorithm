package com.keke.SwordOffer;

/**
 * Created by KEKE on 2019/3/20
 *
 * 替换字符串中的空格
 *
 * 思想：倒着插入
 */
public class N002 {

    public static String replaceSpace(StringBuffer str){
        String s = str.toString();
        char[] chars = s.toCharArray();
        int len = 0;
        for (char c:chars){
            if (c==' ')
                len += 3;
            else
                len++;
        }
        char[] chars1 = new char[len];
        int j = len-1;
        for (int i=chars.length-1;i>=0;i--){
            if (chars[i]==' '){
                chars1[j--]='0';
                chars1[j--]='2';
                chars1[j--]='%';
            }else
                chars1[j--]=chars[i];
        }
        return new String(chars1);
    }
    public static void main(String[] args) {

    }
}
