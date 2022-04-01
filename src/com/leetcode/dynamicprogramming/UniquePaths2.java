package com.leetcode.dynamicprogramming;

import java.util.Scanner;

// https://leetcode.com/problems/unique-paths-ii/
public class UniquePaths2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        uniquePathsWithObstacles(grid);
    }
    static void uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1){
            System.out.println(obstacleGrid[0][0]);
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int [][] dp = new int[row][col];
        for (int i = dp.length -1; i >=0 ; i--) {
            for (int j = dp[0].length -1; j >=0 ; j--) {
                if ((i == dp.length -1 && j == dp[0].length -1) && obstacleGrid[i][j] != 1) {
                    //  taken as 2 can take any value since it is the destination
                    dp[i][j] = 2;
                }
                else if (i == dp.length -1 && obstacleGrid[i][j] != 1) {
                    if (dp[i][j+1] == 2){
                        dp[i][j] = 1;
                    }else
                    dp[i][j] = dp[i][j+1];
                }else if (j == dp[0].length -1 && obstacleGrid[i][j] != 1) {
                    if (dp[i+1][j] == 2){
                        dp[i][j] = 1;
                    }else
                    dp[i][j] = dp[i+1][j];
                }else {
                    if ( obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i][j+1] + dp[i+1][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println(dp[0][0]);
    }
}
