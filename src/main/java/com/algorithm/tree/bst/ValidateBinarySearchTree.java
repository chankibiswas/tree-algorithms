package com.algorithm.tree.bst;

import com.algorithm.tree.model.TreeNode;

/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*
Input: root = [2,1,3]
Output: true
*
Input: root = [5,1,4,null,null,3,6]
Output: false
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}
