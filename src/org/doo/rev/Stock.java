package org.doo.rev;

public class Stock {

    public static void main(String[] args) {
//        int[] prices = new int[]{3, 2, 6, 5, 0, 3};
        int[] prices = new int[]{2, 4, 1};
        int k = 2;
        int profit = maxProfit(k, prices);
        System.out.println("profit = " + profit);
    }

    static int maxProfit(int k, int[] prices) {
        return maxProfit(prices, 0, k);
    }

    private static int maxProfit(int[] prices, int offset, int transactionsLeft) {
        if (transactionsLeft > 0) {
            int max = 0;

            for (int end = offset + 1; end < prices.length; end++) {
                for (int start = offset; start < end; start++) {

                    int headProfit = prices[end] - prices[start];
                    int tailProfit = maxProfit(prices, end + 1, transactionsLeft - 1);

                    int total = headProfit + tailProfit;

                    if (total > max) {
                        max = total;
                    }
                }
            }

            return max;
        } else {
            return 0;
        }
    }
}
