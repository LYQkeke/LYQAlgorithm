package com.keke.linked_list;

/**
 * Created by KEKE on 2018/10/19
 *
 * 删除链表的中间节点和a/b处的节点
 *
 */
public class P038 {

    public static void main(String[] args){

    }

    public static Node removeMidNode(Node head){

        if (head==null||head.next==null)
            return head;
        if (head.next.next==null)
            return head.next;
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next!=null&&cur.next.next!=null){
            cur = cur.next.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static Node removeByRatio(Node head, int a, int b){

        if (head==null||a<1||a>b)
            return head;
        int sum = 0;
        Node cur = head;
        while (cur!=null){
            ++sum;
            cur = cur.next;
        }
        int del = (int)Math.ceil(sum*(double)a/(double)b);
        if (del==1)
            return head.next;
        else {
            cur = head;
            int d = 1;
            while (d!=del){
                if (++d==del){
                    cur.next = cur.next.next;
                }else
                    cur = cur.next;
            }
            return head;
        }

    }

    static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }
}
