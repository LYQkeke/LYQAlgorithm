package com.keke.SwordOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by KEKE on 2019/4/10
 *
 * 数据流中的中位数
 */
public class N063 {

    static PriorityQueue<Integer> lessHeap;
    static PriorityQueue<Integer> moreHeap;

    static {
        moreHeap = new PriorityQueue<>();
        lessHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1,o2);
            }
        });
    }

    public static void Insert(Integer num) {
        if (lessHeap.size()==0)
            lessHeap.add(num);
        else if (num>lessHeap.peek()){
            moreHeap.add(num);
            if (moreHeap.size()-lessHeap.size()>1)
                lessHeap.add(moreHeap.poll());
        }else {
            lessHeap.add(num);
            if (lessHeap.size()-moreHeap.size()>1)
                moreHeap.add(lessHeap.poll());
        }
    }

    public static Double GetMedian() {

        if (moreHeap.size()==0 && lessHeap.size()==0)
            return 0.0;
        else if (moreHeap.size()>lessHeap.size())
            return moreHeap.peek().doubleValue();
        else if (lessHeap.size()>moreHeap.size())
            return lessHeap.peek().doubleValue();
        else
            return (lessHeap.peek()+moreHeap.peek())/2.0;
    }

    public static void main(String[] args) {
        Insert(1);
        Insert(3);
        Insert(5);
        System.out.println(GetMedian());
    }
}
