package com.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/discuss/1849093/Easy-to-Understand-or-Java-or-DP-or-0ms
public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int N){
        List<List<Integer>> result = new ArrayList<>();
        if (N == 1) {
            result.add(Arrays.asList(1));
            return result;
        }
        int [][] dp = new int[N][N];
        dp[0][0] = 1;
        dp[1][0] = dp[1][1] = 1;
        for (int i = 2; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j ==0 || j == i) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
            }
        }
        for(int i=0; i<N; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<N; j++){
                if(dp[i][j] !=0) row.add(dp[i][j]);
            }
            result.add(row);
        }
        return result;
    }
}
