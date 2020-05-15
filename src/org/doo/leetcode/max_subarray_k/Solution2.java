package org.doo.leetcode.max_subarray_k;

public class Solution2 {
    public static void main(String[] args) {
//        System.out.println(new Solution().maxSubarraySumCircular(new int[]{1, -2, 3, -2})); //3
        System.out.println(new Solution2().maxSubarraySumCircular(new int[]{5, -3, 5})); //10
//        System.out.println(new Solution().maxSubarraySumCircular(new int[]{3, -1, 2, -1})); //4
//        System.out.println(new Solution().maxSubarraySumCircular(new int[]{3, 1, 3, 2, 6})); //15
    }

    public int maxSubarray(int[] a, int limit) {
        int sum[] = new int[a.length];
        sum[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            sum[i] = sum[i - 1] + a[i];
        }

        int max = a[0];

        int i = 0;
        do {
            int[] sub = maxSubarray0(a, i, limit);

            int current_max = sub[0];
            int sub_start = sub[1];
            int sub_end = sub[2];

            if (sub_end - sub_start == limit) {

            }

            for (int j = 0; j < limit; j++) {

            }

        } while (true);
    }

    public int[] maxSubarray0(int[] a, int offset, int limit) {
        int max = a[offset];
        int max_start = offset;
        int max_end = offset;

        int max_current = max;

        int start = offset;

        for (int i = offset + 1; i < a.length && i - start < limit; i++) {
            if (a[i] > max_current + a[i]) {
                start = i;
                max_current = a[i];
            } else {
                max_current = max_current + a[i];
            }

            if (max_current > max) {
                max = max_current;
                max_start = start;
                max_end = i;
            }
        }

        return new int[] {max, max_start, max_end};
    }

    public int maxSubarraySumCircular(int[] A) {
        int[] a = new int[A.length * 2 - 1];
        System.arraycopy(A, 0, a, 0, A.length);
        System.arraycopy(A, 0, a, A.length, A.length - 1);

        return maxSubarray(a, A.length);
    }
}
