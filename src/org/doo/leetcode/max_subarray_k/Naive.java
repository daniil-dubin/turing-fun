package org.doo.leetcode.max_subarray_k;

public class Naive {

    public static void main(String[] args) {
        System.out.println(new Naive().maxSubarraySumCircular(new int[]{1, -2, 3, -2})); //3
        System.out.println(new Naive().maxSubarraySumCircular(new int[]{5, -3, 5})); //10
        System.out.println(new Naive().maxSubarraySumCircular(new int[]{3, -1, 2, -1})); //4
    }

    public int maxSubarray(int[] a, int limit) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            int sum = 0;

            for (int j = 0; j < limit && i + j < a.length; j++) {
                sum += a[i + j];

                if (sum > max) {
                    max = sum;
                }
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
