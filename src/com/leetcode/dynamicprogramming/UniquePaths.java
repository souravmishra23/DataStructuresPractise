package com.leetcode.dynamicprogramming;
// https://leetcode.com/problems/unique-paths/
public class UniquePaths {
    public static void main(String[] args) {
        solveUniquePaths(3,7);
    }
    static void solveUniquePaths(int row,int col) {
        int [][] dp = new int[row][col];
        for (int i = dp.length -1; i >=0 ; i--) {
            for (int j = dp[0].length -1; j >=0 ; j--) {
                if (i == dp.length -1 && j == dp[0].length -1) {
                    dp[i][j] = 0;
                }
                else if (i == dp.length -1) {
                    dp[i][j] = 1;
                }else if (j == dp[0].length -1) {
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i][j+1] + dp[i+1][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
