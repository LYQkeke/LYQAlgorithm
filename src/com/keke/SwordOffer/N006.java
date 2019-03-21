package com.keke.SwordOffer;

/**
 * Created by KEKE on 2019/3/21
 *
 * 旋转数组中的最小数字
 */
public class N006 {

    public static int minNumberInRotateArray(int[] array){

        if (array.length==0)
            return 0;
        int l = 0;
        int r = array.length-1;
        int mid;
        while (l<r){
            mid = (l+r)/2;
            if (array[mid]<=array[r])
                r = mid;
            else
                l = mid + 1;
        }
        return array[l];
    }

    public static void main(String[] args) {

        int[] arr ={3,4,5,6,7,1,2};
        System.out.println(minNumberInRotateArray(arr));
    }
}
