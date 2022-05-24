package com.pepcoding.dynamicprogramming;

import java.util.Scanner;
// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-sell-stocks-transaction-fee-ita-official/ojquestion
public class BuyAndSellStocksWithTransactionFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        int fee = sc.nextInt();
        int oldboughtStateProfit = - prices[0];
        int oldsoldStateProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int nbsp = 0;
            int nssp = 0;
            if (oldsoldStateProfit - prices[i] > oldboughtStateProfit) {
                nbsp = oldsoldStateProfit - prices[i];
            }
            else {
                nbsp = oldboughtStateProfit;
            }
            if (oldboughtStateProfit + prices[i] -fee > oldsoldStateProfit) {
                nssp = oldboughtStateProfit + prices[i] -fee;
            }else {
                nssp = oldsoldStateProfit;
            }
            oldboughtStateProfit = nbsp;
            oldsoldStateProfit = nssp;
        }
        System.out.println(oldsoldStateProfit);
    }

}
