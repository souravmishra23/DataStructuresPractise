package com.leetcode.dynamicprogramming;

import java.util.Scanner;

// https://leetcode.com/problems/jump-game/
public class JumpGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        canJump(arr);
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];

        dp[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i] && i + j < dp.length; j++) {
                if (dp[i + j]) {
                    dp[i] = true;
                    break;
                } else {
                    dp[i] = false;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
        return dp[0];
    }
}
