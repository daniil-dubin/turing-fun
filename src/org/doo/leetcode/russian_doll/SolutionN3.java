package org.doo.leetcode.russian_doll;

import java.io.IOException;

class SolutionN3 {
    public static void main(String[] args) throws IOException {
        System.out.println(new SolutionN3().maxEnvelopes(Input.data()));
    }

    public int maxEnvelopes(int[][] env) {
        if (env.length == 0) {
            return 0;
        }

        int[] max = new int[env.length];
        int res = 0;

        boolean continueMerge;
        do {
            continueMerge = false;

            for (int i = 0; i < env.length; i++) {
                for (int j = 0; j < env.length; j++) {
                    if (env[j][0] < env[i][0] && env[j][1] < env[i][1]) {
                        if (max[i] < max[j] + 1) {
                            max[i] = max[j] + 1;
                            continueMerge = true;

                            if (max[i] > res) {
                                res = max[i];
                            }
                        }
                    }
                }
            }
        } while (continueMerge);

        return res + 1;
    }
}