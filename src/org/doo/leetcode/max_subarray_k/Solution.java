package org.doo.leetcode.max_subarray_k;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(new Solution().maxSubarraySumCircular(new int[]{1, -2, 3, -2})); //3
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{5, -3, 5})); //10
//        System.out.println(new Solution().maxSubarraySumCircular(new int[]{3, -1, 2, -1})); //4
//        System.out.println(new Solution().maxSubarraySumCircular(new int[]{3, 1, 3, 2, 6})); //15
    }

    public int maxSubarray(int[] a, int limit) {
        int max = a[0];
        int max_current = max;

        int start = 0;

        for (int i = 1; i < a.length; i++) {
            if (i - start == limit - 1) { // i - start == limit - 1 is more correct
                max_current -= a[start];
                start++;
            }

            if (a[i] > max_current + a[i]) {
                start = i;
                max_current = a[i];
            } else {
                max_current = max_current + a[i];
            }

            if (max_current > max) {
                max = max_current;
            }
        }

        return max;
    }

    public int maxSubarraySumCircular(int[] A) {
        int[] a = new int[A.length * 2 - 1];
        System.arraycopy(A, 0, a, 0, A.length);
        System.arraycopy(A, 0, a, A.length, A.length - 1);

        return maxSubarray(a, A.length);
    }
}
