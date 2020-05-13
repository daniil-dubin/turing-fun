package org.doo.rev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockIV {

    public static void main(String[] args) {
//        System.out.println(new StockIV().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3})); //7
//        System.out.println(new StockIV().maxProfit(2, new int[]{2, 4, 1})); //7
        System.out.println(new StockIV().maxProfit(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4})); //6
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        List<Transaction> transactionList = allTransactions(prices);
        if (transactionList.isEmpty()) {
            return 0;
        }

        Transaction transactions = toChain(transactionList);

        return maxProfit(transactions, transactionList.size(), k);
    }

    private int maxProfit(Transaction transactions, int transactionsSize, int k) {
        while (true) {
            if (transactionsSize > k) {
                Transaction minMergeLossT = transactions;
                int minMergeLoss = minMergeLossT.mergeLoss();

                Transaction minProfitT = transactions;
                int minProfit = minProfitT.nextProfit();

                Transaction t = transactions;
                while (t != null) {
                    if (t.mergeLoss() < minMergeLoss) {
                        minMergeLoss = t.mergeLoss();
                        minMergeLossT = t;
                    }

                    if (t.nextProfit() < minProfit) {
                        minProfit = t.nextProfit();
                        minProfitT = t;
                    }

                    t = t.next;
                }

                if (minProfit < minMergeLoss) {
                    minProfitT.removeNext();
                } else {
                    minMergeLossT.merge();
                }

                Arrays.sort(new int[]{});

                transactionsSize--;
            } else {
                int profit = 0;
                Transaction t = transactions;
                while (t != null) {
                    profit += t.profit();
                    t = t.next;
                }
                return profit;
            }
        }
    }

    private static class Transaction {

        private boolean head;

        public Transaction(Transaction next) {
            this.next = next;
            this.head = true;
        }

        public Transaction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int x;
        private int y;

        public Transaction next;

        public int mergeLoss() {
            if (head) {
                return Integer.MAX_VALUE;
            }

            if (next != null) {
                return y - next.x;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        public void merge() {
            if (next != null) {
                y = next.y;
                next = next.next;
            }
        }

        public void removeNext() {
            if (next != null) {
                next = next.next;
            }
        }

        public int profit() {
            return y - x;
        }

        public int nextProfit() {
            if (next != null) {
                return next.y - next.x;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    ", d=" + (y - x) +
                    '}';
        }
    }

    private Transaction toChain(List<Transaction> list) {
        Transaction transactions = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            Transaction t = list.get(i);
            t.next = transactions;
            transactions = t;
        }

        return new Transaction(transactions);
    }

    // from problem II
    private List<Transaction> allTransactions(int[] prices) {

        List<Transaction> transactions = new ArrayList<>();

        int min = prices[0];

        int dp0 = 1;

        for (int i = 1; i < prices.length; i++) {
            int dp = prices[i] - prices[i - 1];

            if (dp0 > 0 && dp <= 0) {
                if (prices[i - 1] - min > 0) {
                    transactions.add(new Transaction(min, prices[i - 1]));
                }
            }

            if (dp0 <= 0 && dp >= 0) {
                min = prices[i - 1];
            }

            dp0 = dp;
        }

        if (dp0 >= 0) {
            if (prices[prices.length - 1] - min > 0) {
                transactions.add(new Transaction(min, prices[prices.length - 1]));
            }
        }

        return transactions;
    }

}
