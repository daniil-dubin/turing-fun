package org.doo.leetcode.kth_bst;

class Solution {

    int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        int res = -1;

        if (root.left != null) {
            res = kthSmallest(root.left, k);
        }

        if (res == -1 && ++index == k) {
            res = root.val;
        }

        if (res == -1 && root.right != null) {
            res = kthSmallest(root.right, k);
        }

        return res;
    }
}