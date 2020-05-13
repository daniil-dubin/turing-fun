package org.doo.rev;

public class StockII {

    public static void main(String[] args) {
        System.out.println(new StockII().maxProfit(new int[] {8,6,4,3,3,2,3,5,8,3,8,2,6})); //15
        System.out.println(new StockII().maxProfit(new int[] {5,2,3,2,6,6,2,9,1,0,7,4,5,0})); //20
    }

//    public int maxProfit(int[] prices) {
//
//        int min = prices[0];
//
//        int total = 0;
//
//        int dp0 = 1;
//
//        for (int i = 1; i < prices.length; i++) {
//            int dp = prices[i] - prices[i - 1];
//
//            if (dp0 > 0 && dp <= 0) {
//                total += prices[i - 1] - min;
//            }
//
//            if (dp0 <= 0 && dp >= 0) {
//                min = prices[i - 1];
//            }
//
//            dp0 = dp;
//        }
//
//        if (dp0 >= 0) {
//            total += prices[prices.length - 1] - min;
//        }
//
//        return total;
//    }

    public int maxProfit(int[] prices) {

        int total = 0;

        for (int i = 1; i < prices.length; i++) {
            int dp = prices[i] - prices[i - 1];

            if (dp > 0) {
                total += dp;
            }
        }

        return total;
    }
}
