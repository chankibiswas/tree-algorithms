package com.algorithm.tree.bst;

import com.algorithm.tree.model.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

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
        bst.printNodesWithBFS(root);
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

    public void printNodesWithBFS(TreeNode root) {
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
            System.out.println(front.getValue());
        }
    }
}
