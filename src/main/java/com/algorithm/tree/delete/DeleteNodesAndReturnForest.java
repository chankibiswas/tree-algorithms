package com.algorithm.tree.delete;

import com.algorithm.tree.model.TreeNode;
import com.algorithm.tree.utils.TreeNodeUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given the root of a binary tree, each node in the tree has a distinct value.
After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
Return the roots of the trees in the remaining forest. You may return the result in any order.
*
Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
*
Input: root = [1,2,4,null,3], to_delete = [3]
Output: [[1,2,4]]
 */
public class DeleteNodesAndReturnForest {

    public static void main(String[] s) {
        Integer[] nums = {1, 2, 3, null, null, null, 4};
        TreeNode root = TreeNodeUtils.buildBinaryTree(nums);
        int[] toDelete = {2, 1};
        List<TreeNode> result = deleteNodes(root, toDelete);
    }

    public static List<TreeNode> deleteNodes(TreeNode root, int[] toDelete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> itemsToDelete = new HashSet<>();
        for (int i : toDelete) {
            itemsToDelete.add(i);
        }
        root = deleteNodes(root, itemsToDelete, result);
        if (root != null && !itemsToDelete.contains(root.getValue())) {
            result.add(root);
        }
        return result;
    }

    private static TreeNode deleteNodes(final TreeNode root, final Set<Integer> itemsToDelete, final List<TreeNode> result) {
        if (root == null) {
            return null;
        }
        root.left = deleteNodes(root.left, itemsToDelete, result);
        root.right = deleteNodes(root.right, itemsToDelete, result);
        if (root != null && itemsToDelete.contains(root.getValue())) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        }
        return root;
    }
}
