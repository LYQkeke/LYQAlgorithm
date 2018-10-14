package com.keke.queue_stack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by KEKE on 2018/10/13
 *
 * 生成窗口最大数组
 */
public class P019 {

    public static void main(String[] args){
        int[] arr = {4,3,5,4,3,3,6,7};
        System.out.println(Arrays.toString(getMaxWindow(arr,3)));
    }

    public static int[] getMaxWindow(int[] arr, int w){

        if (arr==null||arr.length==0||w<1)
            return null;
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[arr.length-w+1];
        for (int i=0;i<arr.length;i++){
            while (!queue.isEmpty()&&arr[queue.peekLast()]<=arr[i])
                queue.pollLast();
            queue.addLast(i);
            if (queue.peekFirst()==i-w)
                queue.pollFirst();
            if (i>=w-1)
                res[i-w+1] = arr[queue.peekFirst()];
        }
        return res;
    }
}
