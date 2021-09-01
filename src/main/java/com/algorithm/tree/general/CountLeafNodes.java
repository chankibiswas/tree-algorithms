package com.algorithm.tree.general;

import com.algorithm.tree.TreeNode;

/*
Count the number of leaf nodes in Binary tree
 */
public class CountLeafNodes {

    public static void main(String[] s) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        t3.left = t5;
        t3.right = t6;
        t5.left = t7;
        t5.right = t8;

        CountLeafNodes c = new CountLeafNodes();
        System.out.println(c.countLeafNode(t1));
    }

    public int countLeafNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            return countLeafNode(root.left) + countLeafNode(root.right);
        }
    }
}
