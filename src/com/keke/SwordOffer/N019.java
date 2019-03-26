package com.keke.SwordOffer;

import java.util.ArrayList;

/**
 * Created by KEKE on 2019/3/25
 *
 * 顺时针打印矩阵
 */
public class N019 {

    public static ArrayList<Integer> printMatrix(int[][] matrix){

        if (matrix==null||matrix.length==0)
            return null;
        ArrayList<Integer> ansList = new ArrayList<>(matrix.length*matrix[0].length);
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        while (start*2<row&&start*2<col){
            printInCircle(ansList, matrix, start, row, col);
            start++;
        }
        return ansList;
    }

    private static void printInCircle(ArrayList<Integer> arr, int[][] matrix, int start, int row, int col){
        int lastCol = col - 1 - start;
        int lastRow = row - 1 - start;
        for (int i = start;i<=lastCol;i++)
            arr.add(matrix[start][i]);
        if (start<lastRow){
            for (int i = start+1;i<=lastRow;i++)
                arr.add(matrix[i][lastCol]);
        }
        if (start<lastCol&&start<lastRow){
            for (int i = lastCol-1;i>=start;i--)
                arr.add(matrix[lastRow][i]);
        }
        if (start<lastRow-1&&start<lastCol){
            for (int i = lastRow-1;i>start;i--)
                arr.add(matrix[i][start]);
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(printMatrix(mat));
    }
}
