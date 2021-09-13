package com.algorithm.tree.general;

import com.algorithm.tree.TreeNode;

/*
Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
*
Input: root = [3,1,4,null,2], k = 1
Output: 1
*
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 */
public class KthSmallestInBST {

    public static void main(String[] st) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = new TreeNode(5);
        bst.insertNodeInBinarySearchTree(root, 3);
        bst.insertNodeInBinarySearchTree(root, 8);
        bst.insertNodeInBinarySearchTree(root, 2);
        bst.insertNodeInBinarySearchTree(root, 4);
        bst.insertNodeInBinarySearchTree(root, 1);
        bst.insertNodeInBinarySearchTree(root, 11);

        System.out.println(kthSmallest(root, 6));
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] result = new int[2];
        traverseBSTInorder(root, k, result);
        return result[1];
    }

    private static void traverseBSTInorder(final TreeNode root, final int k, int[] result) {
        if (root == null) {
            return;
        }
        traverseBSTInorder(root.left, k, result);
        result[0]++;
        if (result[0] == k) {
            result[1] = root.getValue();
            return;
        }
        traverseBSTInorder(root.right, k, result);
    }
}
