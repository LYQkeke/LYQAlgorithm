package com.keke.array_matrix;

/**
 * Created by KEKE on 2019/3/20
 *
 * 在行列都排好的矩阵中找数
 */
public class P347 {

    public static boolean find(int target, int[][] arr){

        int row = 0;
        int col =  arr[0].length;
        int temp = 0;
        while (row<arr.length&&col>=0){
            temp = arr[row][col];
            if (temp==target)
                return true;
            else if (temp<target)
                row++;
            else
                col--;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
