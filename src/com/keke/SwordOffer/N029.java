package com.keke.SwordOffer;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by KEKE on 2019/3/26
 *
 * 最小的k个数
 */
public class N029 {

    public static ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k){

        if (input==null||input.length==0||k==0||k>input.length)
            return null;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(4, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        for (int i=0;i<input.length;i++){
            if (maxHeap.size()<k)
                maxHeap.add(input[i]);
            else if (input[i]<maxHeap.peek()){
                maxHeap.poll();
                maxHeap.add(input[i]);
            }
        }
        ArrayList<Integer> ansList = new ArrayList<>(k);
        ansList.addAll(maxHeap);
        return ansList;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.println(getLeastNumbers_Solution(arr, 0));
    }
}
