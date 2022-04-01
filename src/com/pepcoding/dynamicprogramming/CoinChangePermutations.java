package com.pepcoding.dynamicprogramming;

import java.util.Scanner;

// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/coin-change-permutations-official/ojquestion
/*4
2
3
5
6
7*/
public class CoinChangePermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        int[] dp = new int[tar + 1];
        dp[0] = 1;
        for (int amt = 1; amt <= tar; amt++) {
            for (int coin : coins) {
                if (coin <= amt) {
                    int remainingAmount = amt - coin;
                    dp[amt] = dp[amt] + dp[remainingAmount];
                }
            }
        }
        System.out.println(dp[tar]);
    }
}
