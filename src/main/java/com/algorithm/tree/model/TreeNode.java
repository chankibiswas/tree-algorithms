package com.algorithm.tree.model;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    private int val;

    public TreeNode(final int val) {
        this.val = val;
    }

    public TreeNode(final int val, final TreeNode left, final TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return val;
    }
}
