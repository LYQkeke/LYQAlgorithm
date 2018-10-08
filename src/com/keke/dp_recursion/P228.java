package com.keke.dp_recursion;

/**
 * Created by KEKE on 2018/10/8
 *
 * 表达式得到期望结果的组成种数
 *
 * 给定一个只由0（假）、1（真）、&（逻辑与）、|（逻辑或）、^(逻辑异或)
 * 五种字符组成的字符串express，再给定一个布尔值desired。返回express能有
 * 多少种组合方式，可以达到desired的结果。
 */
public class P228 {

    public static void main(String[] args){

        String exprss = "1^0|0|1";
        System.out.println(num1(exprss, false));
    }

    // 递归
    public static int num1(String str, boolean desired){

        if (str==null||str.equals(""))
            return 0;
        char[] chs = str.toCharArray();
        if (!isValid(chs))
            return 0;
        return process(chs, desired, 0, chs.length-1);
    }

    private static int process(char[] chs, boolean desired, int l, int r){

        if (l==r){
            if (chs[l]=='1')
                return desired?1:0;
            else
                return desired?0:1;
        }
        int res = 0;
        if (desired){
            for (int i=l+1;i<r;i+=2){
                switch (chs[i]){
                    case '&':
                        res += process(chs, true, l, i-1)*process(chs, true, i+1, r);
                        break;
                    case '|':
                        res += process(chs, true, l, i-1)*process(chs, true, i+1, r);
                        res += process(chs, true, l, i-1)*process(chs, false, i+1, r);
                        res += process(chs, false, l, i-1)*process(chs, true, i+1, r);
                        break;
                    case '^':
                        res += process(chs, true, l, i-1)*process(chs, false, i+1, r);
                        res += process(chs, false, l, i-1)*process(chs, true, i+1, r);
                        break;
                }
            }
        }else {
            for (int i=l+1;i<r;i+=2){
                switch (chs[i]){
                    case '&':
                        res += process(chs, true, l, i-1)*process(chs, false, i+1, r);
                        res += process(chs, false, l, i-1)*process(chs, false, i+1, r);
                        res += process(chs, false, l, i-1)*process(chs, true, i+1, r);
                        break;
                    case '|':
                        res += process(chs, false, l, i-1)*process(chs, false, i+1, r);
                        break;
                    case '^':
                        res += process(chs, true, l, i-1)*process(chs, true, i+1, r);
                        res += process(chs, false, l, i-1)*process(chs, false, i+1, r);
                        break;
                }
            }
        }
        return res;
    }

    private static boolean isValid(char[] chs){
        // 字符串的长度不是奇数
        if ((chs.length&1) != 1)
            return false;
        for (int i=0;i<chs.length;i+=2){
            if ((chs[i]!='1')&&(chs[i]!='0'))
                return false;
        }
        for (int i=1;i<chs.length;i+=2){
            if ((chs[i]!='&')&&(chs[i]!='|')&&(chs[i]!='^'))
                return false;
        }
        return true;
    }
}
