package org.doo.leetcode.max_subarray_k;

public class SolutionAlex {
    public int maxSubarraySumCircular(int[] A) {
        int kad = kadane(A);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            A[i] *= -1;
        }
        int iKad = kadane(A);

        return (sum + iKad) != 0 ? Math.max(kad, sum + iKad) : kad;
    }

    private int kadane(int[] A) {
        int localBest = A[0];
        int best = localBest;
        for (int i = 1; i < A.length; i++) {
            localBest = Math.max(A[i], A[i] + localBest);
            best = Math.max(localBest, best);
        }
        return best;
    }
}
