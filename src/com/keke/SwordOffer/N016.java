package com.keke.SwordOffer;

/**
 * Created by KEKE on 2019/3/22
 *
 * 树的子结构
 */
public class N016 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null)
            return false;
        if(isSame(root1,root2))
            return true;
        else
            return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }

    private static boolean isSame(TreeNode root1, TreeNode root2){
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        return (root1.val==root2.val)&&isSame(root1.left,root2.left)&&isSame(root1.right,root2.right);
    }

    public static TreeNode array2Treee(int[] arr){

        return null;
    }
    public static void main(String[] args) {

        int[] arr = {8,8,7,9,3,0,0,0,0,4,7};
    }
}
