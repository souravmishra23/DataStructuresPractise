package com.leetcode.dynamicprogramming;

public class IsSubsequence {
    public static void main(String[] args) {
        boolean ans = isSubsequence("abc" , "ahbgdc");
        System.out.println(ans);
    }
    public static boolean isSubsequence(String s1, String s2) {
        int commonLength = bottomUpLCS(s1, s2);
        return commonLength == s1.length();
    }

    public static int bottomUpLCS(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
