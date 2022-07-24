package com.leetcode.arrays;

public class SubarrayProduct {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6},100));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int prod = 1;
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < nums.length) {
            prod *= nums[right];
            if (prod >= k) {
                prod = prod / nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
