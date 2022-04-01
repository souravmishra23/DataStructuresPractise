package com.leetcode.dynamicprogramming;

import java.util.Scanner;
// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/target-sum-subsets-dp-official/ojquestion
/*5
4
2
7
1
3
10*/
public class TargetSumSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();

        boolean[][] dp = new boolean[n + 1][tar + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }else if (i == 0) {
                    dp[i][j] = false;
                }else if (j == 0) {
                    dp[i][j] = true;
                }
                else {
                    if (dp[i -1][j] == true) {
                        dp[i][j] = true;
                    }else {
                        int val = arr[i-1]; // getting the value the index is  i -1
                        if (j>=val) {     /// checking if value scored by j is greater than val
                            if (dp[i-1][j-val] == true) { // checking if the remaining sum is providing by j - val
                                dp[i][j] = true; // making it true
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[arr.length][tar]);
    }

}
