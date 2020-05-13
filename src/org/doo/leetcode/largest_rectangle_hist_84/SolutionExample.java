package org.doo.leetcode.largest_rectangle_hist_84;

public class SolutionExample {

    public int largestRectangleArea(int[] heights) {

        if (heights.length == 0) return 0;

        int largestArea = Integer.MIN_VALUE;

        int n = heights.length;

        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        leftMin[0] = 0;

        for (int i = 1; i < n; i++) {

            leftMin[i] = i;

            int j = i;

            while ((leftMin[j] - 1 >= 0) && (heights[leftMin[j] - 1] >= heights[i])) {
                j = leftMin[j] - 1;
            }

            leftMin[i] = leftMin[j];
        }

        rightMin[n - 1] = n - 1;

        for (int i = n - 2; i >= 0; i--) {

            rightMin[i] = i;

            int j = i;

            while ((rightMin[j] + 1 <= n - 1) && (heights[rightMin[j] + 1] >= heights[i])) {
                j = rightMin[j] + 1;
            }

            rightMin[i] = rightMin[j];
        }


        for (int i = 0; i < n; i++) {

            int area = heights[i] * (rightMin[i] - leftMin[i] + 1);

            largestArea = Math.max(largestArea, area);
        }
        return largestArea;
    }
}