package org.doo.leetcode.russian_doll;

import java.io.IOException;
import java.util.Arrays;

class SolutionN2LogN {
    public static void main(String[] args) throws IOException {
        System.out.println(new SolutionN2LogN().maxEnvelopes(Input.data()));
//        System.out.println(new SolutionN2LogN().maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
    }

    public int maxEnvelopes(int[][] env) {
        if (env.length == 0) {
            return 0;
        }

        int[][] maxContains = new int[env.length][2];

        for (int i = 0; i < env.length; i++) {
            maxContains[i][0] = i;

            int count = 0;
            for (int j = 0; j < env.length; j++) {
                if (env[j][0] < env[i][0] && env[j][1] < env[i][1]) {
                    count++;
                }
            }
            maxContains[i][1] = count;
        }

        Arrays.sort(maxContains, (a, b) -> a[1] - b[1]);

        int[] depth = new int[env.length];

        for (int k = 0; k < env.length; k++) {
            int i = maxContains[k][0];

            int max = 0;

            for (int j = 0; j < env.length; j++) {
                if (env[j][0] < env[i][0] && env[j][1] < env[i][1]) {
                    if (max < depth[j] + 1) {
                        max = depth[j] + 1;
                    }
                }
            }

            depth[i] = max;
        }

        int max = 0;
        for (int i = 0; i < depth.length; i++) {
            if (depth[i] > max) {
                max = depth[i];
            }
        }

        return max + 1;
    }
}