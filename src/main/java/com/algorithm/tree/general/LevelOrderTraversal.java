package com.algorithm.tree.general;

import com.algorithm.tree.TreeNode;
import com.algorithm.tree.TreeNodeUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {

    public static void main(String[] s) {
        LevelOrderTraversal lot = new LevelOrderTraversal();

        Integer[] arr = {1, 2, 3, 4, 5};
        TreeNode root = TreeNodeUtils.buildBinaryTree(arr, null, 0);
        List<List<Integer>> res = lot.levelOrder2(root);
        System.out.println("H");
    }

    /*
    Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right,
    level by level).
    *
    Input: root = [3,9,20,null,null,15,7]
    Output: [[3],[9,20],[15,7]]
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.addLast(root);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = q.removeFirst();
                temp.add(treeNode.getValue());
                if (treeNode.left != null) {
                    q.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    q.addLast(treeNode.right);
                }
            }
            result.add(temp);
            temp = new ArrayList<Integer>();
        }
        return result;
    }

    /*
    Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to
    right, level by level from leaf to root).
    *
    Input: root = [3,9,20,null,null,15,7]
    Output: [[15,7],[9,20],[3]]
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.addLast(root);
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = q.removeFirst();
                temp.add(treeNode.getValue());
                if (treeNode.left != null) {
                    q.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    q.addLast(treeNode.right);
                }
            }
            result.addFirst(temp);
            temp = new ArrayList<Integer>();
        }
        return result;
    }
}
