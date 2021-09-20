package com.algorithm.tree.levelOrder;

import com.algorithm.tree.model.TreeNode;
import com.algorithm.tree.utils.TreeNodeUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {

    public static void main(String[] s) {
        LevelOrderTraversal lot = new LevelOrderTraversal();

        Integer[] arr = {3, 9, 20, null, 15, 7};
        TreeNode root = TreeNodeUtils.buildBinaryTree(arr);
        List<Double> list = lot.averageOfLevels(root);
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
                temp.add(treeNode.val);
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
                temp.add(treeNode.val);
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

    /*
    Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers
    within 10^5 of the actual answer will be accepted.
    *
    Input: root = [3,9,20,null,15,7]
    Output: [3.00000,14.50000,11.00000]
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<Double>();
        }

        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.addLast(root);
        List<Double> result = new ArrayList<Double>();
        while (!q.isEmpty()) {
            double sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = q.removeFirst();
                sum = sum + treeNode.val;
                if (treeNode.left != null) {
                    q.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    q.addLast(treeNode.right);
                }
            }
            result.add(((double)sum) / size);
        }
        return result;
    }
}
