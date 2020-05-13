package org.doo.leetcode.remove_k_digits;

class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().removeKdigits("9", 1));
//        System.out.println(new Solution().removeKdigits("12345", 3));
        System.out.println(new Solution().removeKdigits("112", 1));
    }

    public String removeKdigits(String num, int k) {
        int n = num.length();
        char[] stack = new char[n];

        int top = 0;

        for(int i = 0; i <= n; i++) {
            char ch = i < n ? num.charAt(i) : '0';

            while (k > 0 && top > 0 && stack[top - 1] > ch) {
                k--;
                top--;
            }

            if (i < n && (top > 0 || ch != '0')) {
                stack[top++] = ch;
            }
        }

        return top > 0 ? new String(stack, 0, top) : "0";
    }
}