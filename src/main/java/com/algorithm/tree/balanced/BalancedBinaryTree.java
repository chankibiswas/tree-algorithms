package com.algorithm.tree.balanced;

import com.algorithm.tree.depthFirst.MaxDepth;
import com.algorithm.tree.model.TreeNode;

public class BalancedBinaryTree {

    public boolean isBalancedBinaryTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        final int i = MaxDepth.getMaxDepth(root.left) - MaxDepth.getMaxDepth(root.right);
        if (i > 1 || i < -1) {
            return false;
        }
        return isBalancedBinaryTree(root.left) && isBalancedBinaryTree(root.right);
    }
}
