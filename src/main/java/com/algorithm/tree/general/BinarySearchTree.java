package com.algorithm.tree.general;

import com.algorithm.tree.TreeNode;

public class BinarySearchTree {

    public static void main(String[] s) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = new TreeNode(10);
        bst.insertNodeInBinarySearchTree(root, 3);
        bst.insertNodeInBinarySearchTree(root, 5);
        bst.insertNodeInBinarySearchTree(root, 18);
        bst.insertNodeInBinarySearchTree(root, 11);
        bst.insertNodeInBinarySearchTree(root, 12);
        bst.insertNodeInBinarySearchTree(root, 13);

        bst.printInorderForBST(root);
    }

    public void insertNodeInBinarySearchTree(TreeNode root, int newValue) {
        if (root == null) {
            return;
        }
        if (root.getValue() > newValue) {
            if (root.left == null) {
                TreeNode t = new TreeNode(newValue, null, null);
                root.left = t;
            } else {
                insertNodeInBinarySearchTree(root.left, newValue);
            }
        } else {
            if (root.right == null) {
                TreeNode t = new TreeNode(newValue, null, null);
                root.right = t;
            } else {
                insertNodeInBinarySearchTree(root.right, newValue);
            }
        }
    }

    public void printInorderForBST(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorderForBST(root.left);
        System.out.println(root.getValue());
        printInorderForBST(root.right);
    }
}
