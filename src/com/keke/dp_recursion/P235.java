package com.keke.dp_recursion;

/**
 * Created by KEKE on 2018/10/8
 *
 * 跳跃游戏
 *
 * 给定数组arr，arr[i]==k代表可以从位置i向右跳1-k个距离。比如，arr[2] = 3，代表
 * 从位置2可以跳到位置3、位置4或位置5。如果从位置0出发，返回最少跳几次能跳到arr
 * 最后的位置上。
 */
public class P235 {

    public static void main(String[] args){

        int[] arr = {3,2,3,1,1,4};
        System.out.println(jump(arr));
    }

    public static int jump(int[] arr){
        if (arr==null||arr.length==0)
            return 0;
        int jump = 0;
        int cur = 0;
        int next = 0;
        for (int i=0;i<arr.length;i++){
            if (i>cur){
                cur = next;
                jump++;
            }
            next = Math.max(next, i+arr[i]);
        }
        return jump;
    }
}
