package com.leetcode.dynamicprogramming;

// https://leetcode.com/problems/ones-and-zeroes/
public class OnesandZeroes {
    static int [][][] dp;
    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        dp = new int [m + 1][n + 1][strs.length];
        return helper(strs, m, n, 0);
    }

    private static int helper(String[] strs, int zeros, int ones, int index) {
        if (index == strs.length || zeros + ones == 0) {
            return 0;
        }
        if (dp[zeros][ones][index] > 0) {
            return dp[zeros][ones][index];
        }
        int[] count = count(strs[index]);
        int consider = 0;
        if (zeros >= count[0] && ones >= count[1]) {
            consider = 1 + helper(strs, zeros - count[0], ones - count[1], index + 1);
        }
        int skip = helper(strs, zeros, ones, index + 1);
        dp[zeros][ones][index] = Math.max(consider, skip);

        return dp[zeros][ones][index];
    }

    private static int[] count(String str) {
        int[] count = new int[2];
        for (char c : str.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
}
