package com.algorithm.tree.utils;

import com.algorithm.tree.model.TreeNode;
import java.util.LinkedList;

public final class TreeNodeUtils {

    private TreeNodeUtils() {
    }

    public static TreeNode buildBinaryTree(Integer[] arr, TreeNode root, int i) {
        if (i < arr.length && arr[i] != null) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;
            root.left = buildBinaryTree(arr, root.left, 2 * i + 1);
            root.right = buildBinaryTree(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> q = new LinkedList();
        q.addLast(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.removeFirst();
            System.out.println(temp.getValue());
            if (temp.left != null) {
                q.addLast(temp.left);
            }
            if (temp.right != null) {
                q.addLast(temp.right);
            }
        }
    }

    public static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.println(root.getValue());
        printInorder(root.right);
    }

    public static void printPostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.getValue());
    }

    public static void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getValue());
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}