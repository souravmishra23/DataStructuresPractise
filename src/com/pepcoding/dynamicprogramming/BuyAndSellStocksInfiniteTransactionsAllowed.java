package com.pepcoding.dynamicprogramming;

import java.util.Scanner;

public class BuyAndSellStocksInfiniteTransactionsAllowed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int buyinDate = 0;
        int sellDate = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i-1]) {
                sellDate ++ ;
            }else {
                profit += prices[sellDate] - prices[buyinDate];
                sellDate = buyinDate = i;
            }
        }
        // collecting the last profit..
        profit += prices[sellDate] - prices[buyinDate];
        System.out.println(profit);
    }
}
