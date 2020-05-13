package org.doo.leetcode.id;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().diStringMatch("IDID")));
    }

    public int[] diStringMatch(String s) {
        int[][] height = new int[s.length() + 1][2];

        for (int i = 1; i < height.length; i++) {
            height[i][0] = i;
            height[i][1] = height[i - 1][1] + (s.charAt(i - 1) == 'I' ? 1 : -1);
        }

        Arrays.sort(height, (a, b) -> a[1] - b[1]);

        int[] res = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            res[height[i][0]] = i;
        }


        return res;
    }
}
