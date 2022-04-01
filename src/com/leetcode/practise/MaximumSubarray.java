package com.leetcode.practise;
//Kadane's Algorithm works for to take the sub-array from the Array & give the maximum sum of Sub-Array
public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];

        for (int num : nums) {
            sum += num;

            if (max < sum) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
