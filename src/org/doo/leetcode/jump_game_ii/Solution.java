package org.doo.leetcode.jump_game_ii;

class Solution {
    public int jump(int[] nums) {
        int[] jumps = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int k = 0, j = i + 1; k < nums[i] && j < nums.length; k++, j++) {
                if (jumps[j] == 0 || jumps[j] > jumps[i] + 1) {
                    jumps[j] = jumps[i] + 1;
                }
            }
        }

        return jumps[jumps.length - 1];
    }
}