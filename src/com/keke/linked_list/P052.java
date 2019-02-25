package com.keke.linked_list;


import sun.security.mscapi.PRNG;

/**
 * Created by KEKE on 2019/2/23
 *
 * 将单链表按照某值划分为左边小，中间相等，右边大的形式
 *
 * 进阶：1 左中右三部分中数字的顺序与原始链表相同
 *       2 时间复杂度O(n) 空间复杂度O(1)
 */

public class P052 {

    static class Node{

        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static void print(Node head){
        String s = "";
        while (head!=null){
            s += Integer.toString(head.value);
            if (head.next!=null)
                s += "->";
            head = head.next;
        }
        System.out.println(s);
    }

    public static Node listPartition1(Node head, int pivot){

        int length = 0;
        Node cur = head;
        while (cur!=null){
            length++;
            cur = cur.next;
        }
        Node[] arr = new Node[length];
        cur = head;
        int idx = 0;
        while (cur!=null){
            arr[idx++] = cur;
            cur = cur.next;
        }
        int left = -1;
        int right = length;
        idx = 0;
        while (idx<right){
            if (arr[idx].value<pivot){
                swap(arr, ++left, idx++);
            }else if (arr[idx].value>pivot){
                swap(arr, --right, idx);
            }else {
                idx++;
            }
        }
        for (int i=0;i<arr.length-1;i++){
            arr[i].next = arr[i+1];
        }
        arr[length-1].next = null;
        return arr[0];
    }

    public static Node listPartition2(Node head, int pivot){

        Node leftHead = null;
        Node leftTail = null;
        Node midHead = null;
        Node midTail = null;
        Node rightHead = null;
        Node rightTail = null;
        Node next = null;
        while (head!=null){
            next = head.next;
            if (head.value<pivot){
                if (leftHead==null){
                    leftHead = head;
                    leftTail = head;
                }else {
                    leftTail.next = head;
                    leftTail = leftTail.next;
                }
                leftTail.next = null;
            }else if (head.value>pivot){
                if (rightHead==null){
                    rightHead = head;
                    rightTail = head;
                }else {
                    rightTail.next = head;
                    rightTail = rightTail.next;
                }
                rightTail.next = null;
            }else {
                if (midHead==null){
                    midHead = head;
                    midTail = head;
                }else {
                    midTail.next = head;
                    midTail = midTail.next;
                }
                midTail.next = null;
            }
            head = next;
        }
        if (leftTail!=null){
            leftTail.next = midHead;
            if (midTail==null)
                midTail = leftTail;
        }
        if (midTail!=null)
            midTail.next = rightHead;

        return leftHead!=null?leftHead:midHead!=null?midHead:rightHead;
    }
    public static void swap(Node[] arr, int i, int j){
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){

        Node head = new Node(9);
        head.next = new Node(0);
        Node tail = head.next;
        tail.next = new Node(4);
        tail = tail.next;
        tail.next = new Node(5);
        tail = tail.next;
        tail.next = new Node(1);
        print(head);
//        head = listPartition1(head, 3);
//        print(head);
        head = listPartition2(head, 3);
        print(head);
    }
}
