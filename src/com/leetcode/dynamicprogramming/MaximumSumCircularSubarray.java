package com.leetcode.dynamicprogramming;

public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        int [] nums = new int[]{5,-3,5};
        System.out.println( maxSubarraySumCircular(nums));
        System.out.println( maxSubarraySumCircularBruteForce(nums));
    }
    public static int maxSubarraySumCircular(int[] nums) {

        int curMax=0,maxSum=nums[0],curMin=0,minSum=nums[0],sum=0;

        for(int n:nums)
        {
            curMax= Math.max(curMax+n,n);
            maxSum= Math.max(maxSum,curMax);
            curMin= Math.min(curMin+n,n);
            minSum= Math.min(minSum,curMin);

            sum=sum+n;
        }

        return maxSum>0 ? Math.max(maxSum,sum-minSum):maxSum;

    }
    public static int maxSubarraySumCircularBruteForce(int[] nums) {
            int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return (maxSum);
    }
    public static int KadaneAlgo(int[] arr) {
        // write your code here
        int currentSum = arr[0];
        int overallSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currentSum >= 0) {
                currentSum += arr[i];
            }
            else
            {
                currentSum = arr[i];
            }
            if (currentSum > overallSum) {
                overallSum = currentSum;
            }
        }
        return overallSum;
    }

}
