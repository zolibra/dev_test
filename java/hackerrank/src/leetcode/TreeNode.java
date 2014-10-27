package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

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

    public static void visit(TreeNode node) {
        System.out.println(node.val + "");
    }

    public static List<Integer> preorder(TreeNode p, List<Integer> list) {
        if (p != null) {
            list.add((Integer) p.val);
            preorder(p.left, list);
            preorder(p.right, list);
        }
        return list;
    }

    //no recursive
    public static Vector<Integer> preorderNonRecursive(TreeNode root) {
        Vector<Integer> result = new Vector<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        if (root != null) {
            stack.push(p);
        }
        while (!stack.empty()) {
            p = stack.peek();
            stack.pop();
            result.add((Integer) p.val);
            if (p.right != null) stack.push(p.right);
            if (p.left != null) stack.push(p.left);
        }

        return result;

    }

    public static Vector<Integer> inorderNonRecursive(TreeNode root) {
        Vector<Integer> result = new Vector<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.peek();
                stack.pop();
                result.add((Integer) p.val);
                p = p.right;
            }
        }
        return result;
    }

    public static List<Integer> postorderNonRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode prevNode;
        do {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            prevNode = null;
            while (!stack.empty()) {
                p = stack.peek();
                stack.pop();
                if (p.right == prevNode) {
                    result.add((Integer) p.val);
                    prevNode = p;
                } else {
                    stack.push(p);
                    p = p.right;
                    break;
                }

            }
        } while (!stack.empty());
        return result;

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return left >= right ? left + 1 : right + 1;
    }

    public static int minDepth(TreeNode root){
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0)return right+1;
        if(right == 0)return left+1;
        return left < right ? left +1 : right +1;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        } else {
            return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
    //check if the tree is a validate Binary Search Tree
    public boolean check(TreeNode p, int min, int max){
        if(p == null)return true;
        if((Integer)p.val<= min || (Integer)p.val >= max)return false;

        if(!check(p.left, min, (Integer)p.val) || !check(p.right, (Integer)p.val, max)){
            return false;
        }

        return true;
    }
    public boolean isValidBST(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
