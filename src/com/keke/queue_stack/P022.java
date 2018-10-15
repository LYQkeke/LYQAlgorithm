package com.keke.queue_stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by KEKE on 2018/10/14
 *
 * 构造数组的MaxTree
 *
 * MaxTree的定义如下
 * 1. 数组必须没有重复元素
 * 2. MaxTree应该是一棵二叉树，数组中的每一个值对应一个二叉树节点
 * 3. 包括MaxTree在内且在其中的每一棵子树上，值最大的节点都是树的头
 *
 * nlog(n)的算法很好实现，排个序就可以了
 */
public class P022 {

    public static void main(String[] args){

        int[] arr1 = {3,4,5,1,2};
        int[] arr2 = {2,1,6,3,4,5,9,8,7};
        System.out.println(getMaxTree(arr1));
        System.out.println(getMaxTree(arr2));
    }

    public static Node getMaxTree(int[] arr){

        Node[] nodes = new Node[arr.length];
        HashMap<Node, Node> lBigMap = new HashMap<>(arr.length);
        HashMap<Node, Node> rBigMap = new HashMap<>(arr.length);
        for (int i=0;i<nodes.length;i++) {
            nodes[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<>();
        for (int i=0;i<nodes.length;i++){
            if (stack.isEmpty())
                stack.push(nodes[i]);
            else {
                while (!stack.isEmpty()&&nodes[i].value>stack.peek().value){
                    rBigMap.put(stack.pop(), nodes[i]);
                }
                if (!stack.isEmpty()){
                    lBigMap.put(nodes[i], stack.peek());
                }
                stack.push(nodes[i]);
            }
        }
        Node head = null;
        for (int i=0;i<nodes.length;i++){
            Node left = lBigMap.get(nodes[i]);
            Node right = rBigMap.get(nodes[i]);
            if (left==null&&right==null)
                head = nodes[i];
            else if (left==null){
                right.left = nodes[i];
            } else if (right==null){
                left.right = nodes[i];
            } else {
                if (left.value>right.value){
                    right.left = nodes[i];
                }else {
                    left.right = nodes[i];
                }
            }
        }
        return head;
    }

}
