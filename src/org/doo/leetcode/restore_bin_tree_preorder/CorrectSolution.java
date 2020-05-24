package org.doo.leetcode.restore_bin_tree_preorder;


class CorrectSolution {

    public static void main(String[] args) {
        System.out.println(new CorrectSolution().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
//        System.out.println(new CorrectSolution().bstFromPreorder(new int[]{2, 1, 3, 4}));
//        System.out.println(new CorrectSolution().bstFromPreorder(new int[]{4, 5, 14, 20}));
//        System.out.println(new CorrectSolution().bstFromPreorder(new int[]{19,4,8,11}));
//        System.out.println(new CorrectSolution().bstFromPreorder(new int[]{4, 2}));
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = insert(preorder, 0, preorder.length);
        return root;
    }

    public TreeNode insert(int[] preorder, int from, int to) {
        if (from < to) {
            TreeNode node = new TreeNode(preorder[from]);
            int right = from + 1;
            while (right < to && preorder[right] < node.val) right++;

            node.left = insert(preorder, from + 1, right);
            node.right = insert(preorder, right, to);
            return node;
        } else {
            return null;
        }
    }
}