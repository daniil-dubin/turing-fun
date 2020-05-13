package org.doo.leetcode.complement_int;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findComplement(5));
    }

    public int findComplement(int num) {
        int oneBit = 1;
        int mask = 1, cmask = 1;
        for (int i = 0; i < 32; i++) {
            if ((oneBit & num) != 0) {
                mask = cmask;
            }

            oneBit <<= 1;
            cmask = (cmask << 1) | 1;
        }

        return ~num & mask;
    }
}