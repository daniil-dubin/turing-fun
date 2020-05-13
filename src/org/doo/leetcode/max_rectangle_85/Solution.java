package org.doo.leetcode.max_rectangle_85;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().maximalRectangle(new char[][] {
                {0, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 1},
        }));
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;

        int[] border_i = new int[m];
        int[] border_j = new int[n];

        char[][][] corner = new char[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    border_i[i] = j;
                    border_j[j] = i;


                } else {
                    //up
                    char ci_up = corner[i - 1][j][0];
                    char cj_up = corner[i - 1][j][1];

                    char ci_left = corner[i][j - 1][0];
                    char cj_left = corner[i][j - 1][1];


                }
            }
        }

        return max;
    }

}
