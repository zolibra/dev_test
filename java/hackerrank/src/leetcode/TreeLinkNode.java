package leetcode;

/**
 * Created by ray on 7/2/14.
 */
public class TreeLinkNode<T> {
    public T val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode(T x){
        val = x;
    }

    public static void connect(TreeLinkNode root) {

        if (root != null){
            root.next = null;
        }
        TreeLinkNode p = root;
        while(p != null){
            TreeLinkNode a = p;
            while(a != null){
                if (a.left != null){
                    a.left.next = a.right;
                }

                if (a.right != null && a.next != null){
                    a.right.next = a.next.left;
                }

                a = a.next;
            }
            p = p.left;
        }
    }

}
