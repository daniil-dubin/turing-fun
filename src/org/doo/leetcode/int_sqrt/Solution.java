package org.doo.leetcode.int_sqrt;

class Solution {

    public static void main(String[] args) {
        for (int i =0; i < 1000000000; i++) {
            int sqrt = ((int) Math.sqrt(i));
            boolean correct = sqrt * sqrt == i;

            if (new Solution().isPerfectSquare(i) != correct) {
                System.out.println("incorrect for " + i);
            }
        }

//        int i = 154449;
//        int sqrt = ((int) Math.sqrt(i));
//        System.out.println(sqrt);
//        System.out.println(sqrt * sqrt);
//        System.out.println(new Solution().isPerfectSquare(i));
    }

    public boolean isPerfectSquare(int num) {
        return isPerfectSquare(0, num, num, 0);
    }

    public boolean isPerfectSquare(int min, int max, int num, int depth) {
        if (depth > 32) {
            return false;
        }

        int mid = (max - min) / 2 + min;

        long sqr = (long) mid * mid;

        if (sqr == num) {
            return true;
        }

        if (sqr > num) {
            return isPerfectSquare(min, mid - 1, num, depth + 1);
        } else {
            return isPerfectSquare(mid + 1, max, num, depth + 1);
        }
    }
}