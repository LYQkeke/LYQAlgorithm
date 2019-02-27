package com.keke.linked_list;

import java.util.Stack;

/**
 * Created by KEKE on 2019/2/26
 *
 * 两个单链表生成相加链表
 *
 * p.s. 使用int可能会溢出
 *
 * 比如：9->3->7  +  6->3  =  1->0->0->0
 *
 */
public class P059
{

    static class Node {

        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 使用栈的方法
     * @param head1
     * @param head2
     * @return
     */
    public static Node addList1(Node head1, Node head2){

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (head1!=null){
            stack1.push(head1.value);
            head1 = head1.next;
        }

        while (head2!=null){
            stack2.push(head2.value);
            head2 = head2.next;
        }

        int a = 0;
        int b = 0;
        int c = 0;
        int s = 0;
        Node head = null;
        Node next = null;

        while (!stack1.isEmpty() || !stack2.isEmpty()){
            a = stack1.isEmpty()?0:stack1.pop();
            b = stack2.isEmpty()?0:stack2.pop();
            s = a + b + c;
            next = head;
            head = new Node(s%10);
            head.next = next;
            c = s/10;
        }

        if (c == 1){
            next = head;
            head = new Node(1);
            head.next = next;
        }
        return head;
    }

    /**
     * 不利用其它数据结构，使用链表的逆序进行add操作
     * @param head1
     * @param head2
     * @return
     */
    public static Node addList2(Node head1, Node head2){

        head1 = reverse(head1);
        head2 = reverse(head2);
        int a = 0;
        int b = 0;
        int c = 0;
        int s = 0;
        Node h1 = head1;
        Node h2 = head2;
        Node head = null;
        Node next = null;
        while (h1!=null||h2!=null){
            a = h1!=null?h1.value:0;
            b = h2!=null?h2.value:0;
            s = a+b+c;
            next = head;
            c = s/10;
            head = new Node(s%10);
            head.next = next;
            if (h1!=null)
                h1=h1.next;
            if (h2!=null)
                h2=h2.next;
        }
        if (c==1){
            next = head;
            head = new Node(1);
            head.next = next;
        }
        head1 = reverse(head1);
        head2 = reverse(head2);
        return head;
    }

    private static void print(Node head){
        String s = "";
        while (head!=null){
            s += Integer.toString(head.value);
            if (head.next!=null)
                s += "->";
            head = head.next;
        }
        System.out.println(s);
    }

    /**
     * 链表逆序
     * @param head
     * @return
     */
    private static Node reverse(Node head){

        Node pre = null;
        Node next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args){
        Node head1 = new Node(9);
        head1.next = new Node(3);
        head1.next.next = new Node(7);
        Node head2 = new Node(6);
        head2.next = new Node(3);
        print(head1);
        print(head2);
        print(addList1(head1, head2));
        print(addList2(head1, head2));
    }
}
