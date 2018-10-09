package com.keke.dp_recursion;

/**
 * Created by KEKE on 2018/10/8
 *
 * N皇后问题
 *
 * N皇后问题指的是在N * N 的棋盘上要摆N个皇后，要求任何两个皇后不同行、不
 * 同列，也不在同一条斜线上。给定一个整数n，返回n皇后的摆法有多少种。
 */
public class P238 {

    public static void main(String[] args){

        // 8皇后的正确答案为92
        System.out.println(num1(8));
        System.out.println(num2(8));
//        System.out.println(1<<31);
    }

    public static int num1(int n){
        if (n<1)
            return 0;
        // 使用pos数组，存储第n行放置的棋子的列号
        int[] pos = new int[n];
        return process1(0, pos, n);
    }

    private static int process1(int i, int[] pos, int n){
        if (i==n)
            return 1;
        int res = 0;
        for (int j=0;j<n;j++){
            if (isValid(i, j, pos)){
                pos[i] = j;
                res += process1(i+1, pos, n);
            }
        }
        return res;
    }

    /**
     * 当放置到第i行的时候， 判断在第j列，放置是否违反8皇后的放置规则
     * 按行放置已经避免了在同一行，所以只需要判断是否在同一列或者在
     * 同一条斜线之上
     * @param i
     * @param j
     * @param pos
     * @return
     */
    private static boolean isValid(int i, int j, int[] pos){
        for (int k=0;k<i;k++){
            if (pos[k]==j||Math.abs(k-i)==Math.abs(pos[k]-j))
                return false;
        }
        return true;
    }

    /**
     * 使用位运算的方法对递归方法尽心了优化
     * @param n
     * @return
     */
    public static int num2(int n){

        // 使用int来进行位标记，最多能处理32皇后问题
        if (n<1||n>32)
            return 0;
        int upperLim = n==32?-1:(1<<n)-1;
        return process2(upperLim, 0, 0, 0);
    }

    /**
     * @param upperLim 每一行可供选择的位置
     * @param colLim 已经摆放了的列，1 代表已经摆放
     * @param leftDiaLim 受之前摆放的影响（向左侧方向的斜线），当前行不能进行摆放的位置，1 表示不能摆放
     * @param rightDiaLim （向右侧方向的斜线）
     */
    private static int process2(int upperLim, int colLim, int leftDiaLim, int rightDiaLim){

        if (upperLim==colLim)
            return 1;
        int pos = upperLim & ~(colLim | leftDiaLim | rightDiaLim);
        int mostRightPos = 0;
        int res = 0;
        while (pos!=0){
            mostRightPos = pos & (~pos + 1);
            pos = pos - mostRightPos;
            res += process2(upperLim, colLim|mostRightPos, (leftDiaLim|mostRightPos)<<1, (rightDiaLim|mostRightPos)>>>1 );
        }
        return res;
    }

}
