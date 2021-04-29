package com.algorithm.tree.general;

import com.algorithm.tree.TreeNode;

public class MaxDepth {

    public int maxDepth(final TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
