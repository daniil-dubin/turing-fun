package org.doo.leetcode.max_rectangle_85;

public class SolutionBrutForce {

    public static void main(String[] args) {
        System.out.println(new SolutionBrutForce().maximalRectangle(new char[][] {
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

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = i; k < m; k++) {
                    for (int l = j; l < n; l++) {
                        if (isRectangle(matrix, i, j, k, l)) {
                            int sqr = (k - i + 1) * (l - j + 1);

                            if (sqr > max) {
                                max = sqr;
                            }
                        }
                    }
                }
            }
        }

        return max;
    }

    public boolean isRectangle(char[][] matrix, int k, int l, int m, int n) {
        for (int i = k; i <= m; i++) {
            for (int j = l; j <= n; j++) {
                if (matrix[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
