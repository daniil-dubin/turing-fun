package org.doo.leetcode.first_bad;

public class Solution {

    private final int bad;

    public Solution(int bad) {
        this.bad = bad;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution(4).firstBadVersion(5));
//        System.out.println(new Solution(2).firstBadVersion(2));

        int n = 1000;
        for (int i = 1; i <= n; i++) {
//            System.out.println();
            if (new Solution(i).firstBadVersion(n) != i) {
                System.out.println("failed " + i);
            }
        }
    }

    public int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }

    public int firstBadVersion(int i, int j) {
        if (i == j) {
            return i;
        } else {
            int mid = (j - i) / 2 + i;

            if (isBadVersion(mid)) {
                return firstBadVersion(i, mid);
            } else {
                return firstBadVersion(mid + 1, j);
            }
        }
    }


//    public int firstBadVersion(int n) {
//        int s = 1;
//        for (int e = n; s <= e; ) {
//            int mid = e + (s - e) / 2;
//            if (isBadVersion(mid)) {
//                e = mid - 1;
//            } else {
//                s = mid + 1;
//            }
//        }
//        return s;
//    }

    boolean isBadVersion(int version) {
        return version >= bad;
    }

}