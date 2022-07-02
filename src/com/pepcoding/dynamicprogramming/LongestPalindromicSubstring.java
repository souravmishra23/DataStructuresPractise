package com.pepcoding.dynamicprogramming;

import java.util.Scanner;
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lpss-official/ojquestion
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean[][] dp = new boolean[str.length()][str.length()];
        int len = 0;
        int start = 0;
        int end = 0;
        for (int gap = 0; gap < str.length(); gap++) {

            for (int i = 0, j = gap; j < dp.length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                }else if (gap == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = false;
                    }
                }else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j] == true) {
                    len = gap + 1;
                    start = i;
                    end = j + 1;
                }
            }
        }
        System.out.println(str.substring(start,end));
    }
}
