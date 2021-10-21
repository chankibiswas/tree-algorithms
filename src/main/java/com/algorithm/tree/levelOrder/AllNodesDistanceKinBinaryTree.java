package com.algorithm.tree.levelOrder;

import com.algorithm.tree.model.TreeNode;
import com.algorithm.tree.utils.TreeNodeUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all
 nodes that have a distance k from the target node.

You can return the answer in any order.
*
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
*
Input: root = [1], target = 1, k = 3
Output: []
 */
public class AllNodesDistanceKinBinaryTree {

    public static void main(String[] s) {
        Integer[] node = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode treeNode = TreeNodeUtils.buildBinaryTree(node);
        TreeNode target = treeNode.left;
        List<Integer> result = new AllNodesDistanceKinBinaryTree().distanceK(treeNode, target, 2);
        System.out.println("r");
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        int level = 0;

        Set<Integer> visited = new HashSet<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(target);
        if (k == 0) {
            return getListFromQueueNodes(q);
        }
        Map<Integer, TreeNode> parentMap = getParentMap(root, new HashMap<>());
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.removeFirst();
                if (current.left != null && !visited.contains(current.left.val)) {
                    q.addLast(current.left);
                }
                if (current.right != null && !visited.contains(current.right.val)) {
                    q.addLast(current.right);
                }
                if (parentMap.containsKey(current.val)) {
                    TreeNode parent = parentMap.get(current.val);
                    if (!visited.contains(parent.val)) {
                        q.addLast(parentMap.get(current.val));
                    }
                }
                visited.add(current.val);
            }
            level++;
            if (level == k) {
                return getListFromQueueNodes(q);
            }
        }
        return result;
    }

    private List<Integer> getListFromQueueNodes(LinkedList<TreeNode> q) {
        List<Integer> result = new ArrayList<>();
        for (TreeNode n : q) {
            result.add(n.val);
        }
        return result;
    }

    private Map<Integer, TreeNode> getParentMap(TreeNode root, Map<Integer, TreeNode> parentMap) {
        if (root == null) {
            return parentMap;
        }
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            getParentMap(root.left, parentMap);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            getParentMap(root.right, parentMap);
        }
        return parentMap;
    }
}
