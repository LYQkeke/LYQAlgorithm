package com.keke.queue_stack;

import java.util.Stack;

/**
 * Created by KEKE on 2018/10/15
 *
 * 给定一个整型矩阵map，其中只有0和1两种值，求其中全是1的所有矩形区域中，最大的
 * 矩形区域1的个数。
 */
public class P026 {

    public static void main(String[] args){

        int[][] map1 = {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        int[][] map2 = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(getMaxRect(map1));
        System.out.println(getMaxRect(map2));
    }

    public static int getMaxRect(int[][] map){

        if (map==null||map.length==0||map[0].length==0)
            return 0;
        int[] height = new int[map[0].length];
        int max = 0;
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++){
                height[j] = map[i][j]==0?0:++height[j];
            }
            max = Math.max(getMaxRectFromHeight2(height), max);
        }
        return max;
    }

    private static int getMaxRectFromHeight1(int[] heights){

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i=0;i<heights.length;i++){
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                int height = heights[stack.pop()];
                int left = stack.isEmpty()?-1:stack.peek();
                max = Math.max(max, height*(i-left-1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int length = heights.length;
            int height = heights[stack.pop()];
            int left = stack.isEmpty()?-1:stack.peek();
            max = Math.max(max, height*(length-left-1));
        }
        return max;
    }

    public static int getMaxRectFromHeight2(int[] heights){

        int length = heights.length;
        int[] lSmallMap = new int[length];
        int[] rSmallMap = new int[length];
        for (int i=0;i<length;i++){
            lSmallMap[i] = -1;
            rSmallMap[i] = length;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<length;i++){

            if (stack.isEmpty())
                stack.push(i);
            else {
                while (!stack.isEmpty()&&heights[i]<=heights[stack.peek()]){
                    rSmallMap[stack.pop()] = i;
                }
                if (!stack.isEmpty()){
                    lSmallMap[i] = stack.peek();
                }
                stack.push(i);
            }
        }
        int max = 0;
        for (int i=0;i<length;i++){
            max = Math.max(max, heights[i]*(rSmallMap[i]-lSmallMap[i]-1));
        }
        return max;
    }
}
