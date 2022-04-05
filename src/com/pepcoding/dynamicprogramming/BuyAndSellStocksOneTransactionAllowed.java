package com.pepcoding.dynamicprogramming;

import java.util.Scanner;
// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-ota-official/ojquestion
public class BuyAndSellStocksOneTransactionAllowed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        int leastSoFar = Integer.MAX_VALUE;
        int overAllProfit = 0;
        int profitIfSoldToday = 0;
        for (int price : prices) {
            if (price < leastSoFar) {
                leastSoFar = price;
            }

            profitIfSoldToday = price - leastSoFar;
            if (profitIfSoldToday > overAllProfit) {
                overAllProfit = profitIfSoldToday;
            }
        }
        System.out.println(overAllProfit);
    }
}
