package org.doo.leetcode.stock_spanner;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class StockSpanner {

    public static void main(String[] args) {
        StockSpanner S = new StockSpanner();
        S.next1(100); // is called and returns 1,
        S.next1(80); // is called and returns 1,
        S.next1(60); // is called and returns 1,
        S.next1(70); // is called and returns 2,
        S.next1(60); // is called and returns 1,
        S.next1(75); // is called and returns 4,
        S.next1(85); // is called and returns 6.
    }

    public void next1(int price) {
        System.out.println(next(price));
    }

    TreeMap<Integer, Integer> prices = new TreeMap();
    int index = 0;

    public StockSpanner() {

    }

    /**
     * it should have been just a stack, no use in tree :)
     */

    public int next(int price) {
        Iterator<Map.Entry<Integer, Integer>> iter = prices.entrySet().iterator();

        int start = -1;

        Map.Entry<Integer, Integer> max = prices.ceilingEntry(price);
        if (max != null) {
            while (iter.hasNext()) {
                Map.Entry<Integer, Integer> prev = iter.next();
                if (prev.getKey() <= price) {
                    iter.remove();
                } else {
                    start = prev.getValue();
                    break;
                }
            }
        }

        prices.put(price, index);

        return index++ - start;
    }
}