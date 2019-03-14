package com.keke.string;

/**
 * Created by KEKE on 2019/3/14
 *
 * 在有序但含有空的数组中查找字符串
 * example:
 * strs = [null,"a",null,"a",null,"b",null,"c"], str = "a" , return 1
 *
 * O(n)的算法肯定不能接受
 * 二分查找，实现O(logn)的算法
 *
 * compareTo 比较字典序
 */
public class P258 {

    public static int getIndex(String[] strs, String str){

        if (strs==null||strs.length==0||str==null)
            return -1;
        int left = 0;
        int right = strs.length-1;
        int mid;
        while (left<right){
            mid = (left+right)/2;
            if (strs[mid]!=null){
                int flag = strs[mid].compareTo(str);
                if (flag<0)
                    left = mid + 1;
                if (flag==0)
                    right = mid;
                if (flag>0)
                    right = mid - 1;
            }else {
                int i = mid;
                while (i>left&&strs[i]==null){
                    i--;
                }
                if (strs[i]==null)
                    left = mid + 1;
                else {
                    int flag = strs[i].compareTo(str);
                    if (flag<0)
                        left = mid+1;
                    if (flag==0)
                        right = i;
                    if (flag>0)
                        right = i-1;
                }
            }
        }
        if (strs[left]!=null&&strs[left].compareTo(str)==0)
            return left;
        return -1;
    }
    public static void main(String[] args){

        String[] strs = {null,null,null,"a",null,"b",null,"c","z"};
        System.out.println(getIndex(strs, "z"));
    }
}
