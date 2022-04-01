package com.leetcode.dynamicprogramming;

import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,1};
        System.out.println(Math.max(rob(Arrays.copyOfRange(nums,0,nums.length-1)),rob(Arrays.copyOfRange(nums,1,nums.length))));
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[n-1];
        }
        int[] dp = new int[n+1];
        dp[n] = 0;
        dp[n-1] = nums[n-1];
        dp[n-2] = nums[n-2];

        // Iterate from the end to get max possible cost
        for(int i=n-3; i>=0; i--){
            // dp[i+2] and dp[i+3] is used because next consecutive house cant be robbed
            dp[i] = nums[i] + Math.max(dp[i+2], dp[i+3]);
        }
        // System.out.println(Arrays.toString(dp));
        return Math.max(dp[0], dp[1]);
    }
}
