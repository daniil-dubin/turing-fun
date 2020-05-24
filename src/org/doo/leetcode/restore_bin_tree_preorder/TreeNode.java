package org.doo.leetcode.restore_bin_tree_preorder;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
//        return left + ", " + val + ", " + right;
        return "{" + val + "}";
    }
}
