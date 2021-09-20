package com.algorithm.tree.depthFirst;

import com.algorithm.tree.model.TreeNode;
import com.algorithm.tree.utils.TreeNodeUtils;

public class SumOfLeftLeaves {

    private static int result = 0;

    public static void main(String[] s) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNodeUtils.buildBinaryTree(arr);
        System.out.println(sumOfLeftLeaves(treeNode));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getSumOfLeftLeaves(root, false);
        return result;
    }

    private static void getSumOfLeftLeaves(final TreeNode root, final boolean leftFlag) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && leftFlag) {
            result = result + root.val;
        }
        if (root.left != null) {
            getSumOfLeftLeaves(root.left, true);
        }
        if (root.right != null) {
            getSumOfLeftLeaves(root.right, false);
        }
    }
}
