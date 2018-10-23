package com.keke.linked_list;


/**
 * Created by KEKE on 2018/10/22
 */
public class P040 {

    public static void main(String[] args){

//        SNode head1 = new SNode(1);
//        SNode cur = head1;
//        for (int i=2;i<=5;i++){
//            cur.next = new SNode(i);
//            cur = cur.next;
//        }
//        head1 = reverseSList(head1);

        DNode head = new DNode(1);
        DNode cur = head;
        for (int i=2;i<=5;i++){
            cur.next = new DNode(i);
            cur.next.last = cur;
            cur = cur.next;
        }
        head = reverseDList(head);
        System.out.println();
    }

    public static SNode reverseSList(SNode head){

        SNode pre = null;
        SNode next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DNode reverseDList(DNode head){

        DNode pre = null;
        DNode next = null;
        while (head!=null){
            next = head.next;
            head.last = null;
            head.next = pre;
            if (pre!=null)
                pre.last = head;
            pre = head;
            head = next;
        }
        return pre;
    }

    static class SNode{
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
