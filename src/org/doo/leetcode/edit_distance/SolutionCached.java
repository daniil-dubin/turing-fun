package org.doo.leetcode.edit_distance;

class SolutionCached {

    public static void main(String[] args) {
        System.out.println(new SolutionCached().minDistance("trinitrophenylmethylnitramine", "dinitrophenylhydrazine"));
    }

    int[][][][] cache;

    public int minDistance(String word1, String word2) {
        cache = new int[word1.length()][word1.length()][word2.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word1.length(); j++) {
                for (int k = 0; k < word2.length(); k++) {
                    for (int l = 0; l < word2.length(); l++) {
                        cache[i][j][k][l] = -1;
                    }
                }
            }
        }

        return minDistance(word1, 0, word1.length(), word2, 0, word2.length());
    }

    private int minDistance(String word1, int from1, int to1, String word2, int from2, int to2) {
        int cached = cache[from1][to1][from2][to2];
        if (cached != -1) {
            return cached;
        }

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
            min = Math.max(to1 - from1, to2 - from2);
        }

        cache[from1][to1][from2][to2] = min;
        return min;
    }
}