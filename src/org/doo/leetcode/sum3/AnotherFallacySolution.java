package org.doo.leetcode.sum3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AnotherFallacySolution {
    public static void main(String[] args) {
//        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//        System.out.println(new Solution().threeSum(new int[]{0, 0, 0}));
//        System.out.println(new Solution().threeSum(new int[]{0, 0, 0, 0}));
//        System.out.println(new Solution().threeSum(new int[]{0, 0, 0, 0, 0, 0}));
//        System.out.println(new Solution().threeSum(new int[]{0, 0, 0, 0, 0, 0, 0, 0}));

//        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1}));
        System.out.println(new AnotherFallacySolution().threeSum(new int[]{-2, -1, 0, 0, 0, 1, 2}));
    }

    boolean allZeros = false;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        int min = 0;
        int max = nums.length - 1;

        while (nums[max] >= 0 && max - min >= 1) {
            int sum = nums[min] + nums[max];

            if (sum == 0) {
                triplet(nums[min], nums[max], nums[max - 1]);

                min++;
                max -= 2;
            } else if (sum < 0) {
                min++;
            } else { //sum > 0
                max--; //incorrect!!! different combinations must be checked!!!
            }
        }


        min = 0;
        max = nums.length - 1;

        while (nums[min] <= 0 && max - min >= 1) {
            int sum = nums[min + 1] + nums[min] + nums[max];

            if (sum == 0) {
                triplet(nums[min], nums[min + 1], nums[max]);

                min += 2;
                max--;
            } else if (sum < 0) {
                min++;
            } else { //sum > 0
                max--;
            }
        }

        return res;
    }

    private void triplet(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0) {
            if (allZeros) {
                return;
            }
            allZeros = true;
        }

        List<Integer> triplet = new ArrayList<>();
        triplet.add(a);
        triplet.add(b);
        triplet.add(c);

        res.add(triplet);
    }
}