package com.leetcode.dynamicprogramming;

import java.util.Scanner;

public class MinimumFallingPathSum {
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
        System.out.println( minFallingPathSum(arr));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int row = dp.length - 1;row >= 0; row--) {
            for (int col = dp[0].length - 1; col >= 0 ; col--) {
                if (row == dp.length - 1) {
                    dp[row][col] = 0;
                }
                else if (row == dp.length - 2){
                    if (col == dp[0].length - 1) {
                        int min = Math.min(matrix[row + 1][col - 1],matrix[row + 1][col]);
                        dp[row][col] = min + matrix[row][col];
                    }
                   else if (col == 0) {
                        int min = Math.min(matrix[row + 1][col + 1],matrix[row + 1][col]);
                        dp[row][col] = min + matrix[row][col];
                    }
                    else  {
                        int min = Math.min(Math.min(matrix[row + 1][col - 1],matrix[row + 1][col + 1])
                                ,matrix[row + 1][col]);
                        dp[row][col] = min + matrix[row][col];

                    }
                }else {
                    if (col == dp[0].length - 1) {
                        int min = Math.min(dp[row + 1][col - 1],dp[row + 1][col]);
                        dp[row][col] = min + matrix[row][col];
                    }
                    else if (col == 0) {
                        int min = Math.min(dp[row + 1][col + 1],dp[row + 1][col]);
                        dp[row][col] = min + matrix[row][col];
                    }
                    else  {
                        int min = Math.min(Math.min(dp[row + 1][col - 1],dp[row + 1][col + 1])
                                ,dp[row + 1][col]);
                        dp[row][col] = min + matrix[row][col];

                    }
                }

            }

        }
        /*for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }

        }*/
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < dp[0].length; j++) {
            if (dp[0][j] < min) {
                min = dp[0][j];
            }
        }
        return min;
    }
}
