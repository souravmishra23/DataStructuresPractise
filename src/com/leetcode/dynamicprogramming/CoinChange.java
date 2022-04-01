package com.leetcode.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println( coinChange(new int[]{1,2,5} , 11));
    }
    public static int coinChange(int[] coins, int amount) {
        //dp[i] will store the minimum number of coins required to pay amount i.
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        //dp[0] means minimum number of coins required to pay amount 0, which is 0 as no coins are required.
        dp[0] = 0;

        //Taking one coin at a time.
        for (int i = 0; i < coins.length; i++) {
            //Loop in dp array from coins[i] (as a payment of value less than coin's value cannot be made).
            for (int j = coins[i]; j < dp.length; j++) {
                //If dp[j - coins[i]] == Integer.MAX_VALUE, meaning (j - coins[i]) amount cannot be paid,
                //then j amount cannot be paid.
                //Example : If 7 rupees has to be paid using 5 rupee coin, then check if 7 - 5, i.e. 2 rupees
                //can be paid or not. If 2 rupees cannot be paid, then we cannot pay 7 rupees even with a
                //5 rupee coin.
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    //Minimum number of coins required to pay amount j will be equal to minimum number of
                    //coins required to pay amount (j - coins[i]) + 1. Do +1 as we are using coins[i] coin.
                    int val = dp[j - coins[i]] + 1;
                    //Store minimum of dp[j] and val in dp[j].
                    dp[j] = Math.min(dp[j], val);
                }
            }
        }

        //If dp[amount] == Integer.MAX_VALUE, meaning the amount cannot be paid using the given coins,
        //so return -1, else dp[amount].
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
