package org.doo.leetcode.edit_distance;

class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().minDistance("trinitrophenylmethylnitramine", "dinitrophenylhydrazine"));
        System.out.println(new Solution().minDistance("kitten", "sitting"));
    }

    public int minDistance(String word1, String word2) {
        return minDistance(word1, 0, word1.length(), word2, 0, word2.length());
    }

    private int minDistance(String word1, int from1, int to1, String word2, int from2, int to2) {
        int min = Integer.MAX_VALUE;

        for (int i = from1; i < to1; i++) {
            for (int j = from2; j < to2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    min = Math.min(min,
                            minDistance(word1, from1, i, word2, from2, j)
                                    + minDistance(word1, i + 1, to1, word2, j + 1, to2)
                    );
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            return Math.max(to1 - from1, to2 - from2);
        } else {
            return min;
        }
    }

    public int minDistanceFast(String str1, String str2) {
        int[][] memo = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) {
                    memo[i][j] = j;
                } else if (j == 0) {
                    memo[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.min(1 + memo[i][j - 1],
                            Math.min(1 + memo[i - 1][j],
                                    1 + memo[i - 1][j - 1]));
                }
            }
        }

        return memo[str1.length()][str2.length()];
    }
}