package org.doo.leetcode.uncrossed_lines;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
//        System.out.println(new Solution().maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(new Solution().maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
    }

    public int maxUncrossedLines(int[] a, int[] b) {
        int[][][] sec = new int[a.length][b.length][3];
        int[] len = new int[a.length];

        int pairsNum = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    int ii = len[i]++;
                    sec[i][ii][0] = i;
                    sec[i][ii][1] = j;
                    pairsNum++;
                }
            }
        }

        int[][] pairs = new int[pairsNum][];

        int index = 0;

        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < len[i]; k++) {
                pairs[index++] = sec[i][k];

                for (int j = 0; j < i; j++) {
                    for (int l = 0; l < len[j]; l++) {
                        if (sec[i][k][1] <= sec[j][l][1]) {
                            sec[i][k][2]++;
                        }
                    }
                }

                for (int j = i + 1; j < a.length; j++) {
                    for (int l = 0; l < len[j]; l++) {
                        if (sec[i][k][1] >= sec[j][l][1]) {
                            sec[i][k][2]++;
                        }
                    }
                }
            }
        }

        Arrays.sort(pairs, (aa, bb) -> aa[2] - bb[2]);

        int max = 0;

        int[][] sec2 = new int[a.length][b.length];
        int[] len2 = new int[a.length];

        out:
        for (int ii = 0; ii < pairs.length; ii++) {
            int ai = pairs[ii][0];

            if (len2[ai] == 0) {
                sec2[ai][len2[ai]++] = pairs[ii][1];

                for (int j = 0; j < ai; j++) {
                    for (int l = 0; l < len2[j]; l++) {
                        if (sec2[ai][0] <= sec2[j][l]) {
                            continue out;
                        }
                    }
                }

                for (int j = ai + 1; j < a.length; j++) {
                    for (int l = 0; l < len2[j]; l++) {
                        if (sec2[ai][0] >= sec2[j][l]) {
                            continue out;
                        }
                    }
                }

                max++;
            }
        }

        return max;
    }

}