package com.leetcode.dynamicprogramming;

// https://leetcode.com/problems/counting-bits/
public class CountingBits {
    public static void main(String[] args) {
        int [] ans = countBits1(5);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = count(i);

        }
        return dp;
    }

    private static int count(int num) {
        String binaryIntInStr = Integer.toBinaryString(num);
        int count = 0;
        for (int i = 0; i < binaryIntInStr.length(); i++) {
            if (binaryIntInStr.charAt(i) == '1')
                count++;
        }
        return count;
    }

    public static int[] countBits1(int nums) {
        int ar[] = new int[nums + 1];
        ar[0] = 0;
        if (nums == 0) return ar;
        ar[1] = 1;
        if (nums == 1) return ar;

        for (int i = 2; i <= nums; i++)
            ar[i] = i % 2 == 0 ? ar[i >> 1] : ar[i >> 1] + 1;

        return ar;
    }
}
