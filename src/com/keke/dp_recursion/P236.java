package com.keke.dp_recursion;

import java.util.HashMap;

/**
 * Created by KEKE on 2018/10/8
 *
 * 数组中最长的连续序列
 *
 * 给定无序数组arr，返回其中最长的连续序列长度。
 *
 * arr = [100,4,200,1,3,2] 最长的连续序列为 [1,2,3,4]
 * 所以返回4
 */
public class P236 {

    public static void main(String[] args){

        int[] arr = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));
    }

    /**
     * 时间复杂度O(N) 空间复杂度O(1)
     * @param arr
     * @return
     */
    public static int longestConsecutive(int[] arr){

        if (arr==null||arr.length==0)
            return 0;
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            // 当map中没有的时候才进行添加和修改
            if (!map.containsKey(arr[i])){
                map.put(arr[i],1);
                if (map.containsKey(arr[i]-1)){
                    max = Math.max(max, merge(map,arr[i]-1, arr[i]));
                }
                if (map.containsKey(arr[i]+1)){
                    max = Math.max(max, merge(map, arr[i], arr[i]+1));
                }
            }
        }
        return max;
    }

    private static int merge(HashMap<Integer, Integer> map, int less, int more){
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }
}
