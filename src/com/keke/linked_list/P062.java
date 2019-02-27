package com.keke.linked_list;

/**
 * Created by KEKE on 2019/2/27
 *
 * 两个链表相交的一系列问题
 *
 * 本题中，单链表可能有环，也可能无环。
 * 给定两个单链表的头节点head1和head2，这两个单链表可能相交，也可能不相交。
 * 请实现一个函数，如果两个链表相交，请返回第一个相交的节点，如果没有，返回null
 */
public class P062 {

    static class Node{

        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 判断量表中是否有环
     * 如果有的话，返回进入Loop的节点
     * @param head
     * @return
     */
    private static Node getLoopNode(Node head){

        if (head==null||head.next==null||head.next.next==null){
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow!=fast){
            if (fast.next==null||fast.next.next==null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 两个链表无环时判断是否相交
     * @param head1
     * @param head2
     * @return
     */
    private static Node noLoop(Node head1, Node head2){
        int len1 = 0;
        int len2 = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1!=null){
            len1++;
            cur1 = cur1.next;
        }
        while (cur2!=null){
            len2++;
            cur2 = cur2.next;
        }
        if (cur1!=cur2)
            return null;
        if (len1<len2){
            Node temp =head1;
            head1 = head2;
            head2 = temp;
        }
        int dis = Math.abs(len1-len2);
        while (dis--!=0)
            head1 = head1.next;
        while (head1!=head2){
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }

    /**
     * 当两个都有环时，判断两个链表是否是否相交
     * @param head1
     * @param head2
     * @param loopNode1
     * @param loopNode2
     * @return
     */
    private static Node bothLoop(Node head1, Node head2, Node loopNode1, Node loopNode2){

        Node cur1 = null;
        Node cur2 = null;
        if (loopNode1==loopNode2){
            cur1 = head1;
            cur2 = head2;
            int len1 = 0;
            int len2 = 0;
            while (cur1!=loopNode1){
                len1++;
                cur1 = cur2.next;
            }
            while (cur2!=loopNode2){
                len2++;
                cur2 = cur2.next;
            }
            if (len1<len2){
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }
            int dis = Math.abs(len1-len2);
            while (dis--!=0)
                head1 = head1.next;
            while (head1!=head2){
                head1 = head1.next;
                head2 = head2.next;
            }
            return null;
        }else {
            cur1 = loopNode1.next;
            while (cur1!=loopNode1){
                if (cur1==loopNode2)
                    return loopNode1;
            }
            return head1;
        }
    }

    private static Node getIntersectNode(Node head1, Node head2){

        if (head1==null||head2==null)
            return null;
        Node loopNode1 = getLoopNode(head1);
        Node loopNode2 = getLoopNode(head2);
        if (loopNode1==null&&loopNode2==null)
            return noLoop(head1, head2);
        else if (loopNode1!=null&&loopNode2!=null)
            return bothLoop(head1, loopNode1, head2, loopNode2);
        else
            return null;
    }

    public static void main(String[] args){
        /**
         * 没有给出测试数据
         */
    }
}
