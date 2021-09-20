package com.algorithm.tree.bst;

import com.algorithm.tree.model.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    public static void main(String[] s) {
        TreeNode root = new TreeNode(10);
        insertNodeInBinarySearchTree(root, 3);
        insertNodeInBinarySearchTree(root, 5);
        insertNodeInBinarySearchTree(root, 18);
        insertNodeInBinarySearchTree(root, 11);
        insertNodeInBinarySearchTree(root, 12);
        insertNodeInBinarySearchTree(root, 13);

        printInorderForBST(root);
        printNodesWithBFS(root);
    }

    public static TreeNode createBST(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != null) {
                insertNodeInBinarySearchTree(root, arr[i]);
            }
        }
        return root;
    }

    public static void insertNodeInBinarySearchTree(TreeNode root, int newValue) {
        if (root == null) {
            return;
        }
        if (root.val > newValue) {
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

    public static void printInorderForBST(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorderForBST(root.left);
        System.out.println(root.val);
        printInorderForBST(root.right);
    }

    public static void printNodesWithBFS(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode front = q.remove();
            if (front.left != null) {
                q.add(front.left);
            }
            if (front.right != null) {
                q.add(front.right);
            }
            System.out.println(front.val);
        }
    }
}
