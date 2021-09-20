package com.algorithm.tree.depthFirst;

import com.algorithm.tree.model.TreeNode;

/*
Given a non-empty binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the
parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:
Input: [1,2,3]
       1
      / \
     2   3
Output: 6

Example 2:
Input: [-10,9,20,null,null,15,7]
   -10
   / \
  9  20
    /  \
   15   7
Output: 42
 */
public class MaximumPathSum {

    private int result = Integer.MIN_VALUE;

    public static void main(String[] s) {
        TreeNode t1 = new TreeNode(-10);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        MaximumPathSum m1 = new MaximumPathSum();
        m1.calculateMaximumPathSum(t1);
        System.out.println(m1.result);

        MaximumPathSum m2 = new MaximumPathSum();
        m2.calculateMaximumPathSumFromLeafToLeaf(t1);
        System.out.println(m2.result);
    }

    public int calculateMaximumPathSum(TreeNode t) {
        if (t == null) {
            return 0;
        }
        int left = Math.max(calculateMaximumPathSum(t.left), 0);
        int right = Math.max(calculateMaximumPathSum(t.right), 0);
        result = Math.max(result, t.val + left + right);
        return Math.max(left, right) + t.val;
    }

    /*
    Here calculations need to be from leaf to leaf.
     */
    public int calculateMaximumPathSumFromLeafToLeaf(TreeNode t) {
        if (t == null) {
            return 0;
        }
        int left = calculateMaximumPathSumFromLeafToLeaf(t.left);
        int right = calculateMaximumPathSumFromLeafToLeaf(t.right);
        result = Math.max(result, t.val + left + right);
        return Math.max(left, right) + t.val;
    }
}
