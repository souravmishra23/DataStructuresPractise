package com.leetcode.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/delete-and-earn/
public class DeleteAndEarn {
    public static void main(String[] args) {
        System.out.println(" ===="+deleteAndEarn1(new int[] {2,2,3,3,3,4}));
    }

    public static int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = calculate(nums[i], nums);
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
     //   Arrays.sort(dp);
        return dp[n-1];
    }

    private static int calculate(int num, int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != num - 1 && nums[i] != num + 1) {
                count = count + nums[i];
            }
        }
        return count;
    }
    public static int deleteAndEarn1(int[] nums)
    {
        int max=0;
        for(int i:nums)
            max=Math.max(max,i);
        int dp[]=new int[max+2];
        for(int i:nums)
            dp[i]+=i;
        for(int i=2;i<max+2;++i)
        {
            dp[i]=Math.max(dp[i-2]+dp[i],dp[i-1]);
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        return dp[max+1];
    }
}
