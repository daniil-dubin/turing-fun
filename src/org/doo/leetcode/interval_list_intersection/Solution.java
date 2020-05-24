package org.doo.leetcode.interval_list_intersection;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        int i = 0;
        int j = 0;

        List<int[]> res = new ArrayList<>(a.length + b.length);

        while (i < a.length && j < b.length) {
            int a0 = a[i][0];
            int a1 = a[i][1];
            int b0 = b[j][0];
            int b1 = b[j][1];

            if (a0 <= b0) {
                if (a1 >= b0) {
                    if (a1 <= b1) {
                        res.add(new int[]{b0, a1});
                        i++;
                    } else {
                        res.add(new int[]{b0, b1});
                        j++;
                    }
                } else {
                    //no intersection; b > a
                    i++;
                }
            } else {
                if (a0 <= b1) {
                    if (a1 <= b1) {
                        res.add(new int[]{a0, a1});
                        i++;
                    } else {
                        res.add(new int[]{a0, b1});
                        j++;
                    }
                } else {
                    //no intersection; a < b
                    j++;
                }
            }
        }

        int[][] out = new int[res.size()][2];
        res.toArray(out);

        return out;
    }
}