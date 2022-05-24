package com.leetcode.dynamicprogramming;
// https://leetcode.com/problems/perfect-squares/
public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
    public static int numSquares(int n) {
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        if(n>1)
            for(int i= 2 ;i<dp.length;i++)
            {
                int min = Integer.MAX_VALUE;
                for(int j = 1;j*j<=i;j++)
                {
                    if(i - j*j >= 0)
                    {
                        min =Math.min(dp[i-j*j],min );
                    }
                }
                dp[i] = min+1;
            }
        return dp[n];
    }
}
