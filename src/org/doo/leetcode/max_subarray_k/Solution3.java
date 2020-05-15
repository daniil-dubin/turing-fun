package org.doo.leetcode.max_subarray_k;

import java.util.LinkedList;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{1, -2, 3, -2})); //3
        System.out.println(new Solution3().maxSubarraySumCircular(new int[]{5, -3, 5})); //10
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{3, -1, 2, -1})); //4
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{3, 1, 3, 2, 6})); //15
    }

    public int maxSubarray(int[] a, int k) {
        int sum[] = new int[a.length];
        sum[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            sum[i] = sum[i - 1] + a[i];
        }

//        for (q in len(b))
//             The minimum is too far behind
//            if !deque.empty() && q - deque.front() > k: deque.pop_front()
//        Remove the less optimal positions from the queue.
//        while (!deque.empty() && b[deque.back()] > b[q]) deque.pop_back()
//        deque.push_back(q)
//
//        if (b[q] - b[deque.front()] > best_so_far) UpdateBestSoFar();

        int max = Integer.MIN_VALUE;

        LinkedList<Integer> deque = new LinkedList<>();

        for (int q = 0; q < sum.length; q++) {
            if (!deque.isEmpty() && q - deque.getFirst() > k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && sum[deque.getLast()] > sum[q]) {
                deque.removeLast();
            }

            deque.push(q);

            if (sum[q] - sum[deque.getFirst()] > max) {
                max = sum[q] - sum[deque.getFirst()];
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
