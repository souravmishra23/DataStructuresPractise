package com.leetcode.dynamicprogramming;

public class BestSightseeingPair {
    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair1(new int[]{8,1,5,2,6}));
    }
    public static int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int max = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                int sum = 0;
                sum = sum + values[i] + values[j] + i - j;
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int maxScoreSightseeingPair1(int[] values) {
        int max = -1;
        int currMax = values[0];
        for(int i =1;i<values.length;i++){
            int tempMax = currMax + (values[i] - i);
            max = Math.max(tempMax, max);
            currMax = Math.max(currMax, values[i] + i);
        }
        return max;
    }
    public int maxScoreSightseeingPair2(int[] values) {

        int max= Integer.MIN_VALUE;
        int n= values.length;
        int dp[]= new int[n];

        if(n==0)
            return 0;
        if(n==1)
            return values[0];
        if(n==2)
        {
            return values[0]+ values[1] -1;
        }
        dp[0]= values[0];
        dp[1]= values[0]+ values[1] -1;

        max= Math.max(dp[0], dp[1]);
        for(int i=2 ; i< n; i++)
        {
            dp[i]= Math.max(values[i-1]+values[i]-1, ((dp[i-1]-values[i-1])+values[i]-1));
            max= Math.max(max, dp[i]);

        }
        return max;
    }
}
