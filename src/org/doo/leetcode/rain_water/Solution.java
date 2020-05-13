package org.doo.leetcode.rain_water;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); //6
    }

    public int trap(int[] heights) {
        TreeMap<Integer, Integer> leftBound = new TreeMap<>();

        int sum = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];

            int prev = 0;
            Iterator<Map.Entry<Integer, Integer>> iter = leftBound.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Integer, Integer> bound = iter.next();

                if (bound.getKey() <= height) {
                    sum += (bound.getKey() - prev) * (i - bound.getValue() - 1);
                    iter.remove();
                } else {
                    sum += (height - prev) * (i - bound.getValue() - 1);
                    break;
                }

                prev = bound.getKey();
            }

            leftBound.put(height, i);
        }

        return sum;
    }
}
