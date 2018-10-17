package com.keke.linked_list;

/**
 * Created by KEKE on 2018/10/17
 *
 * 打印两个链表的公共部分
 */
public class P034 {

    public static void main(String[] args){

    }

    public static void printCommonPart(Node head1, Node head2){

        System.out.println("Common part: ");
        while (head1.next!=null&&head2.next!=null){
            if (head1.value<head2.value)
                head1 = head1.next;
            else if (head2.value<head1.value)
                head2 = head2.next;
            else {
                System.out.println(head1.value+" ");
                head1 = head1.next;
                head2 = head2.next;
            }
            System.out.println();
        }
    }

}

class Node{

    public int value;
    public Node next;

    public Node(int value){
        this.value = value;
    }
}