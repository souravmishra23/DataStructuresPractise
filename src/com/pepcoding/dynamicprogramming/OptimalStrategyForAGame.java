package com.pepcoding.dynamicprogramming;

import java.util.Scanner;

public class OptimalStrategyForAGame {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
        optimalStrategy(a);
    }
    public static void optimalStrategy(int[] arr) {
        //write your code here

        int [][] dp = new int[arr.length][arr.length];
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0,j = gap; j < dp.length; i++,j++) {
                    if (gap == 0) {
                        dp[i][j] = arr[i];
                    }else if (gap == 1) {
                        dp[i][j] = Math.max(arr[i],arr[j]);
                }
                    else {
                        int val1 = arr[i] + Math.min(dp[i + 2][j],dp[i + 1][j - 1]);
                        // i -> i + 1,j
                        // if i + 1 -> i + 2 , j
                        // or j -> i + 1, j - 1
                        int val2 = arr[j] + Math.min(dp[i + 1][j - 1],dp[i][j - 2]);
                        int val = Math.max(val1,val2);
                        dp[i][j] = val;

                }
            }
        }
        System.out.println(dp[0][arr.length - 1]);
    }
}
