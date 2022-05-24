package com.leetcode.dynamicprogramming;
// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class LongestIncreasingPathMatrix {
    private static int maxPath = 0;
    public static void main(String[] args) {
        System.out.println(longestIncreasingPath(new int[][]{}));
    }
    public static int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
                calculatePath(matrix,dp,i,j,row,col,-1);
        }

        return maxPath;
    }
    private static  int calculatePath(int[][] matrix,int[][] dp,int i,int j,int row, int col,int value)
    {
        if(i > -1 && i < row && j > -1 && j < col && matrix[i][j] > value)
        {
            if(dp[i][j] > 0)
                return dp[i][j]; // if the current cell has been computed previously

            int top = calculatePath(matrix, dp, i - 1, j,row, col, matrix[i][j]);
            int bottom = calculatePath(matrix, dp, i + 1, j,row, col, matrix[i][j]);
            int left = calculatePath(matrix, dp, i, j - 1,row, col, matrix[i][j]);
            int right = calculatePath(matrix, dp, i, j + 1,row, col, matrix[i][j]);

            // calculating Maximum of all directions till our current cell
            int allDirections = Math.max(Math.max(top,bottom),Math.max(left,right));
            dp[i][j] = Math.max(dp[i][j],allDirections + 1);
            maxPath = Math.max(dp[i][j],maxPath); // overall Maximum
            return dp[i][j];
        }

        return 0;
    }
}
