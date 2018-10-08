package com.keke.dp_recursion;

/**
 * Created by KEKE on 2018/10/8
 *
 * 排成一条线的纸牌博弈问题
 *
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线。玩家A和玩家B
 * 依次拿走每张纸牌，规定玩家A先拿，玩家B后拿，但是每个玩家只能拿走
 * 最左边或者最右边的纸牌，玩家A和玩家B都决定聪明。请返回最后的获胜
 * 者分数。
 */
public class P233 {

    public static void main(String[] args){
        int[] arr1 = {1,2,100,4};
        int[] arr2 = {1,100,2};
        System.out.println(win1(arr1));
        System.out.println(win1(arr2));
        System.out.println(win2(arr1));
        System.out.println(win2(arr2));
    }

    public static int win1(int[] arr){
        if (arr==null||arr.length==0)
            return 0;
        return Math.max(f(arr, 0, arr.length-1), s(arr, 0, arr.length-1));
    }

    private static int f(int[] arr, int l, int r){
        if (l==r)
            return arr[l];
        return Math.max(arr[l]+s(arr, l+1,r), arr[r]+s(arr, l, r-1));
    }

    private static int s(int[] arr, int l, int r){
        if (l==r)
            return 0;
        return Math.min(f(arr,l+1,r ), f(arr, l, r-1));
    }

    public static int win2(int[] arr){
        if (arr==null||arr.length==0)
            return 0;
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j=0;j<arr.length;j++){
            f[j][j] = arr[j];
            for (int i=j-1;i>=0;i--){
                f[i][j] = Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j], f[i][j-1]);
            }
        }
        return Math.max(f[0][arr.length-1], s[0][arr.length-1]);
    }
}
