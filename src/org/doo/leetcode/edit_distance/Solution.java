package org.doo.leetcode.edit_distance;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("trinitrophenylmethylnitramine", "dinitrophenylhydrazine"));
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
}