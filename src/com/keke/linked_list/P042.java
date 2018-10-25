package com.keke.linked_list;

/**
 * Created by KEKE on 2018/10/23
 * 反转部分单链表
 *
 * 给定一个单向链表的头节点，以及两个整数from和to，在单向链表上把第
 * from个节点到第to个节点进行反转。
 */
public class P042 {

    public static void main(String[] args){

        Node head = new Node(1);
        Node cur = head;
        for (int i=2;i<=6;i++){
            cur.next = new Node(i);
            cur = cur.next;
        }
        head = removePart(head, 2, 5);
        System.out.println();
    }

    public static Node removePart(Node head, int from, int to){

        int cnt = 0;
        Node cur = head;
        Node pre = null;
        Node tail = null;
        while (cur!=null){
            ++cnt;
            pre = cnt==from-1?cur:pre;
            tail = cnt==to+1?cur:tail;
            cur = cur.next;
        }
        //from和to不符合要求直接返回，不需要翻转
        if (from<1||to>cnt||from>to)
            return head;
        Node node1 = pre.next;
        Node node2 = node1.next;
        node1.next = tail;
        Node next = null;
        while (node2!=tail){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (pre!=null){
            pre.next = node1;
            return head;
        }
        return node1;
    }

    static class Node{

        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }
}
