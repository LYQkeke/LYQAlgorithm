package com.keke.linked_list;

/**
 * Created by KEKE on 2018/11/17
 *
 * 环形单链表的约瑟夫问题
 * 查数+杀人 。。。
 *
 * 附加;实现O(N)的算法
 */
public class P043 {

    public static void main(String[] args){


    }

     static class Node{

        public int value;
        Node next;

        public Node(int value){

            this.value = value;
        }
     }

     public static Node josephusKill1(Node head, int m){

        if (head==null||head.next==head||m<1)
            return head;
        Node last = head;//将last指向环的尾部
        while (last.next!=head){
            last = last.next;
        }
        int cnt = 0;
        while (last!=head){
            if (++cnt==m){
                last.next = head.next;
                cnt = 0;
            }else {
                last = last.next;
            }
            head = head.next;
        }
        return head;
     }
}
