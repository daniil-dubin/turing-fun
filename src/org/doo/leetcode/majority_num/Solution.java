package org.doo.leetcode.majority_num;

import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = count.computeIfAbsent(nums[i], k -> 0);
            if (current + 1 > nums.length / 2) {
                return nums[i];
            }
            count.put(nums[i], current + 1);
        }

        return -1;
    }
}