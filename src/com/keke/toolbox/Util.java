package com.keke.toolbox;

/**
 * Created by KEKE on 2018/8/2
 */
public class Util {

    /**
     * 矩阵乘法，要求输入的必须是方阵，至少1*1
     * @param mat1
     * @param mat2
     * @return
     */
    public static int[][] matMul(int[][] mat1, int[][] mat2){
        int[][] res = new int[mat1.length][mat1[0].length];
        for (int i=0;i<mat1.length;i++){
            for (int j=0;j<mat1[0].length;j++){
                for (int k=0;k<mat2[0].length;k++){
                    res[i][j] += mat1[i][k]*mat2[k][j];
                }
            }
        }
        return res;
    }

    /**
     * 输入也同时为方阵
     * 矩阵的快速平方计算，可以在 O(logn)的复杂度内完成
     * 如果n为0则返回一个单位矩阵
     * @param mat
     * @param n
     * @return
     */
    public static int[][] matPow(int[][] mat, int n){
        int[][] res = new int[mat.length][mat[0].length];
        for (int i=0;i<res.length;i++)
            res[i][i] = 1;
        int[][] temp = mat;
        for (;n!=0;n>>=1){
            if ((n&1)!=0)
                res = matMul(res,temp);
            temp = matMul(temp,temp);
        }
        return res;
    }
}
