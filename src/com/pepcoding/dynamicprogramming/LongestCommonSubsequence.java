package com.pepcoding.dynamicprogramming;

import java.util.Scanner;
/*abcd
aebd*/
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lcs-official/ojquestion
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
