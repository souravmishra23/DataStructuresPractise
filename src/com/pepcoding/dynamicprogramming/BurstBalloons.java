package com.pepcoding.dynamicprogramming;

public class BurstBalloons {
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3,1,5,8}));
    }
    public static int maxCoins(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];

        for(int g = 0; g < dp[0].length; g++) {
            for(int i = 0, j = g; j < dp[0].length; i++, j++) {
                int max = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++) {
                    int val = 0;
                    if(k - 1 >= i)
                        val += dp[i][k-1];
                    if(k + 1 <= j)
                        val += dp[k+1][j];
                    int mul = arr[k];
                    if(i - 1 >= 0)
                        mul *= arr[i-1];
                    if(j + 1 < arr.length)
                        mul *= arr[j+1];
                    val += mul;

                    if(val > max)
                        max = val;
                }
                dp[i][j] = max;
            }
        }
        return dp[0][dp[0].length - 1];
    }
}
