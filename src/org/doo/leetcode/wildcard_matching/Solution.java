package org.doo.leetcode.wildcard_matching;

public class Solution {

    public static void main(String[] args) {

        assert new Solution().isMatch("adceb", "*a*b") == true;
        assert new Solution().isMatch("acdcb", "a*c?b") == false;
        assert new Solution().isMatch("", "") == true;
        assert new Solution().isMatch("aaaa", "") == false;
        assert new Solution().isMatch("", "a") == false;
        assert new Solution().isMatch("", "?") == false;
        assert new Solution().isMatch("", "*") == true;
        assert new Solution().isMatch("a", "a*") == true;
        assert new Solution().isMatch("a", "a***") == true;
        assert new Solution().isMatch("a", "") == false;
        assert new Solution().isMatch("ho", "ho**") == true;
        assert new Solution().isMatch("aa", "*") == true;

        assert new Solution().isMatch(
                "bbbababbbbabbbbababbaaabbaababbbaabbbaaaabbbaaaabb",
                "*b********bb*b*bbbbb*ba"
        ) == false;


        assert new Solution().isMatch("aa", "a") == false;
        assert new Solution().isMatch("a", "aa") == false;

        assert (new Solution().isMatch("aa", "*a") == true);
        assert (new Solution().isMatch("ab", "*a") == false);

        assert (new Solution().isMatch("ab", "a") == false);
        assert (new Solution().isMatch("ba", "*a") == true);

        assert (new Solution().isMatch("aaab", "b**") == false);

        assert (new Solution().isMatch("aaab", "*") == true);
        assert (new Solution().isMatch("aaab", "*******") == true);

    }

    private static class Tuple {
        public Tuple(int sof, int pof) {
            this.sof = sof;
            this.pof = pof;
        }

        public int sof, pof;
    }

    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        return isMatch(s.toCharArray(), p.toCharArray());
    }

    public boolean rightMatch(char[] s, char[] p) {
        for (int i = s.length - 1, j = p.length - 1; i >= 0 && j >= 0; i--, j--) {
            if (p[j] == '*') {
                return true;
            }

            if (p[j] != '?' && p[j] != s[i]) {
                return false;
            }
        }

        return s.length == p.length;
    }

    public Tuple search(boolean strictLeft, char[] s, int sof, char[] p, int pof) {
        if (sof == s.length && p[pof] == '*') {
            return new Tuple(sof, pof + 1);
        }

        for (int i = sof; i < s.length; i++) {

            boolean matched = true;
            int m = i;
            int j = pof;

            for (; j < p.length && m < s.length; j++, m++) {
                char pi = p[j];

                if (pi == '*') {
                    return new Tuple(m, j + 1);
                } else if (pi == '?') {
                    //nop
                } else if (pi != s[m]) {
                    matched = false;
                    break;
                }
            }



            if (matched) {
                return new Tuple(m, j);
            } else if (strictLeft) {
                break;
            }
        }

        return null;
    }

    public boolean isMatch(char[] s, char[] p) {
        int sof = 0;
        int pof = 0;

        do {
            Tuple index = search(pof == 0, s, sof, p, pof);
            if (index == null) {
                return false;
            }

            sof = index.sof;
            pof = index.pof;

            if (pof == p.length) {
                return sof == s.length || rightMatch(s, p);
            }

        } while (true);

    }
}
