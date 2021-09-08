package com.algorithm.tree.general;

import com.algorithm.tree.TreeNode;
import com.algorithm.tree.TreeNodeUtils;

public class InvertBinaryTree {

    public static void main(String[] s) {
        InvertBinaryTree ibt = new InvertBinaryTree();
        Integer[] t1 = {1, 2, 3, 4, 5, 6, null, null, null, 7, 8};
        TreeNode root1 = TreeNodeUtils.buildBinaryTree(t1, null, 0);
        ibt.invertTree(root1);
        TreeNodeUtils.printInorder(root1);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
