package org.doo.leetcode.sount_square_matrix;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countSquares(new int[][]{
                {0, 1},
                {1, 1}
        }));
    }

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int max = Math.min(m - i, n - j);

                boolean success = true;

                for (int k = 0; k < max && success; k++) {
                    success = true;

                    for (int l = 0; l <= k; l++) {
                        if (matrix[i + k][j + l] == 0 || matrix[i + l][j + k] == 0) {
                            success = false;
                            break;
                        }
                    }

                    if (success) {
                        count++;
                    }
                }

            }
        }

        return count;
    }

    public int countSquaresDP(int[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int r = matrix.length;
        int c = matrix[0].length;

        int[][] dp = new int[r][c];
        int sum = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;

                    else
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;

                    sum += dp[i][j];
                }
            }
        }

        return sum;
    }
}
