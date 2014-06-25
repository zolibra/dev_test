package test.com.mytest; 

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import com.mytest.TreeNode;

import static org.junit.Assert.assertEquals;

/** 
* testMaxDepthOfBinTree Tester. 
* 
* @author <Authors name> 
* @since <pre>Jun 25, 2014</pre> 
* @version 1.0 
*/ 
public class TreeNodeTest {

        TreeNode<Integer> root;
        TreeNode<Integer> node2;
        TreeNode<Integer> node3;
        TreeNode<Integer> node4;
        TreeNode<Integer> node5;

        TreeNode<Integer> root2;
        TreeNode<Integer> node22;
        TreeNode<Integer> node32;
        TreeNode<Integer> node42;
        TreeNode<Integer> node52;

@Before
public void before() throws Exception {

       root = new TreeNode<Integer>(1);
       node2 = new TreeNode<Integer>(2);
       node3 = new TreeNode<Integer>(3);
       node4 = new TreeNode<Integer>(4);
       node5 = new TreeNode<Integer>(5);

       root.left = node2;
       root.right = node3;
       node2.left = node4;
       node4.left = node5;

       root2 = new TreeNode<Integer>(1);
       node22 = new TreeNode<Integer>(2);
       node32 = new TreeNode<Integer>(3);
       node42 = new TreeNode<Integer>(4);
       node52 = new TreeNode<Integer>(5);

       root2.left = node22;
       root2.right = node32;
       node22.left = node42;
       node42.left = node52;
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 
/**
*
* Method: testPreorder(TreeNode root)
*
*/
@Test
public void testPreorder() throws Exception {
    System.out.println("testPreorder");
    TreeNode.preorder(root);
}
/**
*
* Method: testIsSameTree
*
*/
@Test
public void testIsSameTree() throws Exception {
    System.out.println("testIsSameTree");
    assertEquals(TreeNode.isSameTree(root, root2), true);
    node52.val = 6;
    assertEquals(TreeNode.isSameTree(root, root2), false);

}

    /**
* 
* Method: maxDepth(TreeNode root) 
* 
*/ 
@Test
public void testMaxDepth() throws Exception {
    System.out.println("testMaxDepth");
    root.left = node2;
    root.right = node3;
    node2.left = node4;
    node4.left = node5;
    assertEquals(TreeNode.maxDepth(root) , 4);
} 


} 
