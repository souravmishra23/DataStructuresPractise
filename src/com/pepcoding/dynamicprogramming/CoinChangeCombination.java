package com.pepcoding.dynamicprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/coin-change-combination-official/ojquestion

/*4
2
3
5
6
7*/

public class CoinChangeCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        int [] dp = new int[amt+1];
        dp[0] = 1; // to pay 0 we have one way pay nothing
        for (int i = 0; i < coins.length; i++) { // taking each amount at a time to avoid permutation , we are just taking combination
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j - coins[i]]; // adding previous combination of amount to be paid
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.print(dp[i] + " ");
//        }
        System.out.println(dp[amt]);
    }
}
