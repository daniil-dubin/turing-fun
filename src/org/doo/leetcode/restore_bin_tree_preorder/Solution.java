package org.doo.leetcode.restore_bin_tree_preorder;


class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
//        System.out.println(new Solution().bstFromPreorder(new int[]{2, 1, 3, 4}));
//        System.out.println(new Solution().bstFromPreorder(new int[]{4, 5, 14, 20}));
        System.out.println(new Solution().bstFromPreorder(new int[]{19,4,8,11}));
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        insert(root, preorder, 1, Integer.MAX_VALUE, true);
        return root;
    }

    public int insert(TreeNode node, int[] preorder, int index, int parent, boolean rightMost) {

        if (index < preorder.length) {
            int val = preorder[index];
            if (val < node.val) {
                node.left = new TreeNode(val);
                index = insert(node.left, preorder, index + 1, node.val, false);
            }
        }

        if (index < preorder.length) {
            int val = preorder[index];

            if (val < parent || rightMost) {
                node.right = new TreeNode(val);
                index = insert(node.right, preorder, index + 1, node.val, rightMost);
            }
        }

        return index;
    }
}