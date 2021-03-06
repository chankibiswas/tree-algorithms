package com.algorithm.tree.general;

import com.algorithm.tree.model.TreeNode;
import com.algorithm.tree.utils.TreeNodeUtils;

public class InvertBinaryTree {

    public static void main(String[] s) {
        InvertBinaryTree ibt = new InvertBinaryTree();
        Integer[] t1 = {1, 2, 3, 4, 5, 6, null, null, null, 7, 8};
        TreeNode root1 = TreeNodeUtils.buildBinaryTree(t1);
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
