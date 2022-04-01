package com.leetcode.dynamicprogramming;
// https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {
    public static void main(String[] args) {
        jump(new int[]{2,3,1,1,4});
    }

    public static int jump(int[] arr) {
        int n = arr.length;
        Integer[] dp = new Integer[n];
        dp[n -1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }
         for (int i = 0; i < dp.length; i++) {
             System.out.print(dp[i]+" ");
         }
        return (dp[0]);
    }
}
