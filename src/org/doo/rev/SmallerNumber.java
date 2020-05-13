package org.doo.rev;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class SmallerNumber {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SmallerNumber().smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
    }

//    public int[] smallerNumbersThanCurrent(int[] nums) {
//        int[] occurrences = new int[101];
//
//        for (int i = 0; i < nums.length; i++) {
//            occurrences[nums[i]]++;
//        }
//
//        int sum = 0;
//        for (int i = 0; i < occurrences.length; i++) {
//            int prev = occurrences[i];
//            occurrences[i] = sum;
//            sum += prev;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = occurrences[nums[i]];
//        }
//
//        return nums;
//    }


    private static class Int {
        public int value;
    }

    // N * log N + N + N = O(N log N)
    public int[] smallerNumbersThanCurrent(int[] nums) {
        TreeMap<Integer, Int> occurrences = new TreeMap<>();

        //total = N * log N
        for (int i = 0; i < nums.length; i++) {// N
            occurrences.computeIfAbsent(nums[i], k -> new Int()).value++; //log N
        }

        int sum = 0;

        // another N in worst case if all number are unique
        for (Int count : occurrences.values()) {
            int prev = count.value;
            count.value = sum;
            sum += prev;
        }

        // N
        for (int i = 0; i < nums.length; i++) {
            nums[i] = occurrences.get(nums[i]).value;
        }

        return nums;
    }

    public int[] smallerNumbersThanCurrentOptimized(int[] nums) {

        Map<Integer, LinkedList<Integer>> mappings = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> locs = mappings.computeIfAbsent(nums[i], num-> new LinkedList<>());
            locs.add(i);
        }
        int[] res = new int[nums.length];
        Arrays.sort(nums);

        int prev = nums[0];
        int prevCnt = 0;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur == prev) {
                res[mappings.get(cur).removeLast()] = prevCnt;
            } else {
                res[mappings.get(cur).removeLast()] = i;
                prevCnt = i;
            }
            prev = cur;
        }
        return res;
    }

}
