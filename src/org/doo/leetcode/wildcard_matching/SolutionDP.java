package org.doo.leetcode.wildcard_matching;

public class SolutionDP {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                }

            }
        }

        return dp[m][n];
    }

//    public boolean isMatch(String s, String p) {
//        int m=s.length();
//        int n=p.length();
//
//        boolean[][]dp=new boolean[m+1][n+1];
//
//        dp[0][0]=true;
//
//        for(int i=1;i<n+1;i++)
//        {
//            if(p.charAt(i-1)=='*')
//            {
//                dp[0][i]=dp[0][i-1];
//            }
//        }
//
//        for(int i=1;i<m+1;i++)
//        {
//            for(int j=1;j<n+1;j++)
//            {
//                if(s.charAt(i-1)==p.charAt(j-1) ||p.charAt(j-1)=='?')
//                {
//                    dp[i][j]=dp[i-1][j-1];
//                }
//                else if(p.charAt(j-1)=='*')
//                {
//                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
//                }
//            }
//        }
//
//        return dp[m][n];
//
//    }
}
