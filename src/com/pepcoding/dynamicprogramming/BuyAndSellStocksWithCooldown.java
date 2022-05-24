package com.pepcoding.dynamicprogramming;

import java.util.Scanner;
// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-cooldown-ita-official/ojquestion
public class BuyAndSellStocksWithCooldown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        int obsp = - prices[0];
        int ossp = 0;
        int ocsp = 0;
        for (int i = 1; i < prices.length; i++) {
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;
            if (ocsp - prices[i] > obsp) {
                nbsp = ocsp - prices[i];
            }else {
                nbsp = obsp;
            }
            if (obsp + prices[i] > ossp) {
                nssp = obsp + prices[i];
            }else {
                nssp = ossp;
            }
            if (ossp > ocsp) {
                ncsp = ossp;
            }
            else {
                ncsp = ocsp;
            }
            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        System.out.println(ossp);
    }
}
