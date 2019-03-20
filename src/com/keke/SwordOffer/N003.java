package com.keke.SwordOffer;

import java.util.ArrayList;

/**
 * Created by KEKE on 2019/3/20
 *
 * 从尾到头打印链表
 */
public class N003 {

    static class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val){
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode==null)
            return new ArrayList<Integer>();
        ListNode cur = listNode;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (cur!=null){
            arrayList.add(0);
            cur = cur.next;
        }
        cur = listNode;
        int index = arrayList.size()-1;
        while (cur!=null){
            arrayList.set(index--, cur.val);
            cur = cur.next;
        }
        return arrayList;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i=2;i<5;i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        printListFromTailToHead(head);
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.set(2,0);
    }
}
