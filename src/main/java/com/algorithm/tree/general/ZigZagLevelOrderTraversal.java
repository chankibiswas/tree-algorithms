package com.algorithm.tree.general;

import com.algorithm.tree.TreeNode;
import java.util.Stack;

public class ZigZagLevelOrderTraversal {

    public static void main(String[] s) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.right = t8;

        ZigZagLevelOrderTraversal z = new ZigZagLevelOrderTraversal();
        z.printZigZagLevelOrderTraversal(t1);
    }

    private void printZigZagLevelOrderTraversal(final TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> currentStack = new Stack<TreeNode>();
        Stack<TreeNode> nextStack = new Stack<TreeNode>();

        boolean leftToRightFlag = true;
        currentStack.push(root);

        while (!currentStack.isEmpty()) {
            TreeNode current = currentStack.pop();
            System.out.println(current.getValue());

            if (leftToRightFlag) {
                if (current.left != null) {
                    nextStack.push(current.left);
                }
                if (current.right != null) {
                    nextStack.push(current.right);
                }
            } else {
                if (current.right != null) {
                    nextStack.push(current.right);
                }
                if (current.left != null) {
                    nextStack.push(current.left);
                }
            }
            if (currentStack.isEmpty()) {
                leftToRightFlag = !leftToRightFlag;
                Stack<TreeNode> temp = nextStack;
                nextStack = currentStack;
                currentStack = temp;

            }
        }
    }
}
