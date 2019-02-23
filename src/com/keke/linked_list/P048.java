package com.keke.linked_list;

import java.util.Stack;

/**
 * Created by KEKE on 2018/11/20
 *
 * 给定一个链表的头节点head，判断该链表是否为回文结构
 *
 * 进阶：设计链表长度为N，时间复杂度为O(N)，额外空间复杂度为O(1)的算法
 */
public class P048 {

    static class Node{

        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static boolean isPalindrome1(Node head){

        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()){
            if (stack.pop().value!=head.value)
                return false;
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head){

        if (head==null||head.next==null)
            return true;
        Node cur = head;
        Node twice = head;
        while (twice.next!=null&&twice.next.next!=null){
            cur = cur.next;
            twice = twice.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (cur.next!=null){
            stack.push(cur.next);
            cur = cur.next;
        }
        while (!stack.isEmpty()){
            if (stack.pop().value!=head.value)
                return false;
            head = head.next;
        }
        return true;
    }

    /**
     * 空间复杂度O(1)
     * @param head
     * @return
     */
    public static boolean isPalindrome3(Node head){

        return false;
    }
    public static void main(String[] args){

        Node head = new Node(1);
        Node cur = head;
        for (int i=2;i<5;i++){
            cur.next = new Node(i);
            cur = cur.next;
        }
        for (int i=5;i>0;i--){
            cur.next = new Node(i);
            cur = cur.next;
        }
//        cur.next = new Node(3);
        System.out.println(isPalindrome1(head));
        System.out.println(isPalindrome2(head));
    }

}
