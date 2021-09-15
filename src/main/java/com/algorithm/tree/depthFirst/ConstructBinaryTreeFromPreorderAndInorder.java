package com.algorithm.tree.depthFirst;

import com.algorithm.tree.model.TreeNode;
import com.algorithm.tree.utils.TreeNodeUtils;

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the
inorder traversal of the same tree, construct and return the binary tree.
*
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
 */
public class ConstructBinaryTreeFromPreorderAndInorder {

    public static void main(String[] s) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        TreeNodeUtils.printLevelOrder(treeNode);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return treeFromPreAndInOrder(preorder, 0, inorder, 0, inorder.length - 1);
    }

    /*
    Algo:
    1. First element of Pre-order is always root node.
    2. Find the root index in in-order array.
    3. Root's left and right sub-tree are calculated recursively.
        a. For left sub-tree, we increment preStart by 1 as root is at 1st index
        b. For right sub-tree, we increment preStart by (rootIndex - inStart + 1) to separate out left sub-tree
     */
    private static TreeNode treeFromPreAndInOrder(final int[] preOrder, final int preStart,
                                                  final int[] inOrder, final int inStart,
                                                  final int inEnd) {
        if (preStart > preOrder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);

        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == preOrder[preStart]) {
                rootIndex = i;
            }
        }
        root.left = treeFromPreAndInOrder(preOrder, preStart + 1, inOrder, inStart, rootIndex - 1);
        root.right = treeFromPreAndInOrder(preOrder, preStart + rootIndex - inStart + 1, inOrder, rootIndex + 1, inEnd);
        return root;
    }
}
