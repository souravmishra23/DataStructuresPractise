package com.leetcode.dynamicprogramming;
// https://leetcode.com/problems/wiggle-subsequence/
public class WiggleSubsequence {
    public static void main(String[] args) {

    }

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = dp2[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp1[i] = dp2[i - 1] + 1;
                dp2[i] = dp2[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                dp2[i] = dp1[i - 1] + 1;
                dp1[i] = dp1[i - 1];
            } else {
                dp1[i] = dp1[i - 1];
                dp2[i] = dp2[i - 1];
            }
        }
        return Math.max(dp1[n - 1], dp2[n - 1]);
    }
}
