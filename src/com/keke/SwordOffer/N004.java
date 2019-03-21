package com.keke.SwordOffer;

import java.util.HashMap;

/**
 * Created by KEKE on 2019/3/21
 */
public class N004 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if (pre==null||in==null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<in.length;i++)
            map.put(in[i],i);
        return preIn(pre, 0, pre.length-1, in, 0, in.length-1, map);
    }

    private static TreeNode preIn(int[] pre, int pl, int pr, int[] in, int il, int ir, HashMap<Integer, Integer> map){

        if (pl>pr)
            return null;
        TreeNode head = new TreeNode(pre[pl]);
        int index = map.get(pre[pl]);
        head.left = preIn(pre, pl+1, pl+index-il, in, il, index-1, map);
        head.right = preIn(pre, pl+index+1-il, pr, in, index+1, ir, map );
        return head;
    }

    public static void main(String[] args) {

    }
}
