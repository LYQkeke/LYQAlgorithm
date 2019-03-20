package com.keke.SwordOffer;

/**
 * Created by KEKE on 2019/3/20
 */
public class N001 {

    /**
     * 理解一下二分查找啊
     * @param target
     * @param array
     * @return
     */
    public boolean Find1(int target, int[][] array){

        /**
         * 想错了
         */
        int mid;
        int l = 0;
        int r = array[0].length-1;
        while (l<=r){
            mid = (l+r)/2;
            if (array[0][mid]<=target){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        if (r>=0){
            if (array[0][r]==target)
                return true;
            int i = r;
            l = 0;
            r = array.length-1;
            while (l<=r){
                mid = (l+r)/2;
                if (array[mid][i]==target)
                    return true;
                else if (array[mid][i]>target)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return false;
    }

    public boolean Find2(int target, int[][] array){
        int row = 0;
        int col = array[0].length-1;
        int temp = 0;
        while (col>=0&&row<array.length){
            temp = array[row][col];
            if (temp==target)
                return true;
            else if (temp>target)
                col--;
            else
                row++;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
