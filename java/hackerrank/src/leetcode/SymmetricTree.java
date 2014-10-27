package leetcode;

import java.util.*;

/**
 * Created by ray on 10/9/14.
 */


public class SymmetricTree {

/*
It seems No way to solve this issue with inorder way
 */

//    public List<String> inorder(TreeNode p, List<String> list) {
//        if(p == null){
//            list.add("#");
//            return list;
//        }
//        if(p.left == null && p.right == null){
//            list.add(""+String.valueOf(p.val));
//        }else{
//            inorder(p.left, list);
//            list.add(""+String.valueOf(p.val));
//            inorder(p.right, list);
//        }
//        return list;
//    }
//
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null){
//            return true;
//        }
//        if(root.left == null&& root.right == null){
//            return true;
//        }
//        List<String> list = new ArrayList<String>();
//        List<String> arr = inorder(root,list);
//        for(int i = 0; i < arr.size()/2; i++){
//            if(!arr.toArray()[i].equals(arr.toArray()[arr.size()-1-i]) ){
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean recursive_check(TreeNode left, TreeNode right){

        if(left == null && right == null){
            return true;
        }

        if(left == null || right ==null){
            return false;
        }
        return left.val == right.val &&  recursive_check(left.left, right.right) && recursive_check(left.right, right.left);

    }

    public boolean iteration_check(TreeNode left , TreeNode right) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(left);
        s2.push(right);
        while (!s1.empty() && !s2.empty()) {
            TreeNode n1 = s1.pop();
            TreeNode n2 = s2.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;
            s1.push(n1.left);
            s2.push(n2.right);
            s1.push(n1.right);
            s2.push(n2.left);
        }
        return true;
    }


    public boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
//      return recursive_check(root.left, root.right);
        return iteration_check(root.left, root.right);

    }


    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(2);
        root.right.right.left = new TreeNode(2);
        System.out.print(tree.isSymmetric(root));

    }
}
