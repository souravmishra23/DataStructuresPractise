package com.leetcode.dynamicprogramming;


// https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int [n+1];
        dp[n-1] = cost[n-1];
        for(int i = n-2; i >= 0; i--){
            dp[i] = cost[i] + Math.min(dp[i+1],dp[i+2]);
        }
        return Math.min(dp[0],dp[1]);
    }
}
