package com.algorithm.tree.bst;

import com.algorithm.tree.model.TreeNode;

public class LowestCommonAncestorOfBST {

    public static void main(String[] s) {
        Integer[] nodes = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        TreeNode root = BinarySearchTree.createBST(nodes);
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

}
