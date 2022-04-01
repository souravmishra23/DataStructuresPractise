package com.leetcode.dynamicprogramming;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {
    static int min_index = 0;

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        // dp[i] denotes max profit which can be made at ith day
        int last_min_price = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] > last_min_price) {
                dp[i] = Math.max(dp[i - 1], prices[i] - last_min_price);
            } else {
                last_min_price = prices[i];
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }

    public static int otherWay(int[] prices) {
        int min = prices[min_index];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                min_index = i;
            }
        }
        max = min;
        for (int i = min_index + 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        return max - min;
    }

    public int maxProfit1(int[] prices) {

        int min = Integer.MAX_VALUE, max = 0;

        if (prices == null || prices.length == 0) return 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else if (prices[i] - min > max)
                max = prices[i] - min;
        }
        return max;
    }
}
