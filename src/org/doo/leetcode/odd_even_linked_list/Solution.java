package org.doo.leetcode.odd_even_linked_list;

class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + val + '}';
        }
    }

    public static ListNode gen(int len) {
        ListNode head = new ListNode(1);
        ListNode ptr = head;
        for (int i = 2; i <= len; i++) {
            ptr.next = new ListNode(i);
            ptr = ptr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().oddEvenList(gen(5)));
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode src = head;
        ListNode odd = null;
        ListNode even = null;
        ListNode even_head = null;

        int i = 1;

        while (src != null) {
            if (i++ % 2 == 0) {
                if (even == null) {
                    even = src;
                    even_head = even;
                } else {
                    even.next = src;
                    even = src;
                }
            } else {
                if (odd == null) {
                    odd = src;
                } else {
                    odd.next = src;
                    odd = src;
                }
            }

            src = src.next;
        }

        if (even != null) {
            even.next = null;
        }

        if (odd != null) {
            odd.next = even_head;
        }

        return head;
    }
}