package org.doo.leetcode.rain_water;

public class Example {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int right[] = new int[n];
        int left[] = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            if (height[i] > left[i - 1]) {
                left[i] = height[i];
            } else {
                left[i] = left[i - 1];
            }
        }
        for (int j = n - 2; j >= 0; j--) {
            if (height[j] > right[j + 1]) {
                right[j] = height[j];
            } else {
                right[j] = right[j + 1];
            }
        }
        int water = 0;
        for (int k = 0; k < n; k++) {
            water = water + Math.min(left[k], right[k]) - height[k];
        }
        return water;
    }
}
