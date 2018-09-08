package com.keke.dp_recursion;

/**
 * Created by KEKE on 2018/8/24
 */
public class LIS {

    /**
     * 给定数组arr，返回arr的最长递增子序列
     * 例子：arr=[2,1,5,3,6,4,8,9,7]，返回的最长递增子序列为[1,3,4,8,9]
     */

    private static int[] getdp1(int[] arr){

        int[] dp = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            dp[i] = 1;
            for (int j=0;j<i;j++){
                if (arr[j]<arr[i])
                    dp[i] = Math.max(dp[j]+1,dp[i]);
            }
        }
        return dp;
    }

    private static int[] getdp2(int[] arr){

        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        dp[0] = 1;
        ends[0] = arr[0];
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i=1;i<arr.length;i++){
            l = 0;
            r = right;
            // 如果在有效区之内存在一个大于 arr[i] 的值 那么这个值将由l指向
            while (l<=r){
                m = (l + r)/2;
                if (arr[i]>ends[m]){
                    l = m + 1;
                }else
                    r = m - 1;
            }
            // 确定有效区边界
            // 如果 在上一次查找中在 有效区中找到比arr[i] 大的元素 则以 right ...
            // 如果没有找到的话，l 的值会比right大1
            // 反正一直都是以l和right中较大的值为新的right
            right = Math.max(l, right);
            dp[i] = l + 1;
            ends[l] = arr[i];
        }
        return dp;
    }

    private static int[] generateLIS(int[] dp, int[] arr){
        int len = 0;
        int index = 0;
        for (int i=0;i<dp.length;i++){
            if (dp[i]>len){
                len = dp[i];
                index = i;
            }
        }
        int[] lis = new int[len];
        lis[--len] = arr[index];
        for (int i=index;i>=0;i--){
            if (dp[i]==dp[index]-1 && arr[i]<arr[index]){
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }

    public static int[] lis1(int[] arr){

        if (arr==null || arr.length==0)
            return null;
        int[] dp = getdp1(arr);
        return generateLIS(dp, arr);
    }

    public static int[] lis2(int[] arr){

        if (arr==null||arr.length==0)
            return null;
        int[] dp = getdp2(arr);
        return generateLIS(dp, arr);

    }
}
