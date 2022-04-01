package com.leetcode.dynamicprogramming;

import java.util.Scanner;

public class MinimumPathSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(minPathSum(arr));
    }
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] dp = new int[n][m];
        for (int i = grid.length -1; i >=0 ; i--) {
            for (int j = grid[0].length -1; j >=0 ; j--) {
                if (i == grid.length -1 && j == grid[0].length -1) {
                    dp[i][j] = grid[i][j];
                }else if (i == grid.length -1) {
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                } else if (j == grid.length -1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                }else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j+1],dp[i+1][j]);
                }

            }
        }
        return dp[0][0];
    }
}
