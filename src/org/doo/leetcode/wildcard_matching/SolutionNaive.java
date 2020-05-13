package org.doo.leetcode.wildcard_matching;

public class SolutionNaive {

    public static void main(String[] args) {
//        System.out.println(new Solution().isMatch("adceb", "*a*b")); //true
//        System.out.println(new Solution().isMatch("acdcb", "a*c?b")); //false
//        System.out.println(new Solution().isMatch("", "")); //true
//        System.out.println(new Solution().isMatch("", "a")); //false
//        System.out.println(new Solution().isMatch("", "?")); //false
//        System.out.println(new Solution().isMatch("", "*")); //true
//        System.out.println(new Solution().isMatch("a", "a*")); //true
//        System.out.println(new Solution().isMatch("a", "")); //false
//        System.out.println(new Solution().isMatch("ho", "ho**")); //true
//        System.out.println(new Solution().isMatch("aa", "*")); //true
        System.out.println(new SolutionNaive().isMatch(
                "bbbababbbbabbbbababbaaabbaababbbaabbbaaaabbbaaaabb",
                "*b********bb*b*bbbbb*ba"
        ));
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    public boolean isMatch(char[] s, int sof, char[] p, int pof) {
        if (pof == p.length) {
            return sof == s.length;
        }

        char pi = p[pof];

        if (pi == '?') {
            return sof < s.length && isMatch(s, sof + 1, p, pof + 1);
        } else if (pi == '*') {
            if (pof == p.length - 1) {
                return true;
            }

            int wildSof = sof;
            do {
                if (isMatch(s, wildSof, p, pof + 1)) {
                    return true;
                }
                wildSof++;
            } while (wildSof < s.length);

            return false;
        } else {
            if (sof < s.length && pi == s[sof]) {
                return isMatch(s, sof + 1, p, pof + 1);
            } else {
                return false;
            }
        }
    }


}
