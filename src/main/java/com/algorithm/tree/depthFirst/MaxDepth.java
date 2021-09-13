package com.algorithm.tree.depthFirst;

import com.algorithm.tree.model.TreeNode;

public class MaxDepth {

    public static int getMaxDepth(final TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }
}
