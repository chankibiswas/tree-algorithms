package com.algorithm.tree.general;

import com.algorithm.tree.TreeNode;

public class MaxDepth {

    public static int getMaxDepth(final TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }
}
