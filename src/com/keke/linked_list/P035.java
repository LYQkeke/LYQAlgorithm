package com.keke.linked_list;

/**
 * Created by KEKE on 2018/10/17
 *
 * 在单链表和双链表中删除导数第k个节点
 */
public class P035 {

    public static void main(String[] args){
        SNode head = new SNode(0);
        SNode cur = head;
        for (int i=1;i<=10;i++){
            cur.next = new SNode(i);
            cur = cur.next;
        }
        removeSKth(head, 2);
        DNode head1 = new DNode(0);
        DNode dcur = head1;
        for (int i=1;i<=5;i++){
            dcur.next = new DNode(i);
            dcur.next.last = dcur;
            dcur = dcur.next;
        }
        removeDKth(head1,3);
    }

    public static SNode removeSKth(SNode head, int kth){

        if (head==null||kth<1)
            return head;
        SNode cur = head;
        while (cur!=null){
            cur = cur.next;
            kth--;
        }
        if (kth>0)
            return head;
        else if (kth==0)
            return head.next;
        else {
            cur = head;
            while (kth != 0) {
                if (++kth == 0) {
                    cur.next = cur.next.next;
                } else
                    cur = cur.next;
            }
            return head;
        }
    }

    public static DNode removeDKth(DNode head, int kth){

        if (head==null||kth<1)
            return head;
        DNode cur = head;
        while (cur!=null){
            cur = cur.next;
            kth--;
        }
        if (kth>0)
            return head;
        else if (kth==0)
            return head.next;
        else {
            cur = head;
            while (kth!=0){
                if (++kth==0){
                    cur.next.next.last = cur;
                    cur.next = cur.next.next;
                }else
                    cur = cur.next;
            }
        }
        return head;
    }

    static class SNode {
        public int value;
        public SNode next;

        public SNode(int value){
            this.value = value;
        }
    }

    static class DNode{

        public int value;
        public DNode last;
        public DNode next;

        public DNode(int value){
            this.value = value;
        }
    }
}


