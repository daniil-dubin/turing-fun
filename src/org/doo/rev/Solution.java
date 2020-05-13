package org.doo.rev;

class Solution {

    public static void main(String[] args) {
//        int[] prices = new int[]{3, 2, 6, 5, 0, 3};

//        int[] prices = new int[]{1,2,4,2,5,7,2,4,9,0,9};
//        int k = 4;

//        int[] prices = new int[]{8, 6, 4, 3, 3, 2, 3, 5, 8, 3, 8, 2, 6};
//        int k = 3;

        int[] prices = new int[]{2, 6, 8, 7, 8, 7, 9, 4, 1, 2, 4, 5, 8};
        int k = 3;

        int profit = new Solution().maxProfit(k, prices);
        System.out.println("profit = " + profit);
    }


    public int maxProfit(int k, int[] prices) {
        return maxProfit(prices, 0, k, new Integer[prices.length + 1]);
    }

    private int maxProfit(int[] prices, int offset, int transactionsLeft, Integer[] cache) {
        if (transactionsLeft > 0) {
//            Integer computed = cache[offset];
//            if (computed != null) {
//                return computed;
//            }

            int max = 0;

            int ms = -1, me = -1;

            for (int end = offset + 1; end < prices.length; end++) {
                for (int start = offset; start < end; start++) {

                    int _ms, _me;

                    int headProfit = prices[end] - prices[start];
                    int total;
                    if (headProfit > 0) {
                        int tailProfit = maxProfit(prices, end + 1, transactionsLeft - 1, cache);
                        total = headProfit + tailProfit;
                        _ms = start; _me = end;
                    } else {
                        total = maxProfit(prices, end + 1, transactionsLeft, cache);
                        _ms = _me = -1;
                    }

                    if (total > max) {
                        max = total;
                        ms = _ms; me = _me;
                    }
                }
            }

            cache[offset] = max;

            System.out.println(offset + "[" + ms + ", " + me + "]");

            return max;
        } else {
            return 0;
        }
    }
}