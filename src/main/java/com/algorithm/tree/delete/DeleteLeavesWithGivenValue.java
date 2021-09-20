package com.algorithm.tree.delete;

import com.algorithm.tree.model.TreeNode;
import com.algorithm.tree.utils.TreeNodeUtils;

/*
Given a binary tree root and an integer target, delete all the leaf nodes with value target.
*
Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target,
it should also be deleted (you need to continue doing that until you can't).
*
Input: root = [1,2,3,2,null,2,4], target = 2
Output: [1,null,3,null,4]
Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left).
After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
 */
public class DeleteLeavesWithGivenValue {

    public static void main(String[] s) {
        Integer[] n1 = {1, 2, 3, 2, null, 2, 4};
        TreeNode p = TreeNodeUtils.buildBinaryTree(n1);

        TreeNode treeNode = removeLeafNodes(p, 2);
        TreeNodeUtils.printInorder(treeNode);
    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);
        if (left == null && right == null && root.val == target) {
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
