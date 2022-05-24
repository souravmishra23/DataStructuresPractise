package com.leetcode.dynamicprogramming;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    // if two characters are equal no  need to perform any operation .. just take the previous count of
                    // by removing that one charcter operation
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // take the min of three operations and add one 1 to it
                        dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                    }
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
