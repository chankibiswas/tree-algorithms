package com.algorithm.tree.depthFirst;

import com.algorithm.tree.model.TreeNode;
import com.algorithm.tree.utils.TreeNodeUtils;

/*
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure
and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree
tree could also be considered as a subtree of itself.
*
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
*
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 */
public class SubTreeOfAnotherTree {

    public static void main(String[] s) {
        Integer[] root = {3, 4, 5, 1, 2};
        Integer[] subRoot = {4, 1, 2};
        TreeNode rootNode = TreeNodeUtils.buildBinaryTree(root);
        TreeNode subRootNode = TreeNodeUtils.buildBinaryTree(subRoot);
        System.out.println(isSubtree(rootNode, subRootNode));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (subRoot == null) {
            return false;
        }
        if (root.getValue() == subRoot.getValue()) {
            return isSameTree(root, subRoot);
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    private static boolean isSameTree(final TreeNode root, final TreeNode subRoot) {
        if ((root == null && subRoot != null) || (root != null && subRoot == null)) {
            return false;
        } else if (root == null && subRoot == null) {
            return true;
        }
        if (root.getValue() == subRoot.getValue()) {
            return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        } else {
            return false;
        }
    }
}
