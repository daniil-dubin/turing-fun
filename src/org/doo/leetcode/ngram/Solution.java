package org.doo.leetcode.ngram;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new Solution().findAnagrams("baa", "aa"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int winlen = p.length();

        int distinctLetters = 0;

        int[] ngram = new int[26];
        for (int i = 0; i < winlen; i++) {
            int prev = ngram[p.charAt(i) - 'a']++;

            if (prev == 0) {
                distinctLetters++;
            }
        }

        int matched = 0;

        int[] count = new int[26];

        for (int window0 = 0, window1 = 0; window1 < s.length(); window1++) {
            if (window1 - window0 == winlen) {
                int chw0 = s.charAt(window0) - 'a';

                int prev = count[chw0]--;

                if (count[chw0] == ngram[chw0]) {
                    matched++;
                } else if (prev == ngram[chw0]) {
                    matched--;
                }

                window0++;
            }

            int chw1 = s.charAt(window1) - 'a';

            int prev = count[chw1]++;
            if (count[chw1] == ngram[chw1]) {
                matched++;
            } else if (prev == ngram[chw1]) {
                matched--;
            }


            if (matched == distinctLetters) {
                res.add(window0);
            }
        }

        return res;
    }
}