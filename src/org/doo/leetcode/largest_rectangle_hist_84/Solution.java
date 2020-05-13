package org.doo.leetcode.largest_rectangle_hist_84;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public static void main(String[] args) {
//        System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new Solution().largestRectangleArea(new int[]{1, 1}));
        System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 2}));
    }

    public int largestRectangleArea(int[] h) {

        TreeMap<Integer, Integer> offsets = new TreeMap<>();

        int max = 0;

        for (int i = 0; i < h.length; i++) {
            Iterator<Map.Entry<Integer, Integer>> iter = offsets.descendingMap().entrySet().iterator();

            while (iter.hasNext()) {
                Map.Entry<Integer, Integer> entry = iter.next();

                if (entry.getKey() > h[i]) {
                    int sqr = (i - entry.getValue()) * entry.getKey();

                    if (sqr > max) {
                        max = sqr;
                    }

                    iter.remove();
                } else {
                    break;
                }
            }

            offsets.putIfAbsent(h[i], i);
        }

        for (Map.Entry<Integer, Integer> entry : offsets.descendingMap().entrySet()) {
            int sqr = (h.length - entry.getValue()) * entry.getKey();

            if (sqr > max) {
                max = sqr;
            }
        }

        return max;
    }
}