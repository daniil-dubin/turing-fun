package org.doo.leetcode.largest_rectangle_hist_84;

class SolutionN {
    public static void main(String[] args) {
//        System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//        System.out.println(new SolutionN().largestRectangleArea(new int[]{1, 1}));
//        System.out.println(new SolutionN().largestRectangleArea(new int[]{2, 1, 2}));

        System.out.println(new SolutionN().largestRectangleArea(new int[]{3,5,5,2,5,5,6,6,4,4,1,1,2,5,5,6,6,4,1,3}));
    }

    public int largestRectangleArea(int[] h) {

        int[][] offsets = new int[h.length][2];
        int ptr = 0;

        int max = 0;

        for (int i = 0; i < h.length; i++) {
            int lastOffset = i;

            for (int j = ptr - 1; j >= 0; j--) {
                if (offsets[j][0] > h[i]) {
                    int sqr = (i - offsets[j][1]) * offsets[j][0];

                    if (sqr > max) {
                        max = sqr;
                    }

                    lastOffset = offsets[j][1];

                    ptr--;
                } else {
                    break;
                }
            }

            if (ptr == 0 || offsets[ptr - 1][0] != h[i]) {
                offsets[ptr][0] = h[i];
                offsets[ptr][1] = lastOffset;
                ptr++;
            }
        }

        for (int j = ptr - 1; j >= 0; j--) {
            int sqr = (h.length - offsets[j][1]) * offsets[j][0];

            if (sqr > max) {
                max = sqr;
            }
        }

        return max;
    }
}