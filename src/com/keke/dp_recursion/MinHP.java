package com.keke.dp_recursion;

/**
 * Created by KEKE on 2018/9/28
 *
 * 给定一个二维数组map，含义是一张地图，例如，如下矩阵
 *  -2  -3   3
 *  -5  -10  1
 *  0   30  -5
 *  游戏的规则如下：
 *  1.骑士从左上角出发，每次只能向右或者向下走，最后到达右下角见到公主
 *  2.此图中每个位置的值代表骑士要遭遇的事情。如果是负数，说明此处有怪兽，要让骑士损失血量。如果为非负数，代表此处有血瓶，能让骑士回血。
 *  3.骑士从左上角到达右下角的过程中，走到任何一个位置时，血量都不能少于1.
 *  为了保证骑士能见到公主，初始的血量至少是多少。
 */
public class MinHP {

    public static void main(String[] args){

        int[][] map = {{-2,-3,3},{-5,-10,1},{0,30,5}};
        System.out.println(minHP(map));
    }

    public static int minHP(int[][] map){

        if (map==null||map.length==0||map[0].length==0)
            return 0;
        int row = map.length;
        int col = map[0].length;
        int[][] dp = new int[row--][col--];
        dp[row][col] = map[row][col]>0?1:1-map[row][col];
        for (int i = col-1;i>=0;i--)
            dp[row][i] = Math.max(dp[row][i+1]-map[row][i],1);
        int right = 0;
        int down = 0;
        for (int i=row-1;i>=0;i--){
            dp[i][col] = Math.max(dp[i+1][col]-map[i][col],1);
            for (int j=col-1;j>=0;j--){
                right = Math.max(dp[i][j+1]-map[i][j],1);
                down = Math.max(dp[i+1][j]-map[i][j],1);
                dp[i][j] = Math.min(right,down);
            }
        }
        return dp[0][0];
    }
}
