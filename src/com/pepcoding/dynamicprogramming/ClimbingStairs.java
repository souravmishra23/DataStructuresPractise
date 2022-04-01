package com.pepcoding.dynamicprogramming;

import java.util.Scanner;
// https://www.youtube.com/watch?v=A6mOASLl2Dg&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=2
// climb stair with 3 jumps of either 1,2 or 3
public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       // int cp = countPaths(n, new int[n + 1]);
        int cp = countPathTab(n);
        System.out.println(cp);
    }

    static int countPaths(int n, int[] qb) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        int nm1 = countPaths(n - 1, qb);
        int nm2 = countPaths(n - 2, qb);
        int nm3 = countPaths(n - 3, qb);
        int cp = nm1 + nm2 + nm3;
        qb[n] = cp;
        return cp;
    }
    static int countPathTab(int n) {
        int [] dp =new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i-1];
            }
           else if (i == 2) {
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }
}
