package com.leetcode.dynamicprogramming;

import java.awt.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// https://leetcode.com/problems/maximal-square/
public class MaximalSquare {
    public static void main(String[] args) {

    }
    public static int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = Integer.MIN_VALUE;
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 || j == dp[0].length - 1) {
                    dp[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] == '1') {
                    //  if any of those is zero minimum we can have only 1 x 1 square .. if not than 2 x 2
                    dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

   static HashMap<Point, Integer> cache = new HashMap<>();
    public static int recursiveSolution(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        helper(0,0,matrix);
        Comparator<? super Map.Entry<Point, Integer>> maxValueComparator = Comparator.comparing(Map.Entry::getValue);

        Optional<Map.Entry<Point, Integer>> maxValue = cache.entrySet()
                .stream().max(maxValueComparator);
        return maxValue.get().getValue() * maxValue.get().getValue();
    }
    private static int helper(int row, int col, char[][] matrix) {
        if (row >= matrix.length || col >= matrix[0].length) {
            return 0;
        }
        Point p = new Point(row,col);
        if (!cache.containsKey(new Point(row,col))) {
            int down = helper(row + 1 , col,matrix);
            int right = helper(row, col + 1,matrix);
            int diagonal = helper(row + 1 , col + 1,matrix);

            cache.put(p , 0);
            if (matrix[row][col] == '1') {
                cache.put(p,1 + Math.min(down , Math.min(right,diagonal)));
            }

        }
        return cache.get(p);
    }
}
