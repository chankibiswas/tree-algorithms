package com.algorithm.tree.general;

import com.algorithm.tree.model.TreeNode;
import com.algorithm.tree.utils.TreeNodeUtils;

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the
lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
*
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
*
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
*
Input: root = [1,2], p = 1, q = 2
Output: 1
 */
public class LowestCommonAncestorOfBinaryTree {

    private static TreeNode result = null;

    public static void main(String[] s) {
        Integer[] i = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = TreeNodeUtils.buildBinaryTree(i);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode node = lowestCommonAncestor(root, p, q);
        System.out.println(node.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    private static boolean dfs(final TreeNode root, final TreeNode p, final TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        boolean current = (root.val == p.val) || (root.val == q.val);
        if ((left && current) || (left && right) || (right && current)) {
            result = root;
        }
        return left || right || current;
    }

}
