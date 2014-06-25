package com.mytest;

/**
 * Created by ray on 6/25/14.
 */

public class TreeNode<T> {
    public T val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(T x) {
        val = x;
    }

    public static void visit(TreeNode node){
        System.out.println(node.val + "");
    }

    public static void preorder(TreeNode p){
        if (p != null){
            preorder(p.left);
            preorder(p.right);
        }

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return left >= right ? left + 1 : right + 1;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null || q == null){
            return p==q;
        }else{
            return (p.val == q.val)&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
    }
}
