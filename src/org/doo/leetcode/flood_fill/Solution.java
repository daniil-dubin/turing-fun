package org.doo.leetcode.flood_fill;

class Solution {

    public static void main(String[] args) {
        new Solution().floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 1);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }

        int n = image.length;
        int m = image[0].length;

        int[] bi = new int[n * m];
        int[] bj = new int[n * m];

        int[] _bi = new int[n * m];
        int[] _bj = new int[n * m];

        int bn = 1;
        bi[0] = sr;
        bj[0] = sc;
        int color = image[sr][sc];

        int _bn;


        do {
            _bn = 0;

            for (int k = 0; k < bn; k++) {
                image[bi[k]][bj[k]] = newColor;

                if (bi[k] - 1 >= 0 && image[bi[k] - 1][bj[k]] == color) {
                    _bi[_bn] = bi[k] - 1;
                    _bj[_bn] = bj[k];
                    _bn++;
                }

                if (bi[k] + 1 < n && image[bi[k] + 1][bj[k]] == color) {
                    _bi[_bn] = bi[k] + 1;
                    _bj[_bn] = bj[k];
                    _bn++;
                }

                if (bj[k] - 1 >= 0 && image[bi[k]][bj[k] - 1] == color) {
                    _bi[_bn] = bi[k];
                    _bj[_bn] = bj[k] - 1;
                    _bn++;
                }

                if (bj[k] + 1 < m && image[bi[k]][bj[k] + 1] == color) {
                    _bi[_bn] = bi[k];
                    _bj[_bn] = bj[k] + 1;
                    _bn++;
                }
            }

            int[] tmp;
            tmp = bi;
            bi = _bi;
            _bi = tmp;

            tmp = bj;
            bj = _bj;
            _bj = tmp;

            bn = _bn;
        } while (bn > 0);

        return image;
    }
}