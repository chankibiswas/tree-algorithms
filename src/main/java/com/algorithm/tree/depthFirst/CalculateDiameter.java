package com.algorithm.tree.depthFirst;

import com.algorithm.tree.model.TreeNode;

public class CalculateDiameter {

    private int result = 0;

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
        t2.right = t4;
        t3.left = t5;
        t3.right = t6;
        t5.left = t7;
        t5.right = t8;

        CalculateDiameter c = new CalculateDiameter();
        c.getDiameter(t1);
        System.out.println(c.result);
    }

    private int getDiameter(final TreeNode t) {
        if (t == null) {
            return 0;
        }
        calculateHeightOfBinaryTree(t);
        return result;
    }

    private int calculateHeightOfBinaryTree(final TreeNode t) {
        if (t == null) {
            return 0;
        }
        int leftHeight = calculateHeightOfBinaryTree(t.left);
        int rightHeight = calculateHeightOfBinaryTree(t.right);

        // Temp is value when that particular node is not taken as root for this calculation. This is one option.
        int temp = 1 + Math.max(leftHeight, rightHeight);
        // Ans is value when that particular node is taken as root for this calculation. This is another option.
        int ans = Math.max(temp, 1 + leftHeight + rightHeight);
        // We choose max among the above 2 options
        result = Math.max(result, ans);

        return temp;
    }

}
